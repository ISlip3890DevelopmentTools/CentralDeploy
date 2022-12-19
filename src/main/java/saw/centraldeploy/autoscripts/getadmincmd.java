package saw.centraldeploy.autoscripts;

import saw.centraldeploy.GUI4;
import saw.centraldeploy.constants;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.util.concurrent.TimeUnit;

public class getadmincmd {
    public static String cmdadmininput = "";
    public getadmincmd() throws URISyntaxException {
        if (!System.getProperties().getProperty("os.name").contains("Windows 11")) {
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + "Please check your Windows Version. Windows 11 is required to use this option. Current Windows Version: " + System.getProperties().getProperty("os.name") + ". ", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            String option = JOptionPane.showInputDialog("Please input the command you wish to run as administrator: \n Please note: This is unable to bypass a policy restriction put in place by GPedit. Use the CMD option instead on the main menu.");
            if(option == null){
                JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else {
                if (JOptionPane.showOptionDialog(null, "This command will execute a batch file to gain administrator access for that command.\n For security reasons, the UAC request batch file will expire after 20 seconds after pressing OK.", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) {

                    // Gets the current directory of the program
                    String currentDirectory = System.getProperty("user.dir");
                    CodeSource codeSource = GUI4.class.getProtectionDomain().getCodeSource();
                    // Gets the path of the jar file
                    String jarFile = codeSource.getLocation().toURI().getPath();
                    // Replaces the extra / with nothing
                    String jarDir = jarFile.replaceFirst("/", "");
                    // Same again
                    String replace = jarDir.replace("/", "\\");
                    // Gets the drive letter of the current directory
                    String driveLetter = jarDir.substring(0, 1);
                    // Ammeds the path to the resources folder
                    String url1 = jarDir + "/admincmd.bat";
                    // Output

                    String cmd = url1 + ""; // Put other parameters in the "";
                    // Replaces the jar file with nothing
                    String replace1 = cmd.replaceAll("CentralDeploy.jar/", "");
                    String replace2 = replace1.replaceAll("admincmd.bat/", "");
                    if (constants.debug == true) {
                        System.out.println("URL1: " + url1);
                        System.out.println("Old working directory : " + replace1);
                        System.out.println("Current working directory : " + replace2);
                        System.out.println("Drive Letter: " + driveLetter);
                        System.out.println("pathjar: " + jarFile);
                        System.out.println("pathjar2: " + jarDir);
                        System.out.println("FJD: " + replace1 + "/admincmd.bat");

                    } else {
                    }


                    //Checks if admincmd.bat exists if not make it
                    File file = new File(replace1);
                    try {
                        if (file.createNewFile()) {
                            System.out.println("UAC Prompt CMD file created at: " + file.getAbsolutePath());
                            // Writing to admincmd.bat if it doesn't exist
                            try {
                                FileWriter writecmd = new FileWriter(file);
                                if (constants.debug == true) {
                                    System.out.println("WriteCMD: " + writecmd);
                                    System.out.println("Writing to admincmd.bat");
                                } else {
                                }
                                // The contents of admincmd.bat
                                String cmdchange =
                                        ("@echo off" + "\n" +
                                                "REM --> Check for permissions" + "\n" +
                                                "    IF #%PROCESSOR_ARCHITECTURE%# EQU #amd64# (" + "\n" +
                                                ">nul 2>&1 #%SYSTEMROOT%\\SysWOW64\\cacls.exe# #%SYSTEMROOT%\\SysWOW64\\config\\system#" + "\n" +
                                                ") ELSE (" + "\n" +
                                                ">nul 2>&1 #%SYSTEMROOT%\\system32\\cacls.exe# #%SYSTEMROOT%\\system32\\config\\system#" + "\n" +
                                                ")" + "\n" +
                                                "" + "\n" +
                                                "REM" + "\n" +
                                                "if '%errorlevel%' NEQ '0' (" + "\n" +
                                                "   goto UACPrompt" + "\n" +
                                                "   echo UAC Prompt" + "\n" +
                                                ") else ( goto gotAdmin )" + "\n" +
                                                "" + "\n" +
                                                ":UACPrompt" + "\n" +
                                                "   echo Set UAC = CreateObject^(\"Shell.Application\"^) > \"%temp%\\getadmin.vbs\"\n" + "\n" +
                                                "   set params= %*" + "\n" +
                                                "   echo UAC.ShellExecute \"cmd.exe\", \"/c \"\"%~s0\"\" %params:\"=\"\"%\", \"\", \"runas\", 1 >> \"%temp%\\getadmin.vbs\"\n" + "\n" +
                                                "" + "\n" +
                                                "   #%temp%\\getadmin.vbs#" + "\n" +
                                                "   del #%temp%\\getadmin.vbs#" + "\n" +
                                                "   exit /B" + "\n" +
                                                "" + "\n" +
                                                ":gotAdmin" + "\n" +
                                                "   pushd #%CD%#" + "\n" +
                                                "   CD /D #%~dp0#" + "\n" +
                                                "   " + option + "" + "\n" +
                                                "   pause"

                                        );
                                String regex = "\"";
                                if (constants.debug == true) {
                                    System.out.println("Writing to admincmd.bat the replacement regex");
                                } else {
                                }

                                String cmdcomp = cmdchange.replaceAll("#", regex);
                                writecmd.write(cmdcomp);
                                if (constants.debug == true) {
                                    System.out.println("Writing finished");
                                } else {
                                }
                                writecmd.close();
                                if (constants.debug == true) {
                                    System.out.println("Writing closed");
                                } else {
                                }
                                if (constants.debug == true) {
                                    System.out.println("admincmd.bat has been written to in the directory" + file.getAbsolutePath());
                                } else {
                                }
//                           String replace2main = replace2.replace("/", "\\");
                                Runtime.getRuntime().exec("cmd.exe /k start C:\\Windows\\System32\\cmd.exe /k " + replace2);
                                if (constants.debug == true) {
                                    System.out.println("admincmd.bat has been executed");
                                } else {
                                }
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                            TimeUnit.SECONDS.sleep(20);
                            File myObj = file;
                            if (myObj.delete()) {
                                if (constants.debug == true) {
                                    System.out.println("Deleted the file: " + myObj.getName());
                                } else {
                                }
                            }

                        } else {
                            System.out.println("UAC Prompt CMD file already exists at: " + file.getAbsolutePath() + "It seems an error occurred and the file was not deleted. Please delete the file and try again.");
                        }

                    } catch (IOException | InterruptedException ex) {
                        JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        }

        }

    public static void main() throws URISyntaxException {
        getadmincmd test = new getadmincmd();
    }
}