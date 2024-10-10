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
import javax.swing.table.DefaultTableModel;

public class EmployeeSalaryTableModel extends DefaultTableModel {
    
    // Define column names
    private final String[] columnNames = {
            "EmployeeID",
            "Name",
            "Monthly Salary",
            "Bonus",
            "Carry Forward",
            "Advance",
            "Deduction",
            "Mess Bill",
            "Calculated Salary"
    };

    public EmployeeSalaryTableModel() {
        super(new Object[][]{}, new String[] {"EmployeeID","Name", "Monthly Salary", "Bonus", "Carry Forward", "Advance", "Deduction", "Mess Bill", "Calculated Salary"});
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Allow editing for all columns
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        // Enforce type safety
        switch (column) {
            case 2: // Monthly Salary
            case 3: // Bonus
            case 4: // Carry Forward
            case 5: // Advance
            case 6: // Deduction
            case 7: // Mess Bill
                if (aValue instanceof Number) {
                    super.setValueAt(aValue, row, column);
                } else if (aValue instanceof String) {
                    try {
                        // Try parsing the String to Double
                        double value = Double.parseDouble((String) aValue);
                        super.setValueAt(value, row, column);
                    } catch (NumberFormatException e) {
                        // If parsing fails, show an error message or handle accordingly
                        throw new IllegalArgumentException("Invalid input for column " + columnNames[column] + ": must be a number.");
                    }
                } else {
                    // If the input is not a number or string, show an error message
                    throw new IllegalArgumentException("Invalid input for column " + columnNames[column] + ": must be a number.");
                }
                                // Recalculate the Calculated Salary after updating relevant fields
                recalculateCalculatedSalary(row);
                break;
            default:
                super.setValueAt(aValue, row, column);
                break;
        }
    }
private void recalculateCalculatedSalary(int row) {
        try {
            double salary = (Double) getValueAt(row, 2);  // Monthly Salary
            double bonus = (Double) getValueAt(row, 3);   // Bonus
            double carryForward = (Double) getValueAt(row, 4); // Carry Forward
            double advance = (Double) getValueAt(row, 5);  // Advance
            double deduction = (Double) getValueAt(row, 6); // Deduction
            double messBill = (Double) getValueAt(row, 7);  // Mess Bill

            // Calculate the total calculated salary
            double totalCalculatedSalary = salary + bonus - (advance + deduction + messBill);

            // Update the Calculated Salary column (index 7)
            setValueAt(totalCalculatedSalary, row, 8); // Calculated Salary
        } catch (ClassCastException e) {
            // Handle any casting issues or log the error
            e.printStackTrace();
        }
    }
    @Override
    public Object getValueAt(int row, int column) {
        return super.getValueAt(row, column);
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}

