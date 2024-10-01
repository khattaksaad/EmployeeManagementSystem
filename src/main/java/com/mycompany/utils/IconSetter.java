/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author hirraabdulmalik
 */
public class IconSetter {
    public static void SetIcon(JFrame frame)
    {
         // Static method to set icon for any JFrame
        URL url = frame.getClass().getResource("/images/calendar.png");
        // Load the icon from the provided path
        ImageIcon icon = new ImageIcon(url);

        // Set the icon for the given JFrame
        frame.setIconImage(icon.getImage());
    }
}
