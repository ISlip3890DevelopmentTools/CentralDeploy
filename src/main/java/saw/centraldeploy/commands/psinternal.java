package saw.centraldeploy.commands;

import javax.swing.*;
import java.io.IOException;

public class psinternal {
    public static void psinternal() {
// Create panel with components and bottom

        String psinput =  JOptionPane.showInputDialog("Please input a powershell command.");
        try {
            if(psinput == null) {
                JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else {
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) &&" +
                        " echo There will be a delay between executing the command in CentralDeploy and the output. Approx 1s-15s depending on machine" +
                        "&& echo Command Received from CentralDeploy: " + "powershell " + psinput + "\n \n &&" + "echo ----------------------------------" + "&&" + "powershell " + psinput + "\"");
            }
        } catch (IOException ioe){
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ioe, "ERROR", JOptionPane.ERROR_MESSAGE);

        }

//        JPanel panel = new JPanel(); // the panel is not visible in output
//        JLabel label = new JLabel("Enter Text");
//        JTextField tf = new JTextField(10); // accepts upto 10 characters
//        JButton send = new JButton("Send");
//        JButton reset = new JButton("Reset");
//        panel.add(label); // Components Added using Flow Layout
//        panel.add(tf);
//        panel.add(send);
//        panel.add(reset);
//
//        // Text Area at the Center
//        JTextArea ta = new JTextArea();
    }
}
