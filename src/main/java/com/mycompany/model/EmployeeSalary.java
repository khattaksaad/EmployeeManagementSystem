/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author hirraabdulmalik
 */
public class EmployeeSalary {
    private String month;
    private String year;
    private String name;
    private int employeeId;
    private double bonus;
    private double otherDeduction;
    private double carryForward;
    private double decidedSalary;
    private double messBill;
    private double totalSalaryCalculated;
    private double advance;
    public EmployeeSalary(){}
    public EmployeeSalary(int employeeId,String name, double decidedSalary, double bonus, double carryForward,
                     double advance, double otherDeduction, double messBill, double totalSalaryCalculated) {
        this.employeeId = employeeId;
        this.name = name;
        this.decidedSalary = decidedSalary;
        this.bonus = bonus;
        this.carryForward = carryForward;
        this.advance = advance;
        this.otherDeduction = otherDeduction;
        this.messBill = messBill;
        this.totalSalaryCalculated = totalSalaryCalculated;
    }

    /**
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the employeeId
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /**
     * @return the otherDeduction
     */
    public double getOtherDeduction() {
        return otherDeduction;
    }

    /**
     * @param otherDeduction the otherDeduction to set
     */
    public void setOtherDeduction(double otherDeduction) {
        this.otherDeduction = otherDeduction;
    }

    /**
     * @return the carryForward
     */
    public double getCarryForward() {
        return carryForward;
    }

    /**
     * @param carryForward the carryForward to set
     */
    public void setCarryForward(double carryForward) {
        this.carryForward = carryForward;
    }

    /**
     * @return the decidedSalary
     */
    public double getDecidedSalary() {
        return decidedSalary;
    }

    /**
     * @param decidedSalary the decidedSalary to set
     */
    public void setDecidedSalary(double decidedSalary) {
        this.decidedSalary = decidedSalary;
    }

    /**
     * @return the messBill
     */
    public double getMessBill() {
        return messBill;
    }

    /**
     * @param messBill the messBill to set
     */
    public void setMessBill(double messBill) {
        this.messBill = messBill;
    }

    /**
     * @return the totalSalaryCalculated
     */
    public double getTotalSalaryCalculated() {
        return totalSalaryCalculated;
    }

    /**
     * @param totalSalaryCalculated the totalSalaryCalculated to set
     */
    public void setTotalSalaryCalculated(double totalSalaryCalculated) {
        this.totalSalaryCalculated = totalSalaryCalculated;
    }

    /**
     * @return the advance
     */
    public double getAdvance() {
        return advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(double advance) {
        this.advance = advance;
    }
}
