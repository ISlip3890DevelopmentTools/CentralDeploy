package saw.centraldeploy.prebuiltcmdsscripts;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static org.apache.commons.io.FileUtils.copyFile;
import static org.apache.commons.io.FileUtils.moveFile;

public class prebuildstandarduser extends JFrame{
    JList list;
    String[] listColorNames = {
            "Prebuilt - IPConfig",
            "Prebuilt - DNS Lookup",
            "Prebuilt - Ping",
            "Prebuilt - Traceroute",
            "Prebuilt - Open a website",
            "Prebuilt - Open Drive Letter",
//            "Prebuilt - Copy Files (IN DEVELOPMENT)",
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

                    // NOT TESTED. IN DEVELOPMENT.
                     if (index == 900) {
                        try {
                            try {
                                JFileChooser chooser = new JFileChooser();
                                chooser.setMultiSelectionEnabled(true);
                                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                                chooser.setFileHidingEnabled(false);

                                chooser.setDialogTitle("Select Files to Copy");
                                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                                    java.io.File f = chooser.getSelectedFile();
                                    System.err.println(f.getPath());
                                }
//                                if(chooser == null){
//                                    chooser.cancelSelection();
//                                    JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
//                                    return;
//                                }


                                JFileChooser dirchoose = new JFileChooser();
                                dirchoose.setMultiSelectionEnabled(true);
                                dirchoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                                dirchoose.setFileHidingEnabled(false);
                                dirchoose.setDialogTitle("Select the location for files to be copied to");
                                if (dirchoose.showOpenDialog(null) == JFileChooser.DIRECTORIES_ONLY) {
                                    java.io.File f = chooser.getSelectedFile();
                                    System.err.println(f.getPath());
                                }
//                                if(dirchoose == null){
//                                    dirchoose.cancelSelection();
//                                    JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
//                                    return;
//                                }
//

                                File[] selectedFiles = chooser.getSelectedFiles();
                                for (File file : selectedFiles) {
                                    try {
                                        if (dirchoose.getCurrentDirectory().getAbsolutePath() == null) {
                                            JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                                            return;
                                        } else {
                                            //

                                            SystemTray tray = SystemTray.getSystemTray();
                                            Image image = Toolkit.getDefaultToolkit().createImage("");
                                            TrayIcon trayIcon = new TrayIcon(image, "CentralDeploy");
                                            trayIcon.setToolTip("CentralDeploy - File Transfer");
                                            tray.add(trayIcon);
                                            java.io.File f = chooser.getSelectedFile();
                                            if (f.isFile()) {
                                                // copy file
                                                trayIcon.displayMessage("CentralDeploy - File Transfer", "File Transfer has started. Please wait...", TrayIcon.MessageType.INFO);

                                                FileUtils.copyFileToDirectory(new File(f.getAbsolutePath()), new File(dirchoose.getSelectedFile().getAbsolutePath()));

                                            } else {
                                                // copy directory
                                                trayIcon.displayMessage("CentralDeploy - Directory Transfer", "Directory Transfer has started. Please wait...", TrayIcon.MessageType.INFO);

                                                FileUtils.copyDirectoryToDirectory(new File(f.getAbsolutePath()), new File(dirchoose.getSelectedFile().getAbsolutePath()));

                                            }
                                            if (f.equals(null)) {
                                                trayIcon.displayMessage("CentralDeploy - Transfer", "Transfer has failed. Please try again.", TrayIcon.MessageType.ERROR);
                                            } else {
                                                trayIcon.displayMessage("CentralDeploy - Transfer", "Transfer has been completed.", TrayIcon.MessageType.INFO);

                                            }

                                        }

                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
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


