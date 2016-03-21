/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import javax.swing.JOptionPane;

/**
 *
 * @author ruth
 */
public class MessageDialogs {
    public static void uploadBox(String fileName, String titleBar)
    {
        String message = "Uploading " + fileName;
        JOptionPane.showMessageDialog(null, message, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
