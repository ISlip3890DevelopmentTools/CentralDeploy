package saw.centraldeploy.autoscripts;

import javax.swing.*;
import java.io.IOException;

public class wingetautoremove {
    public static void wingetautoremove() {
        String cmdinput = JOptionPane.showInputDialog("Input the Winget package to remove: ");

        try {
            if(cmdinput == null) {
                JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }else {
                String psinput = "%LOCALAPPDATA%\\Microsoft\\WindowsApps\\winget\" uninstall " + cmdinput;
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K" + "\"" + "echo Please note: This prompt depends on your USER rank. (e.g Administrator) &&" +
                        " echo There will be a delay between executing the command in CentralDeploy and the output. Approx 1s-15s depending on machine" +
                        "&& echo Command Received from CentralDeploy: " + "start powershell " + psinput + "\n \n &&" + "echo ----------------------------------" + "&&" + "start powershell " + psinput + "\"");
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ioe, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}