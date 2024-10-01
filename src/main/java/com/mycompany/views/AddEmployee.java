/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.views;

import com.mycompany.dao.EmployeeDAO;
import com.mycompany.model.Employee;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author hirraabdulmalik
 */
public class AddEmployee extends javax.swing.JFrame {
List<Employee> employees;
EmployeeDAO employeeDAO;
    public AddEmployee() {
        initComponents();
        // Set the frame properties
        setTitle("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTextFieldEmployeeID.setVisible(false);
        try {
            employeeDAO = new EmployeeDAO();
            employees = employeeDAO.getAllEmployees(); 
            if(employees.size() <= 0){jButtonGetAll.setEnabled(false);}
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        // Initialize labels and text fields
        //lblEmployeeID = new JLabel("Employee ID:");
        
// Add KeyListener to allow only numbers
        jTextFieldCNIC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // If not a digit, ignore the event
                if (!Character.isDigit(c)) {
                    e.consume();  // Ignore this key event
                }
            }
        });
        // Initialize buttons

        // Add components to the frame

        
        // Button Actions
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveEmployee();
            }
        });

        jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });

        jButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        
    }

    // Method to save a new employee
    private void saveEmployee() {
        try {
            Employee employee = new Employee(
                    0,
                    jTextFieldName.getText(),
                    jTextFieldFatherName.getText(),
                    jTextFieldCNIC.getText(),
                    jTextFieldRefName.getText(),
                    0,
                    jTextFieldDateOfJoining.getText(),
                    jTextFieldDateOfTermination.getText(),
                    jTextFieldQualification.getText(),
                    Double.parseDouble(jTextFieldSalary.getText()),
                    Integer.parseInt(jTextFieldCarryForward.getText())
            );
            boolean success = employeeDAO.addEmployee(employee);
            JOptionPane.showMessageDialog(this, success ? "Employee added successfully" : "Failed to add employee");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an employee
    private void updateEmployee() {
        try {
            Employee employee = new Employee(0,
                    jTextFieldName.getText(),
                    jTextFieldFatherName.getText(),
                    jTextFieldCNIC.getText(),
                    jTextFieldRefName.getText(),
                    0,
                    jTextFieldDateOfJoining.getText(),
                    jTextFieldDateOfTermination.getText(),
                    jTextFieldQualification.getText(),
                    Double.parseDouble(jTextFieldSalary.getText()),
                    Integer.parseInt(jTextFieldCarryForward.getText())
            );
            employee.setEmployeeID(Integer.parseInt(jTextFieldEmployeeID.getText()));
            boolean success = employeeDAO.updateEmployee(employee);
            JOptionPane.showMessageDialog(this, success ? "Employee updated successfully" : "Failed to update employee");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an employee by ID
    private void deleteEmployee() {
        try {
            int employeeID = Integer.parseInt(jTextFieldEmployeeID.getText());
            boolean success = employeeDAO.deleteEmployee(employeeID);
            JOptionPane.showMessageDialog(this, success ? "Employee deleted successfully" : "Failed to delete employee");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get all employees and display them
    private void getAllEmployees() {
        try {
            List<Employee> employees = employeeDAO.getAllEmployees();
            StringBuilder employeeList = new StringBuilder("Employees:\n");
            for (Employee employee : employees) {
                employeeList.append("ID: ").append(employee.getEmployeeID())
                            .append(", Name: ").append(employee.getName()).append("\n");
            }
            JOptionPane.showMessageDialog(this, employeeList.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Creates new form AddEmployee
     */


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCNIC = new javax.swing.JLabel();
        jTextFieldCNIC = new javax.swing.JTextField();
        jButtonGetAll = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelFatherName = new javax.swing.JLabel();
        jTextFieldFatherName = new javax.swing.JTextField();
        jLabelRefName = new javax.swing.JLabel();
        jTextFieldRefName = new javax.swing.JTextField();
        jLabelDateOfJoining = new javax.swing.JLabel();
        jTextFieldDateOfJoining = new javax.swing.JTextField();
        jLabelDateOfTermination = new javax.swing.JLabel();
        jTextFieldDateOfTermination = new javax.swing.JTextField();
        jLabelSalary = new javax.swing.JLabel();
        jTextFieldSalary = new javax.swing.JTextField();
        jLabelBonus = new javax.swing.JLabel();
        jTextFieldBonus = new javax.swing.JTextField();
        jLabelCarryForward = new javax.swing.JLabel();
        jTextFieldCarryForward = new javax.swing.JTextField();
        jLabelQualification = new javax.swing.JLabel();
        jTextFieldQualification = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jTextFieldEmployeeID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(452, 536));

        jLabelCNIC.setText("CNIC:");

        jButtonGetAll.setText("Search");
        jButtonGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetAllActionPerformed(evt);
            }
        });

        jLabelName.setText("Name:");

        jLabelFatherName.setText("Father Name:");

        jLabelRefName.setText("Reference Name:");

        jLabelDateOfJoining.setText("Date of Joining");

        jLabelDateOfTermination.setText("Date of Termination");

        jLabelSalary.setText("Salary:");

        jLabelBonus.setText("Bonus:");

        jLabelCarryForward.setText("Carry Forward:");

        jLabelQualification.setText("Qualification:");

        jButtonAdd.setText("Add");
        jButtonAdd.setToolTipText("");

        jButtonDelete.setText("Delete");

        jButtonUpdate.setText("Update");

        jTextFieldEmployeeID.setText("jTextFieldName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCNIC)
                        .addGap(96, 96, 96)
                        .addComponent(jTextFieldCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonGetAll))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addGap(92, 92, 92)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelFatherName)
                        .addGap(52, 52, 52)
                        .addComponent(jTextFieldFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRefName)
                        .addGap(29, 29, 29)
                        .addComponent(jTextFieldDateOfJoining, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDateOfJoining)
                        .addGap(43, 43, 43)
                        .addComponent(jTextFieldRefName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDateOfTermination)
                        .addGap(17, 17, 17)
                        .addComponent(jTextFieldDateOfTermination, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSalary)
                        .addGap(90, 90, 90)
                        .addComponent(jTextFieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBonus)
                        .addGap(89, 89, 89)
                        .addComponent(jTextFieldBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCarryForward)
                        .addGap(44, 44, 44)
                        .addComponent(jTextFieldCarryForward, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelQualification)
                        .addGap(54, 54, 54)
                        .addComponent(jTextFieldQualification, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addGap(48, 48, 48)
                        .addComponent(jButtonDelete)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonUpdate)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCNIC)
                    .addComponent(jTextFieldCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGetAll))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFatherName)
                    .addComponent(jTextFieldFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jTextFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRefName)
                    .addComponent(jTextFieldDateOfJoining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDateOfJoining)
                    .addComponent(jTextFieldRefName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelDateOfTermination))
                    .addComponent(jTextFieldDateOfTermination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSalary)
                    .addComponent(jTextFieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBonus)
                    .addComponent(jTextFieldBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCarryForward)
                    .addComponent(jTextFieldCarryForward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelQualification))
                    .addComponent(jTextFieldQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonUpdate))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGetAllActionPerformed
        // TODO add your handling code here:
        Optional<Employee> foundEmployee = employees.stream()
                                                    .filter(e -> e.getCnicNo().equals(jTextFieldCNIC.getText().trim()))
                                                    .findFirst();

        if (foundEmployee.isPresent()) {
        Employee emp = foundEmployee.get();
        SetFields(emp);
        }
        
    }//GEN-LAST:event_jButtonGetAllActionPerformed
    private void SetFields(Employee employee){
        jTextFieldName.setText(employee.getName());
        jTextFieldRefName.setText(employee.getReferenceName());
        jTextFieldFatherName.setText(employee.getFathersName());
        jTextFieldDateOfJoining.setText(employee.getDateOfJoining());
        jTextFieldDateOfTermination.setText(employee.getDateOfTermination());
        jTextFieldSalary.setText(Double.toString(employee.getSalaryDecided()));
        jTextFieldQualification.setText(employee.getQualification());
        jTextFieldCarryForward.setText(Double.toString(employee.getCarryForward()));
        jTextFieldEmployeeID.setText(Integer.toString(employee.getEmployeeID()));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGetAll;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabelBonus;
    private javax.swing.JLabel jLabelCNIC;
    private javax.swing.JLabel jLabelCarryForward;
    private javax.swing.JLabel jLabelDateOfJoining;
    private javax.swing.JLabel jLabelDateOfTermination;
    private javax.swing.JLabel jLabelFatherName;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelQualification;
    private javax.swing.JLabel jLabelRefName;
    private javax.swing.JLabel jLabelSalary;
    private javax.swing.JTextField jTextFieldBonus;
    private javax.swing.JTextField jTextFieldCNIC;
    private javax.swing.JTextField jTextFieldCarryForward;
    private javax.swing.JTextField jTextFieldDateOfJoining;
    private javax.swing.JTextField jTextFieldDateOfTermination;
    private javax.swing.JTextField jTextFieldEmployeeID;
    private javax.swing.JTextField jTextFieldFatherName;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldQualification;
    private javax.swing.JTextField jTextFieldRefName;
    private javax.swing.JTextField jTextFieldSalary;
    // End of variables declaration//GEN-END:variables
}
