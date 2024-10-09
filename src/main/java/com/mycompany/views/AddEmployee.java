/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.views;

import com.mycompany.dao.*;
import com.mycompany.model.*;
import com.mycompany.utils.DateUtil;
import com.mycompany.utils.RestrictionUtil;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hirraabdulmalik
 */
public class AddEmployee extends javax.swing.JFrame {
public List<Employee> employees;
private static List<Advance> advanceList;
private static List<OtherDeduction> deductions;
private static List<MessCharge> messCharges;
    public List<Employee> getEmployees() {
        return employees;
    }
EmployeeDAO employeeDAO;
    public AddEmployee() throws SQLException {
        initComponents();
        // Set the frame properties
        setTitle("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jTextFieldEmployeeID.setVisible(false);
        try {
            employeeDAO = new EmployeeDAO();

            employees = employeeDAO.getAllEmployees(); 
                      
        }
        
        catch (SQLException e) {
            e.printStackTrace();
        }
        setEmployeeTableModel(jTable1, employees);
        // Initialize labels and text fields
        //lblEmployeeID = new JLabel("Employee ID:");
        
// Add KeyListener to allow only numbers
        RestrictionUtil.addDigitOnlyKeyListener(jTextFieldCNIC,jTextFieldSalary,jTextFieldBonus,jTextFieldCarryForward);               
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

        if(employees.size() <= 0){jButtonGetAll.setEnabled(false); return;}
            AdvanceDAO ad = new AdvanceDAO();
            OtherDeductionsDAO ao = new OtherDeductionsDAO();
            MessChargeDAO dao = new MessChargeDAO();
            deductions = ao.getAllOtherDeductions();
            advanceList = ad.getAllAdvances();
            messCharges = dao.getAllMessCharges();
    }
// Method to set the JTable model from List<Employee>
    public static void setEmployeeTableModel(JTable table, List<Employee> employees) {
        // Create a DefaultTableModel with column names
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Father Name");
        model.addColumn("Reference Name");        
        model.addColumn("Qualification");
        model.addColumn("CNIC");
        model.addColumn("Joining Date");
        model.addColumn("Carry Forward");
        model.addColumn("Advance");
        model.addColumn("Deduction");
        model.addColumn("Mess Bill");
        // Add rows from the List<Employee>
        for (Employee employee : employees) {
            int totalAdvance = 0;
            int totalDeductions = 0;
            int messBill = 0;
            totalAdvance = CalculateAdvance(employee, totalAdvance);
            totalDeductions = CalculateDeduction(employee, totalDeductions);
            messBill = CalculateMessCharges(employee, messBill);
            model.addRow(new Object[] {
                employee.getName(),
                employee.getFathersName(),
                employee.getReferenceName(),
                employee.getQualification(),
                employee.getCnicNo(),
                employee.getDateOfJoining(),
                employee.getCarryForward(),
                totalAdvance,
                totalDeductions,
                messBill
            });
        }

        // Set the model to the JTable
        table.setModel(model);
    }

    private static int CalculateAdvance(Employee employee, int totalAdvance) {
        if(advanceList!= null && advanceList.size() > 0){
            
            for (int index=0; index < advanceList.size(); index++){
                if(employee.getEmployeeID() == advanceList.get(index).getEmployeeID())
                {
                    if(advanceList.get(index).getResolved() == 0)
                        totalAdvance+=advanceList.get(index).getAmount();
                }
            }
        }
        return totalAdvance;
    }
    private static int CalculateDeduction(Employee employee, int totalDeduction) {
        if(deductions!= null && deductions.size() > 0){
            
            for (int index=0; index < deductions.size(); index++){
                if(employee.getEmployeeID() == deductions.get(index).getEmployeeID())
                {
                    if(deductions.get(index).getResolved() == 0)
                        totalDeduction+=deductions.get(index).getAmount();
                }
            }
        }
        return totalDeduction;
    }
    private static int CalculateMessCharges(Employee employee, int totalMessCharges) {
        if(messCharges!= null && messCharges.size() > 0){
            
            for (int index=0; index < messCharges.size(); index++){
                if(employee.getEmployeeID() == messCharges.get(index).getEmployeeID())
                {
                    if(messCharges.get(index).getResolved() == 0)
                        totalMessCharges+=messCharges.get(index).getAmount();
                }
            }
        }
        return totalMessCharges;
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
                    DateUtil.GetDateforDateChooser(jDateChooserDateOfJoining),
                    DateUtil.GetDateforDateChooser(jDateChooserDateOfTermination),
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
                    DateUtil.GetDateforDateChooser(jDateChooserDateOfJoining),
                    DateUtil.GetDateforDateChooser(jDateChooserDateOfTermination),
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

        jButtonDelete1 = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldRefName = new javax.swing.JTextField();
        jLabelDateOfJoining = new javax.swing.JLabel();
        jLabelDateOfTermination = new javax.swing.JLabel();
        jLabelSalary = new javax.swing.JLabel();
        jTextFieldSalary = new javax.swing.JTextField();
        jLabelBonus = new javax.swing.JLabel();
        jTextFieldBonus = new javax.swing.JTextField();
        jLabelCarryForward = new javax.swing.JLabel();
        jTextFieldCarryForward = new javax.swing.JTextField();
        jLabelQualification = new javax.swing.JLabel();
        jTextFieldQualification = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jLabelCNIC = new javax.swing.JLabel();
        jButtonDelete = new javax.swing.JButton();
        jTextFieldCNIC = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        jButtonGetAll = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jTextFieldEmployeeID = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jLabelFatherName = new javax.swing.JLabel();
        jTextFieldFatherName = new javax.swing.JTextField();
        jLabelRefName = new javax.swing.JLabel();
        jDateChooserDateOfJoining = new com.toedter.calendar.JDateChooser();
        jDateChooserDateOfTermination = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(452, 536));

        jButtonDelete1.setText("Close");
        jButtonDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelete1ActionPerformed(evt);
            }
        });

        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("All Employees", jPanel2);

        jLabelDateOfJoining.setText("Date of Joining");

        jLabelDateOfTermination.setText("Date of Termination");

        jLabelSalary.setText("Salary:");

        jLabelBonus.setText("Bonus:");

        jLabelCarryForward.setText("Carry Forward:");

        jLabelQualification.setText("Qualification:");

        jButtonAdd.setText("Add new Employee");
        jButtonAdd.setToolTipText("");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jLabelCNIC.setText("CNIC:");

        jButtonDelete.setText("Delete Employee");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update Employee");

        jButtonGetAll.setText("Search");
        jButtonGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetAllActionPerformed(evt);
            }
        });

        jLabelName.setText("Name:");

        jTextFieldEmployeeID.setText("jTextFieldName");

        jLabelFatherName.setText("Father Name:");

        jLabelRefName.setText("Reference Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName)
                    .addComponent(jLabelCNIC)
                    .addComponent(jLabelFatherName)
                    .addComponent(jLabelRefName)
                    .addComponent(jLabelDateOfJoining)
                    .addComponent(jLabelSalary)
                    .addComponent(jLabelQualification)
                    .addComponent(jLabelBonus)
                    .addComponent(jLabelCarryForward)
                    .addComponent(jLabelDateOfTermination))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSalary)
                    .addComponent(jTextFieldQualification)
                    .addComponent(jTextFieldBonus)
                    .addComponent(jTextFieldCarryForward)
                    .addComponent(jDateChooserDateOfTermination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserDateOfJoining, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldRefName)
                    .addComponent(jTextFieldFatherName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addComponent(jTextFieldCNIC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGetAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButtonAdd)
                .addGap(18, 18, 18)
                .addComponent(jButtonUpdate)
                .addGap(18, 18, 18)
                .addComponent(jButtonDelete)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(376, 869, Short.MAX_VALUE)
                .addComponent(jTextFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGetAll)
                    .addComponent(jTextFieldCNIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCNIC))
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFatherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFatherName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldRefName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRefName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserDateOfJoining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelDateOfJoining))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelDateOfTermination)
                    .addComponent(jDateChooserDateOfTermination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSalary))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQualification))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBonus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCarryForward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCarryForward))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete))
                .addGap(41, 41, 41))
        );

        jTabbedPane2.addTab("Manage Employee", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonDelete1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDelete1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelete1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonDelete1ActionPerformed

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

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        deleteEmployee();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddActionPerformed
    private void SetFields(Employee employee){
        jTextFieldName.setText(employee.getName());
        jTextFieldRefName.setText(employee.getReferenceName());
        jTextFieldFatherName.setText(employee.getFathersName());
        jDateChooserDateOfJoining.setDate(DateUtil.GetDateFromString(employee.getDateOfJoining()));
        jDateChooserDateOfTermination.setDate(DateUtil.GetDateFromString(employee.getDateOfTermination()));
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
                try {
                    new AddEmployee().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonDelete1;
    private javax.swing.JButton jButtonGetAll;
    private javax.swing.JButton jButtonUpdate;
    private com.toedter.calendar.JDateChooser jDateChooserDateOfJoining;
    private com.toedter.calendar.JDateChooser jDateChooserDateOfTermination;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldBonus;
    private javax.swing.JTextField jTextFieldCNIC;
    private javax.swing.JTextField jTextFieldCarryForward;
    private javax.swing.JTextField jTextFieldEmployeeID;
    private javax.swing.JTextField jTextFieldFatherName;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldQualification;
    private javax.swing.JTextField jTextFieldRefName;
    private javax.swing.JTextField jTextFieldSalary;
    // End of variables declaration//GEN-END:variables
}
