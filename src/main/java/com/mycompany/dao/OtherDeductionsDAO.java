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
import com.mycompany.model.OtherDeduction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OtherDeductionsDAO {


    public OtherDeductionsDAO() {
    }

    // Create or insert an OtherDeduction record
    public static boolean insertOtherDeduction(OtherDeduction deduction) {
        String sql = "INSERT INTO OtherDeductions (employeeID, DeductionDate, amount, description, resolved) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConnection.connect();PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, deduction.getEmployeeID());
            statement.setString(2, deduction.getDate());
            statement.setDouble(3, deduction.getAmount());
            statement.setString(4, deduction.getDescription());
            statement.setInt(5, deduction.getResolved());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read or retrieve an OtherDeduction record by ID
    public static OtherDeduction getOtherDeductionById(int deductionID) {
        String sql = "SELECT * FROM OtherDeductions WHERE ID = ?";
        try (Connection conn = SQLConnection.connect();PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, deductionID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int employeeID = resultSet.getInt("employeeID");
                String date = resultSet.getString("DeductionDate");
                double amount = resultSet.getDouble("amount");
                String description = resultSet.getString("description");
                int resolved = resultSet.getInt("resolved");
                return new OtherDeduction(deductionID, employeeID, date, amount, description, resolved);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        public static void ResolveAllOtherDeduction() throws SQLException{
            String sql = "UPDATE OtherDeductions SET Resolved = 1";
        try (Connection conn = SQLConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
        }
    // Update an OtherDeduction record
    public static boolean updateOtherDeduction(OtherDeduction deduction) {
        String sql = "UPDATE OtherDeductions SET employeeID = ?, DeductionDate = ?, amount = ?, description = ?, resolved = ? WHERE ID = ?";
        try (Connection conn = SQLConnection.connect();PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, deduction.getEmployeeID());
            statement.setString(2, deduction.getDate());
            statement.setDouble(3, deduction.getAmount());
            statement.setString(4, deduction.getDescription());
            statement.setInt(5, deduction.getResolved());
            statement.setInt(6, deduction.getDeductionID());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete an OtherDeduction record by ID
    public static boolean deleteOtherDeduction(int deductionID) {
        String sql = "DELETE FROM OtherDeductions WHERE ID = ?";
        try (Connection conn = SQLConnection.connect();PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, deductionID);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all OtherDeduction records
    public static List<OtherDeduction> getAllOtherDeductions() {
        List<OtherDeduction> deductions = new ArrayList<>();
        String sql = "SELECT * FROM OtherDeductions";
        try (Connection conn = SQLConnection.connect();Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int deductionID = resultSet.getInt("ID");
                int employeeID = resultSet.getInt("employeeID");
                String date = resultSet.getString("DeductionDate");
                double amount = resultSet.getDouble("amount");
                String description = resultSet.getString("description");
                int resolved = resultSet.getInt("resolved");
                OtherDeduction deduction = new OtherDeduction(deductionID, employeeID, date, amount, description, resolved);
                deductions.add(deduction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deductions;
    }
}

