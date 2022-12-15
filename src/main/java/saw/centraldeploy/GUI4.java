package saw.centraldeploy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI4 extends JFrame
{
    JList list;
    String[] listColorNames = {
            "Reload Explorer",
            "CMD Command Dialogue",
            "Management Tools",
            "Prebuilt Commands",
            "Powershell Command Dialogue",
    };
    Container contentpane;
    public GUI4()
    {
        super("CentralDeploy - Java");
        add(new JLabel("<html>CentralDeploy</html>", SwingConstants.CENTER),                BorderLayout.CENTER);
        setLocationRelativeTo(null); // this method display the JFrame to center position of a screen 

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
                      System.out.println("Reloading Explorer");
                     explorerrestart.explorerrestart();
                  }
                  if(index == 1) {
                        System.out.println("Command Prompt Dialogue.");
                     cmdinternal.cmdinternal();
                  }
                    if(index == 2) {
                        System.out.println("Management Tools Dialogue.");
                        managementtools.main();
                    }
                   if(index == 3) {
                       System.out.println("Prebuilt Commands Dialogue.");
                       prebuiltcmds.main();
                   }
                   if(index == 4) {
                       System.out.println("Powershell Command Dialogue.");
                       psinternal.psinternal();
                   }
               }
            }
        });
        setSize(230, 300);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        GUI4 test = new GUI4();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setResizable(false);
        test.setLocationRelativeTo(null);

    }
}  