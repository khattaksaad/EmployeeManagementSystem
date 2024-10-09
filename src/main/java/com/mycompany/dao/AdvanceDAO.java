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

public class AdvanceDAO {

    // Constructor to establish the database connection
    public AdvanceDAO() {
    }

    // Method to insert a new advance record
    public static boolean addAdvance(Advance advance) throws SQLException {
        String sql = "INSERT INTO Advance (employeeID, advancedate, amount, resolved, description) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = SQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, advance.getEmployeeID());
            pstmt.setString(2, advance.getDate());
            pstmt.setDouble(3, advance.getAmount());
            pstmt.setInt(4, advance.getResolved());
            pstmt.setString(5, advance.getDescription());
            pstmt.executeUpdate();
            return true;
        }
        
    }

    // Method to fetch an advance record by advanceID
    public static Advance getAdvanceById(int advanceID) throws SQLException {
        String sql = "SELECT * FROM Advance WHERE ID = ?";
        try (Connection conn = SQLConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, advanceID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int employeeID = rs.getInt("employeeID");
                String date = rs.getString("advancedate");
                double amount = rs.getDouble("amount");
                int resolved = rs.getInt("resolved");
                String description = rs.getString("Description");
                return new Advance(employeeID, date, amount, resolved, description);
            }
        }
        return null;
    }

    // Method to get all advance records
    public static List<Advance> getAllAdvances() throws SQLException {
        List<Advance> advances = new ArrayList<>();
        String sql = "SELECT * FROM Advance";
        try (Connection conn = SQLConnection.connect();Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int advanceID = rs.getInt("ID");
                int employeeID = rs.getInt("employeeID");
                String date = rs.getString("advancedate");
                double amount = rs.getDouble("amount");
                int resolved = rs.getInt("resolved");
String description = rs.getString("Description");
                Advance advance = new Advance(employeeID, date, amount, resolved, description);
                advances.add(advance);
            }
        }
        return advances;
    }

    // Method to update an advance record
    public static void updateAdvance(Advance advance, int advanceID) throws SQLException {
        String sql = "UPDATE Advance SET employeeID = ?, advancedate = ?, amount = ?, resolved = ?, Description = ? WHERE ID = ?";
        try (Connection conn = SQLConnection.connect();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, advance.getEmployeeID());
            pstmt.setString(2, advance.getDate());
            pstmt.setDouble(3, advance.getAmount());
            pstmt.setInt(4, advance.getResolved());
            pstmt.setString(5, advance.getDescription());
            pstmt.setInt(6, advanceID);
            pstmt.executeUpdate();
        }
    }

    // Method to delete an advance record by advanceID
    public static void deleteAdvance(int advanceID) throws SQLException {
        String sql = "DELETE FROM Advance WHERE ID = ?";
        try (Connection conn = SQLConnection.connect();PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, advanceID);
            pstmt.executeUpdate();
        }
    }
}
