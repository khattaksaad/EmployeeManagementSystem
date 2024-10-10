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
import com.mycompany.model.MessCharge;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessChargeDAO {
    // Create a new mess charge entry in the database
    public boolean insertMessCharge(MessCharge messCharge) {
        String sql = "INSERT INTO MessBill (employeeID, datecharged, amount, description, resolved) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, messCharge.getEmployeeID());
            pstmt.setString(2, messCharge.getDate());
            pstmt.setDouble(3, messCharge.getAmount());
            pstmt.setString(4, messCharge.getDescription());
            pstmt.setInt(5, messCharge.getResolved());
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read a mess charge entry by ID
    public MessCharge getMessChargeById(int id) {
        String sql = "SELECT * FROM MessBill WHERE ID = ?";
        MessCharge messCharge = null;

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                messCharge = new MessCharge(
                    rs.getInt("ID"),
                    rs.getInt("employeeID"),
                    rs.getString("datecharged"),
                    rs.getDouble("amount"),
                    rs.getString("description"),
                    rs.getInt("resolved")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messCharge;
    }

    // Get all mess charges
    public List<MessCharge> getAllMessCharges() {
        List<MessCharge> messCharges = new ArrayList<>();
        String sql = "SELECT * FROM MessBill";

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                MessCharge messCharge = new MessCharge(
                    rs.getInt("ID"),
                    rs.getInt("employeeID"),
                    rs.getString("datecharged"),
                    rs.getDouble("amount"),
                    rs.getString("description"),
                    rs.getInt("resolved")
                );
                messCharges.add(messCharge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messCharges;
    }

    // Update an existing mess charge
    public void updateMessCharge(MessCharge messCharge) {
        String sql = "UPDATE MessBill SET employeeID = ?, datecharged = ?, amount = ?, description = ?, resolved = ? WHERE ID = ?";

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, messCharge.getEmployeeID());
            pstmt.setString(2, messCharge.getDate());
            pstmt.setDouble(3, messCharge.getAmount());
            pstmt.setString(4, messCharge.getDescription());
            pstmt.setInt(5, messCharge.getResolved());
            pstmt.setInt(6, messCharge.getMessBillID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void ResolveAllMessCharges() throws SQLException{
            String sql = "UPDATE MessBill SET Resolved = 1";
        try (Connection conn = SQLConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
        }
    // Delete a mess charge by ID
    public void deleteMessCharge(int id) {
        String sql = "DELETE FROM MessBill WHERE ID = ?";

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

