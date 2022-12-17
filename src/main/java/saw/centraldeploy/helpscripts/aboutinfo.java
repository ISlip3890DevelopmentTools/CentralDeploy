package saw.centraldeploy.helpscripts;

import saw.centraldeploy.constants;

import javax.swing.*;

import static saw.centraldeploy.constants.year;

public class aboutinfo {
    public static void aboutinfo() {
        try {

            JOptionPane.showMessageDialog(null, "" +
                    "CentralDeploy \n" +
                    "Version: v" + constants.version + "\n" +
                    "CentralDeploy is a free and open source project. " + "\n" +
                    "Copyright © ISlip3890DevelopmentTools 2022 - " + year + ". All rights reserved. " + "\n" +
                    "CentralDeploy is licensed under the BSD 2-Clause License" + "\n" +
                    "", "CentralDeploy - About", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception except) {
            JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + except, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}

