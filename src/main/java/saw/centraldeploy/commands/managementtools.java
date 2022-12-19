package saw.centraldeploy.commands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class managementtools extends JFrame
{
    JList list;
    String[] listColorNames = {
            "Disk Management",
            "Device Manager",
            "System Information",
            "Group Policy Editor",
            "Event Viewer",
            "Performance Monitor",
            "System Configuration",
            "System Restore",
            "Task Manager",
            "Windows Firewall",
            "Windows Update",
            "Windows Defender",
            "Windows Security Center",
            "Settings",
            "Control Panel",
            "Registry Editor",
            "Command Prompt",
            "Windows PowerShell",
            "Windows PowerShell ISE",
            "Windows Explorer",
            "Network Connections",
            "Disk Defragmenter",
            "Windows Memory Diagnostics",
            "Windows Troubleshooting",
            "Services",
            "Netplwiz",
            "Disk Cleanup",
            "Windows Terminal",
            "Run"
    };
    Container contentpane;
    public managementtools()
    {
        super("CentralDeploy - Management Tools");
        contentpane = getContentPane();
        contentpane.setLayout(new FlowLayout());
        list = new JList(listColorNames);
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        contentpane.add(new JScrollPane(list));
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    if (index == 0) {
                        try {
                            System.out.println("Launching Disk Management.");
                            Runtime.getRuntime().exec("cmd /c start diskmgmt.msc");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                    if (index == 1) {
                        System.out.println("Launching Device Management.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 2) {
                        System.out.println("Launching System Information.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start msinfo32.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 3) {
                        System.out.println("Launching Group Policy Editor.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start gpedit.msc");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 4) {
                        System.out.println("Launching Event Viewer.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start eventvwr.msc");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 5) {
                        System.out.println("Launching Performance Monitor.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start perfmon.msc");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 6) {
                        System.out.println("Launching System Configuration.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start msconfig.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 7) {
                        System.out.println("Launching System Restore.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start rstrui.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 8) {
                        System.out.println("Launching Task Manager.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start taskmgr.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 9) {
                        System.out.println("Launching Windows Firewall.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start wf.msc");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 10) {
                        System.out.println("Launching Windows Update.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start ms-settings:windowsupdate");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 11) {
                        System.out.println("Launching Windows Defender.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start ms-settings:windowsdefender");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (index == 12) {
                        System.out.println("Launching Windows Security Center.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start wscui.cpl");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 13) {
                        System.out.println("Launching Settings.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start ms-settings:");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 14) {
                        System.out.println("Launching Control Panel.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start control.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 15) {
                        System.out.println("Launching Registry Editor.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start regedit.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 16) {
                        System.out.println("Launching Command Prompt.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start cmd.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 17) {
                        System.out.println("Launching Windows PowerShell.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start powershell.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 18) {
                        System.out.println("Launching Windows PowerShell ISE.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start powershell_ise.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 19) {
                        System.out.println("Launching Windows Explorer.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start explorer.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (index == 20) {
                        System.out.println("Launching Network Connections.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start ncpa.cpl");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    if (index == 21) {
                        System.out.println("Launching Disk Defragmenter.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start dfrgui.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 22) {
                        System.out.println("Launching Windows Memory Diagnostics.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start mdsched.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 23) {
                        System.out.println("Launching Windows Troubleshooter.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start ms-settings:troubleshoot");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 24) {
                        System.out.println("Launching Services.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start services.msc");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 25) {
                        System.out.println("Launching Netplwiz.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start netplwiz.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 26) {
                        System.out.println("Launching Disk Cleanup.");
                        try {
                            Runtime.getRuntime().exec("cmd /c start cleanmgr.exe");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 27) {
                        if (!System.getProperties().getProperty("os.name").contains("Windows 11")) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + "Please check your Windows Version. Windows 11 is required to use this option. Current Windows Version: " + System.getProperties().getProperty("os.name") + ". ", "ERROR", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            System.out.println("Launching Windows 11 Terminal.");
                            try {
                                Runtime.getRuntime().exec("cmd /c start wt.exe");
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    if (index == 28) {
                        System.out.println("Launching Run");
                        try {
                            Runtime.getRuntime().exec("cmd /c c:\\windows\\system32\\rundll32.exe shell32.dll,#61");
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
        managementtools test = new managementtools();
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.setResizable(false);
        test.setLocationRelativeTo(null);

    }
}