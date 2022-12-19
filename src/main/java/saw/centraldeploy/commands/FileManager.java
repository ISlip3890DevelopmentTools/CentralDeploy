package saw.centraldeploy.commands;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager extends JFrame {
    private JPanel mainPanel;
    private JTree fileTree;
    private JButton copyButton;
    private JLabel statusLabel;
    private JFileChooser fileChooser;

    public FileManager() {
        setTitle("CentralDeploy - Copy Files");
        setSize(200, 170);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the file tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("File/Directory Copy");
        fileTree = new JTree(root);
        setPreferredSize(new Dimension(320, 130));

        mainPanel.add(fileTree, BorderLayout.CENTER);

        // Create the copy button and status label
        JPanel buttonPanel = new JPanel();
        copyButton = new JButton("Copy");
        copyButton.addActionListener(new CopyButtonListener());
        buttonPanel.add(copyButton);
        statusLabel = new JLabel("Awaiting Action...");
        buttonPanel.add(statusLabel);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Create the file chooser
        fileChooser = new JFileChooser();
        fileChooser.setVisible(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        add(mainPanel);
    }

    // Event listener for the copy button
    private class CopyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Show the file chooser and get the selected file or folder
            int result = fileChooser.showOpenDialog(mainPanel);
            if (result == JFileChooser.APPROVE_OPTION) {
                Path source = fileChooser.getSelectedFile().toPath();
                // Show the file chooser again and get the destination folder
                result = fileChooser.showSaveDialog(mainPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    Path destination = fileChooser.getSelectedFile().toPath();
                    try {
                        // Copy the file or folder to the destination
                        Files.copy(source, destination);
                        statusLabel.setText("Successful.");
                        dispose();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "It seems an error has occurred. \n Error is: \n " + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    public static void main()
    {
        System.out.println("FM Active");
        FileManager test = new FileManager();
        test.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        test.setVisible(true);
        test.setResizable(false);
    }
}