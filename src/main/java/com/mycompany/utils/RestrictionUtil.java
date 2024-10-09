/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author hirraabdulmalik
 */
public class RestrictionUtil {
    // Method to add the KeyListener to multiple JTextFields
    public static void addDigitOnlyKeyListener(JTextField... textFields) {
        KeyAdapter digitOnlyKeyListener = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // If not a digit, ignore the event
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignore this key event
                }
            }
        };

        // Attach the KeyAdapter to each JTextField
        for (JTextField textField : textFields) {
            textField.addKeyListener(digitOnlyKeyListener);
        }
    }
}
