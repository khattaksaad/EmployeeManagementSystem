/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

/**
 *
 * @author hirraabdulmalik
 */
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ResolvedStatusRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Call the parent method to get the default renderer component
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Check if the value is an Integer and if it is either 0 or 1
        if (value instanceof Integer) {
            int intValue = (Integer) value;
            if (intValue == 0) {
                setText("Not Resolved");
            } else if (intValue == 1) {
                setText("Resolved");
            } else {
                setText("Unknown"); // Handle unexpected values
            }
        }

        return cell;
    }
}

