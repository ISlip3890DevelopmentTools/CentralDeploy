/*
Verbose Creator - True or false in config
 */


package saw.centraldeploy.helpscripts;

import javax.swing.*;

public class helpinfo {
    public static void helpinfo() {
        try {
            // Start CMD with no cmds
            //Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
            if(JOptionPane.showOptionDialog(null, "This will open the GitHub wiki for CentralDeploy. Press OK to continue. ", "Information", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) {
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"start msedge https://github.com/ISlip3890DevelopmentTools/CentralDeploy/wiki && exit\"");
            }else {
                JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }


        }catch (Exception except){
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + except, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}