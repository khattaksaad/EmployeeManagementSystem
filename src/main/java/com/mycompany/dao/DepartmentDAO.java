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
import com.mycompany.model.Department;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.SQLiteConnection;

public class DepartmentDAO {

    // Create Department Table
    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS Department (
                Id INTEGER PRIMARY KEY AUTOINCREMENT,,
                DepartmentName VARCHAR(100),
                Position VARCHAR(100)
            );
        """;

        try (Connection conn = SQLConnection.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Department table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Insert Department
    public static boolean insert(Department dept) {
        String sql = "INSERT INTO Department(DepartmentName, Position) VALUES(?, ?)";

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dept.getDepartmentName());
            pstmt.setString(2, dept.getPosition());

            pstmt.executeUpdate();
            System.out.println("Department inserted.");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Get Department by ID
    public static Department getDepartment(int id) {
        String sql = "SELECT * FROM Department WHERE Id = ?";
        Department dept = null;

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                dept = new Department(rs.getString("DepartmentName"), rs.getString("Position"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dept;
    }

    // Update Department
    public static void update(Department dept) {
        String sql = "UPDATE Department SET DepartmentName = ?, Position = ? WHERE Id = ?";

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dept.getDepartmentName());
            pstmt.setString(2, dept.getPosition());
            pstmt.setInt(3, dept.getDepartmentID());

            pstmt.executeUpdate();
            System.out.println("Department updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Delete Department
    public static void delete(int id) {
        String sql = "DELETE FROM Department WHERE Id = ?";

        try (Connection conn = SQLConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Department deleted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
