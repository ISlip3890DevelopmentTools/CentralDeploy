package saw.centraldeploy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class prebuiltcmds extends JFrame


    {
        JList list;
        String[] listColorNames = {
                "Prebuilt Administrator User",
                "Prebuilt Standard User",
        };
        Container contentpane;
        public prebuiltcmds()
        {
            super("CentralDeploy - Prebuilt Commands");
            contentpane = getContentPane();
            contentpane.setLayout(new FlowLayout());
            list = new JList(listColorNames);
            list.setSelectedIndex(0);
            list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            contentpane.add(new JScrollPane(list));
            list.addMouseListener(new MouseAdapter()
            {
                public void mouseClicked(MouseEvent e) {
                        JList list = (JList)e.getSource();
                        if(e.getClickCount() == 2) {
                        int index = list.locationToIndex(e.getPoint());
                        if(index == 0) {
                            try {
                                System.out.println("Prebuilt Administrator User");
                                saw.centraldeploy.prebuiltcmdsscripts.prebuiltadmincmds.main();

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        if(index == 1) {

                            try {
                                System.out.println("Prebuilt Administrator User");
                                saw.centraldeploy.prebuiltcmdsscripts.prebuildstandarduser.main();
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
            prebuiltcmds test = new prebuiltcmds();
            test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            test.setResizable(false);
            test.setLocationRelativeTo(null);

        }
    }

