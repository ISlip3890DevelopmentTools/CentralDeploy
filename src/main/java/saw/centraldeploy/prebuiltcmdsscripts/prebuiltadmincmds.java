package saw.centraldeploy.prebuiltcmdsscripts;

import saw.centraldeploy.autoscripts.getadmincmd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class prebuiltadmincmds extends JFrame{
        JList list;
        String[] listColorNames = {
                "Prebuilt - Make User Administrator Role",
                "Prebuilt - Make User Standard Role",
                "Prebuilt - Make User Guest Role",
                "Prebuilt - Software Deployment",
//                "Prebuilt - Background Advanced Information",
                "Prebuilt - Lock Computer",
                "Prebuilt - Restart Computer",
                "Prebuilt - Shutdown Computer",
                "Prebuilt - Logoff Computer",
                "Prebuilt - Administrative Command Dialogue",

        };
        Container contentpane;
        public prebuiltadmincmds()
        {
            super("CentralDeploy - Prebuilt Administrator Commands");
            contentpane = getContentPane();
            contentpane.setLayout(new FlowLayout());
            list = new JList(listColorNames);
            list.setSelectedIndex(0);
            list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            contentpane.add(new JScrollPane(list));
            list.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e) {
                    JList list = (JList) e.getSource();
                    if (e.getClickCount() == 2) {
                        int index = list.locationToIndex(e.getPoint());
                        if (index == 0) {
                            try {
                                System.out.println("Launching Prebuilt Command - Make User Administrator Role.");
                                String cmdinput = JOptionPane.showInputDialog("Input Username:");

                                String cmdoutput1 = "";
                                String cmdoutput = "net localgroup Administrators " + cmdinput + " /add";

                                try {
                                    if (cmdinput == null) {
                                        JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    } else {
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + "\"");
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        if (index == 1) {
                            try {
                                System.out.println("Launching Prebuilt Command - Make User Standard Role.");
                                String cmdinput = JOptionPane.showInputDialog("Input Username:");
                                String cmdoutput = "net localgroup Users " + cmdinput + " /add";

                                try {
                                    if (cmdinput == null) {
                                        JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    } else {
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + "\"");
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if (index == 2) {
                            try {
                                System.out.println("Launching Prebuilt Command - Make User Guest Role.");
                                String cmdinput = JOptionPane.showInputDialog("Input Username:");
                                String cmdoutput = "net localgroup Guests " + cmdinput + " /add";

                                try {
                                    if (cmdinput == null) {
                                        JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    } else {
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput  + "\"");
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if (index == 3) {
                            try {
                                System.out.println("Launching Prebuilt Command - Software Deployment.");
                                JFileChooser chooser = new JFileChooser();

                                try {
                                    if (chooser == null) {
                                        JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    } else if (chooser.showOpenDialog(list.getParent()) == JFileChooser.APPROVE_OPTION) {
                                        File file = chooser.getSelectedFile();
                                        if (file.isFile() == true && file.canExecute() == true && file.getName().endsWith(".exe") == true) {
                                            String file2 = chooser.getSelectedFile().getName();
                                            String msicmdoutput = "msiexec /passive /D=c:/Program Files/CentralDeploy/"+ file2 + "/l /qn /norestart /package " + file.getAbsolutePath();
                                            Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + file + "\n \n &&" + "echo ----------------------------------" + "&&" + file + "&& exit" + "\"");
                                        }else if(file.isFile() == true && file.canExecute() == true && file.getName().endsWith(".exe") == false && file.getName().endsWith(".msi") == true){
                                            String file2 = chooser.getSelectedFile().getName();

                                            String msiname = file.getAbsolutePath().replace(".msi", "");
                                            String msicmdoutput = "msiexec /i " + file.getAbsolutePath();

                                            Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + msicmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + msicmdoutput + "&& exit" + "\"");
                                        } else if(file.isFile() == true && file.canExecute() == true && file.getName().endsWith(".exe") == false && file.getName().endsWith(".msi") == false){
                                            JOptionPane.showMessageDialog(null, "The file you have selected is not an executable or a Windows installer package file. ", "Information", JOptionPane.WARNING_MESSAGE);
                                            return;
                                        }
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if (index == 4) {
                            try {
                                System.out.println("Launching Prebuilt Command - Lock Computer.");
                                if(JOptionPane.showOptionDialog(null, "Press YES to continue. ", "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {

                                    try {
                                        String cmdoutput = "rundll32.exe user32.dll,LockWorkStation";
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + "\"");

                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if (index == 5) {
                            try {
                                System.out.println("Launching Prebuilt Command - Restart Computer.");

                                try {
                                    if(JOptionPane.showOptionDialog(null, "Press YES to continue. ", "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
                                        String cmdoutput = "shutdown -r -t 0";
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + "\"");
                                    }
                                    } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if (index == 6) {
                            try {
                                System.out.println("Launching Prebuilt Command - Shutdown Computer.");

                                try {
                                    if(JOptionPane.showOptionDialog(null, "Press YES to continue. ", "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
                                        String cmdoutput = "shutdown -s -t 0";
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + "\"");
                                    }
                                    } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        if (index == 7) {
                            try {
                                System.out.println("Launching Prebuilt Command - Logoff Computer.");

                                try {
                                    if(JOptionPane.showOptionDialog(null, "Press YES to continue. ", "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
                                        String cmdoutput = "shutdown -l";
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + "\"");
                                    }
                                    } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        if (index == 8) {
                            try {
                                System.out.println("Launching Prebuilt Command - Administrative Command Prompt");

                                try {
                                    getadmincmd.main();
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                        }




                    }
                }
            });
            setSize(300, 300);
            setVisible(true);
        }
        public static void main()
        {
            prebuiltadmincmds test = new prebuiltadmincmds();
            test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            test.setResizable(false);
            test.setLocationRelativeTo(null);



        }
    }


