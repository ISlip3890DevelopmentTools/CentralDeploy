package saw.centraldeploy.commands;

import javax.swing.*;
import java.io.IOException;

public class cmdinternal {
    public static void cmdinternal() {
// Create panel with components and bottom

        String cmdinput =  JOptionPane.showInputDialog("Please input a command.");
        try {
            if(cmdinput == null) {
                JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else {
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) && echo Command Received from CentralDeploy: " + cmdinput + "\n \n &&" + "echo ----------------------------------" + "&&" + cmdinput + "\"");
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
