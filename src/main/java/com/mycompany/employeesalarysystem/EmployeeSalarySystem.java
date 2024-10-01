/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeesalarysystem;

import com.mycompany.dao.DepartmentDAO;
import com.mycompany.database.SQLConnection;
import com.mycompany.views.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author hirraabdulmalik
 */
public class EmployeeSalarySystem {

    public static void main(String[] args) {
        
        // Show an information message dialog
            new MainView().setVisible(true);
     }    
}
