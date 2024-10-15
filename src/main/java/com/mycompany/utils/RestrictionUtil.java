/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
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
    public static double AddZeroWhenEmpty(JTextField textField){
        try {
    String inputText = textField.getText().trim(); // Get text and remove leading/trailing spaces

    // If the field is empty, set the value to 0
    double value;
    if (inputText.isEmpty()) {
        value = 0.0; // Default value for empty input
        textField.setText("0"); // Optionally set the field to display "0"
    } else {
        value = Double.parseDouble(inputText); // Parse input if not empty
    }

    // Use value as needed
    return value;
} catch (NumberFormatException e) {
    // Handle case where the input is not a valid number
    JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
    return 0.0;
}
    }
}
