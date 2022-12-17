/*
Verbose Creator - True or false in config
 */


package saw.centraldeploy.commands;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class explorerrestart {
    public static void explorerrestart() {
        try {
            // Start CMD with no cmds
            //Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
             if(JOptionPane.showOptionDialog(null, "Press YES to continue. ", "Information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null) == JOptionPane.YES_OPTION) {
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"taskkill /f /im explorer.exe && start userinit.exe && exit\"");
            }else {
                JOptionPane.showMessageDialog(null, "You have cancelled the command. ", "Information", JOptionPane.WARNING_MESSAGE);
                return;
            }



        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ioe, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        try {
            String line;
            String pidInfo ="";

            Process p =Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");

            BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo+=line;
            }

            input.close();

            if(pidInfo.contains("explorer.exe")) {
            }else
                System.out.println("Readline states null above, restarting explorer");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"start userinit.exe && exit \"");



            System.out.println("Going for sleep for 7 secs");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /k \"taskkill /f /im cmd.exe\"");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ioe, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Resumed after 7 secs");

        try {
            String line;
            String pidInfo ="";

            Process p =Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");

            BufferedReader input =  new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((line = input.readLine()) != null) {
                pidInfo+=line;
            }

            input.close();

            if(pidInfo.contains("userinit.exe")) {
                System.out.println("Exiting 0");
                return;
            }else
                System.out.println("Readline states null, restarting userinit");
            Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"start userinit.exe && exit \"");

//                String line;
//                Process proc = Runtime.getRuntime().exec("explorer.exe");
//                BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//                OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
//                oStream .write("process where name='explorer.exe'");
//                oStream .flush();
//                oStream .close();
//                if ((line = input.readLine()) != null) {
//                    System.out.println("Readline states not null");
//                } else{

//                }
//                input.close();


        }catch (Exception except){
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + except, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}