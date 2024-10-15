/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.database;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author hirraabdulmalik
 */
public class SQLConnection {

static String dbPath = "/Applications/DB/salary_management.db";   
                //static URL resource = SQLConnection.class.getResource("/Applications/DB/salary_management.db");

    
    //private static final String URL = "jdbc:sqlite:salary_management.db";

    public  static Connection connect() {
        Connection conn = null;
        try {
            
            File dbFile = new File(dbPath);

            // Check if the file exists
            if (!dbFile.exists()) {
                 throw new SQLException("Database file not found at: " + dbPath);
            }

            // Convert resource URL to file path
            //File dbFile = new File(resource.toURI());

            // Establish SQLite connection
            String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
