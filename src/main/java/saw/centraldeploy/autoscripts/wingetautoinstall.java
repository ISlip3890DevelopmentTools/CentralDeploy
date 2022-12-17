package saw.centraldeploy.autoscripts;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static javax.swing.JOptionPane.WARNING_MESSAGE;

public class wingetautoinstall {
    public static void wingetautoinstall() {

        String wingetinstaller = "Invoke-WebRequest -Uri https://github.com/microsoft/winget-cli/releases/download/v1.3.2691/Microsoft.DesktopAppInstaller_8wekyb3d8bbwe.msixbundle -OutFile .\\MicrosoftDesktopAppInstaller_8wekyb3d8bbwe.msixbundle";
        String wingetinstall = "Add-AppxPackage MicrosoftDesktopAppInstaller_8wekyb3d8bbwe.msixbundle";
        try {
                if(JOptionPane.showOptionDialog(null, "Press YES to continue to download and install WinGET from GitHub.\n After downloading, the service will wait for ~20 seconds to verify download completion. ", "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
                    Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"start powershell " + wingetinstaller + " && exit\"");
                    TimeUnit.SECONDS.sleep(20); // To verify the download has completed.
                    Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"start powershell " + wingetinstall + "\"");


                }else {
                    JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", WARNING_MESSAGE);
                    return;
                }
            } catch (IOException | InterruptedException ioe) {
                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ioe, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            }

}
