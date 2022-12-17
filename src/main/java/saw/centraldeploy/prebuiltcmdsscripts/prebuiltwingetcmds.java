package saw.centraldeploy.prebuiltcmdsscripts;

import saw.centraldeploy.autoscripts.wingetautoinstall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class prebuiltwingetcmds extends JFrame{
    JList list;
    String[] listColorNames = {
            "WinGET - Download and Install",
            "WinGET - Install a package",
            "WinGET - Remove a package",
            "WinGET - List Installed Packages",

//            "Prebuilt - Copy Files (IN DEVELOPMENT)",
    };
    Container contentpane;
    public prebuiltwingetcmds()
    {
        super("CentralDeploy - WinGET Commands");
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
                            System.out.println("Launching Prebuilt Winget Command - Download and Install WinGET");
                            wingetautoinstall.wingetautoinstall();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 1) {
                        try {
                            System.out.println("Launching Prebuilt Winget Command - Install a package");
                            saw.centraldeploy.commands.wingetpackageinstall.wingetpackageinstall();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }

                }
                    if (index == 2) {
                        try {
                            System.out.println("Launching Prebuilt Winget Command - Remove a package");
                            saw.centraldeploy.autoscripts.wingetautoremove.wingetautoremove();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    if (index == 3) {
                        try {
                            System.out.println("Launching Prebuilt Winget Command - List packages");
                            saw.centraldeploy.commands.wingetlistpkgs.wingetlistpkgs();
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
        prebuiltwingetcmds test = new prebuiltwingetcmds();
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


