package saw.centraldeploy.prebuiltcmdsscripts;

import saw.centraldeploy.commands.listinstalled;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class prebuildstandarduser extends JFrame{
    JList list;
    String[] listColorNames = {
            "Prebuilt - IPConfig",
            "Prebuilt - DNS Lookup",
            "Prebuilt - Ping",
            "Prebuilt - Traceroute",
            "Prebuilt - Open a website",
            "Prebuilt - Open Drive Letter",
            "Prebuilt - List installed Apps",
            "Prebuilt - Copy Files/Directories",
    };
    Container contentpane;
    public prebuildstandarduser()
    {
        super("CentralDeploy - Prebuilt Standard Commands");
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
                            System.out.println("Launching Prebuilt Command - IPConfig");
                            try {
                                Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + "ipconfig" + "\n \n &&" + "echo ----------------------------------" + "&&" + "ipconfig" + "\"");
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 1) {
                        try {
                            System.out.println("Launching Prebuilt Command - DNS Lookup");
                            try {
                                Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + "nslookup" + "\n \n &&" + "echo ----------------------------------" + "&&" + "nslookup" + "\"");
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (index == 2) {
                        try {
                            System.out.println("Launching Prebuilt Command - Ping");
                            try {
                                String cmdinput = JOptionPane.showInputDialog("Input IP/Domain:");
                                String cmdoutput = "ping -t " + cmdinput;

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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 3) {
                        try {
                            System.out.println("Launching Prebuilt Command - TraceRoute");
                            try {
                                String cmdinput = JOptionPane.showInputDialog("Input IP/Domain:");
                                String cmdoutput = "tracert " + cmdinput;

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
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 4) {
                        try {
                            System.out.println("Launching Prebuilt Command - Launch Website");
                            try {
                                String cmdinput = JOptionPane.showInputDialog("Input Domain:");
                                String cmdoutput = "start msedge " + cmdinput;

                                try {
                                    if (cmdinput == null) {
                                        JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    } else {
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + " && " + "exit" + "\"");
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K taskkill /f /im cmd.exe");
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 5) {
                        try {
                            System.out.println("Launching Prebuilt Command - Open Drive Letter");
                            try {
                                String cmdinput = JOptionPane.showInputDialog("Input Drive Letter (e.g C: D: E:):");
                                String cmdoutput = "explorer.exe " + cmdinput;

                                try {
                                    if (cmdinput == null) {
                                        JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                                        return;
                                    } else {
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdoutput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdoutput + "\"");
                                        Runtime.getRuntime().exec("cmd /c start cmd.exe /K taskkill /f /im cmd.exe");
                                    }
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
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
                            System.out.println("Launching Prebuilt Command - List installed Apps");
                            try {
                                listinstalled.main();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 7) {
                        try {
                            System.out.println("Launching Prebuilt Command - Copy Files/Directories");
                            try {
                                saw.centraldeploy.commands.FileManager.main();
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
    public static void main() {
        prebuildstandarduser test = new prebuildstandarduser();
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.setResizable(false);
        test.setLocationRelativeTo(null);
        if (SystemTray.isSupported()) {
            System.out.println("SystemTray is supported - Toast Notifications will be displayed");
        }else{
            System.out.println("SystemTray is not supported - Toast Notifications will not be displayed");
        }
    }
}


