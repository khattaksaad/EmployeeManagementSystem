/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import com.mycompany.dao.EmployeeDAO;
import com.mycompany.model.Employee;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author hirraabdulmalik
 */
public class EmployeeHash {
    private static HashMap<String, Integer> employeeMap; 
    public static void PopulateComboBox(JComboBox jComboBoxEmployeeNames) throws SQLException
    {
        employeeMap = new HashMap<>();
        EmployeeDAO emp = new EmployeeDAO();
        jComboBoxEmployeeNames.removeAllItems();
        List<Employee> emps = emp.getAllEmployees();
        for (int i = 0; i < emps.size(); i++) {
            employeeMap.put(emps.get(i).getName(), emps.get(i).getEmployeeID());
        jComboBoxEmployeeNames.addItem(emps.get(i).getName()); 
        }
    }
    public static int GetEmployeeID(JComboBox jComboBoxEmployeeNames)
    {
        int employeeId = -1;
                String selectedEmployee = (String) jComboBoxEmployeeNames.getSelectedItem();
                if (selectedEmployee != null) {
                    // Get the corresponding ID
                     employeeId = employeeMap.get(selectedEmployee);}
                    return employeeId;
    }
}
