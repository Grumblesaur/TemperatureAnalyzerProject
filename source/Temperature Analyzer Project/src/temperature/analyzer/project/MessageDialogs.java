/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperature.analyzer.project;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author rcatlett
 */
public class MessageDialogs {
    public static void uploadBox(String fileName, String titleBar)
    {
        String message = "Uploading " + fileName;
        JOptionPane.showMessageDialog(null, message, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void noConnectionError(String error)
    {
        String message =  error;
        JOptionPane.showMessageDialog(null, message, "Database Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Debug Dialog
    public static void showData(String location, String date, String temp) {
        String message = "Location: " + location + "\n String: " + date;
        message = message + "\n Temp: " + temp;
        
        JOptionPane.showMessageDialog(null, message, "Data to Upload", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void UploadError(String error) {
        String message =  error;
        JOptionPane.showMessageDialog(null, message, "Upload Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void DEBUG(String msg, boolean debug) {
        if (!debug) return;
        JOptionPane.showMessageDialog(null, msg, "DEBUG MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void UploadSuccess() {
        JOptionPane.showMessageDialog(null, "Upload Successful");
    }
   
}
