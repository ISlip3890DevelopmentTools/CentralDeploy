package saw.centraldeploy.commands;

import javax.swing.*;
import java.io.IOException;

public class wingetlistpkgs {
    public static void wingetlistpkgs() {
        try {
            Runtime.getRuntime().exec("cmd /c \"start shell:AppsFolder\"");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ioe, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}