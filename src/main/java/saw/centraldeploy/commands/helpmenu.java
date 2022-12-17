package saw.centraldeploy.commands;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class helpmenu extends JFrame
{
    JList list;
        String[] listhelp = {
                "Help",
                "About",
                "Force Exit Program"
        };
        Container contentpane;

        public helpmenu()
        {
            super("CentralDeploy - Help Menu");
            contentpane = getContentPane();
            contentpane.setLayout(new FlowLayout());
            list = new JList(listhelp);
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
                            System.out.println("Help");
                            saw.centraldeploy.helpscripts.helpinfo.helpinfo();
                        }
                        if (index == 1) {
                            System.out.println("About");
                            saw.centraldeploy.helpscripts.aboutinfo.aboutinfo();
                        }
                        if (index == 2) {
                            System.out.println("Force Exit Program");
                            System.exit(0);
                        }
                        }

                    }

            });
            setSize(300, 300);
            setVisible(true);


    }
    public static void main()
    {

        helpmenu test = new helpmenu();
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.setResizable(false);
        test.setLocationRelativeTo(null);

    }
}
