/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class MonthYearPicker extends JPanel {
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> yearComboBox;

    public MonthYearPicker() {
        setLayout(null); // Set layout for the panel

        // Create month JComboBox with month names
        String[] months = {"January", "February", "March", "April", "May", "June", 
                           "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);
        monthComboBox.setSelectedIndex(0); // Set default to January

        // Create year JComboBox with a range of years (2022 to 2100)
        Integer[] years = new Integer[79]; // Adjust this for the desired range
        for (int i = 0; i < years.length; i++) {
            years[i] = 2022 + i; // Fill with years from 2022 to 2100
        }
        yearComboBox = new JComboBox<>(years);
        yearComboBox.setSelectedItem(2024); // Set default to 2024

        // Add JComboBoxes to the panel
        add(monthComboBox);
        add(yearComboBox);
    }

    // Get the selected month as an integer (1-12)
    public int getSelectedMonth() {
        return monthComboBox.getSelectedIndex() + 1; // Convert index to month (1-12)
    }

    // Get the selected year
    public int getSelectedYear() {
        return (Integer) yearComboBox.getSelectedItem(); // Return selected year
    }
}

