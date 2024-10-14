/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author hirraabdulmalik
 */
import java.util.Date;

public class EmployeeSalary4DB {
    private int id;
    private double bonus;
    private double totalSalary;
    private double actualPaidSalary;
    private int employeeID;
    private String salaryDate;

    // Constructor
    public EmployeeSalary4DB(int id, double bonus, double totalSalary, double actualPaidSalary, int employeeID, String salaryDate) {
        this.id = id;
        this.bonus = bonus;
        this.totalSalary = totalSalary;
        this.employeeID = employeeID;
        this.actualPaidSalary = actualPaidSalary;
        this.salaryDate = salaryDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(String salaryDate) {
        this.salaryDate = salaryDate;
    }

    /**
     * @return the actualPaidSalary
     */
    public double getActualPaidSalary() {
        return actualPaidSalary;
    }

    /**
     * @param actualPaidSalary the actualPaidSalary to set
     */
    public void setActualPaidSalary(double actualPaidSalary) {
        this.actualPaidSalary = actualPaidSalary;
    }
}
