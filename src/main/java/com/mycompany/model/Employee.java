/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author hirraabdulmalik
 */
public class Employee {
    private int employeeID;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFathersName() {
        return fatherName;
    }

    public void setFathersName(String fathersName) {
        this.fatherName = fathersName;
    }

    public String getCnicNo() {
        return cnicNo;
    }

    public void setCnicNo(String cnicNo) {
        this.cnicNo = cnicNo;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDateOfTermination() {
        return dateOfTermination;
    }

    public void setDateOfTermination(String dateOfTermination) {
        this.dateOfTermination = dateOfTermination;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getSalaryDecided() {
        return salaryDecided;
    }

    public void setSalaryDecided(double salaryDecided) {
        this.salaryDecided = salaryDecided;
    }

    public double getPreviousLoan() {
        return previousLoan;
    }

    public void setPreviousLoan(double previousLoan) {
        this.previousLoan = previousLoan;
    }
    private String name;
    private String fatherName;
    private String cnicNo;
    private String referenceName;
    private int departmentID;
    private String dateOfJoining;
    private String dateOfTermination;
    private String qualification;
    private double salaryDecided;
    private double previousLoan;

    public Employee(int employeeID, String name, String fatherName, String cnicNo, 
                    String referenceName, int departmentID, String dateOfJoining, 
                    String dateOfTermination, String qualification, double salaryDecided, double previousLoan) {
        this.employeeID = employeeID;
        this.name = name;
        this.fatherName = fatherName;
        this.cnicNo = cnicNo;
        this.referenceName = referenceName;
        this.departmentID = departmentID;
        this.dateOfJoining = dateOfJoining;
        this.dateOfTermination = dateOfTermination;
        this.qualification = qualification;
        this.salaryDecided = salaryDecided;
        this.previousLoan = previousLoan;
    }

    // Getters and setters...
}
