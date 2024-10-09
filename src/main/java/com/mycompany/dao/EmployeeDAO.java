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
import com.mycompany.model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private final Connection connection;

    // Constructor: Establish a connection to the SQLite database
    public EmployeeDAO() throws SQLException {
         connection = SQLConnection.connect();
        //connection = DriverManager.getConnection("jdbc:sqlite:salary_management.db");
    }

    // Add a new Employee
    public boolean addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO Employee (Name, FatherName, CNICNo, ReferenceName, DepartmentID, DateOfJoining, DateOfTermination, Qualification, SalaryDecided, CarryForward) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, employee.getName());
        pstmt.setString(2, employee.getFathersName());
        pstmt.setString(3, employee.getCnicNo());
        pstmt.setString(4, employee.getReferenceName());
        pstmt.setInt(5, employee.getDepartmentID());
        pstmt.setString(6, "2024-10-09");
        pstmt.setString(7, "2024-10-10");
        pstmt.setString(8, employee.getQualification());
        pstmt.setDouble(9, employee.getSalaryDecided());
        pstmt.setDouble(10, employee.getCarryForward());

        return pstmt.executeUpdate() > 0;
    }

    // Update an existing Employee
    public boolean updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE Employee SET Name=?, FatherName=?, CNICNo=?, ReferenceName=?, DepartmentID=?, DateOfJoining=?, DateOfTermination=?, Qualification=?, SalaryDecided=?, CarryForward=? WHERE EmployeeID=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, employee.getName());
        pstmt.setString(2, employee.getFathersName());
        pstmt.setString(3, employee.getCnicNo());
        pstmt.setString(4, employee.getReferenceName());
        pstmt.setInt(5, employee.getDepartmentID());
        pstmt.setString(6, employee.getDateOfJoining());
        pstmt.setString(7, employee.getDateOfTermination());
        pstmt.setString(8, employee.getQualification());
        pstmt.setDouble(9, employee.getSalaryDecided());
        pstmt.setDouble(10, employee.getCarryForward());
        pstmt.setInt(11, employee.getEmployeeID());

        return pstmt.executeUpdate() > 0;
    }

    // Delete an Employee by ID
    public boolean deleteEmployee(int employeeID) throws SQLException {
        String query = "DELETE FROM Employee WHERE EmployeeID=?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, employeeID);
        return pstmt.executeUpdate() > 0;
    }

    // Get all Employees
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employee";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Employee employee = new Employee(
                rs.getInt("EmployeeID"),
                rs.getString("Name"),
                rs.getString("FatherName"),
                rs.getString("CNICNo"),
                rs.getString("ReferenceName"),
                rs.getInt("DepartmentID"),
                rs.getString("DateOfJoining"),
                rs.getString("DateOfTermination"),
                rs.getString("Qualification"),
                rs.getDouble("SalaryDecided"),
                rs.getInt("CarryForward")
            );
            employee.setEmployeeID(rs.getInt("EmployeeID"));
            employees.add(employee);
        }
        return employees;
    }

    // Close the connection (optional)
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}

