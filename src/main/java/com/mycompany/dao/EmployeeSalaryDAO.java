/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

/**
 *
 * @author hirraabdulmalik
 */
import com.mycompany.database.SQLConnection;
import com.mycompany.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryDAO {

    // Method to create a new EmployeeSalary record
    public boolean createEmployeeSalary(EmployeeSalary4DB employeeSalary) throws SQLException {
        boolean result = true;
        String sql = "INSERT INTO EmployeeSalary (Bonus, TotalSalary, EmployeeID, SalaryDate) VALUES (?, ?, ?, ?)";
        try (Connection conn = SQLConnection.connect(); // Establish connection here
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, employeeSalary.getBonus());
            pstmt.setDouble(2, employeeSalary.getTotalSalary());
            pstmt.setInt(3, employeeSalary.getEmployeeID());
            pstmt.setString(4, (employeeSalary.getSalaryDate()));
            pstmt.executeUpdate();
        }
        
        return result; 
    }

    // Method to read all EmployeeSalary records
    public List<EmployeeSalary4DB> getAllEmployeeSalaries() throws SQLException {
        List<EmployeeSalary4DB> employeeSalaries = new ArrayList<>();
        String sql = "SELECT * FROM EmployeeSalary";

        try (Connection conn = SQLConnection.connect(); // Establish connection here
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                double bonus = rs.getDouble("Bonus");
                double totalSalary = rs.getDouble("TotalSalary");
                int employeeID = rs.getInt("EmployeeID");
                String salaryDate = rs.getString("SalaryDate");

                EmployeeSalary4DB employeeSalary = new EmployeeSalary4DB(id, bonus, totalSalary, employeeID, salaryDate);
                employeeSalaries.add(employeeSalary);
            }
        }
        return employeeSalaries;
    }

    // Method to update an existing EmployeeSalary record
    public void updateEmployeeSalary(EmployeeSalary4DB employeeSalary) throws SQLException {
        String sql = "UPDATE EmployeeSalary SET Bonus = ?, TotalSalary = ?, EmployeeID = ?, SalaryDate = ? WHERE ID = ?";
        try (Connection conn = SQLConnection.connect(); // Establish connection here
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, employeeSalary.getBonus());
            pstmt.setDouble(2, employeeSalary.getTotalSalary());
            pstmt.setInt(3, employeeSalary.getEmployeeID());
            pstmt.setString(4, (employeeSalary.getSalaryDate()));
            pstmt.setInt(5, employeeSalary.getId());
            pstmt.executeUpdate();
        }
    }

    // Method to delete an EmployeeSalary record
    public void deleteEmployeeSalary(int id) throws SQLException {
        String sql = "DELETE FROM EmployeeSalary WHERE ID = ?";
        try (Connection conn = SQLConnection.connect(); // Establish connection here
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}

