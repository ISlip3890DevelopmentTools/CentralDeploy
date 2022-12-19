package saw.centraldeploy.commands;

import javax.swing.*;
import java.io.IOException;

public class listinstalled {
    public static void main() {
        try{
            if(JOptionPane.showOptionDialog(null, "Press YES to continue. ", "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
                Runtime.getRuntime().exec("cmd /c \"start shell:AppsFolder\"");
            }else{
                JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ioe, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
