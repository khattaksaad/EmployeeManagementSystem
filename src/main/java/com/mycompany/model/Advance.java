/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author hirraabdulmalik
 */
public class Advance {
    private int advanceID;
    private int employeeID;
    private String date;
    private double amount;
    private int resolved;
    private String description;
    public Advance(int employeeID, String date, double amount, int resolved, String description) {
        this.employeeID = employeeID;
        this.date = date;
        this.amount = amount;
        this.resolved = resolved;
        this.description = description;
    }

    /**
     * @return the employeeID
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the resolved
     */
    public int getResolved() {
        return resolved;
    }

    /**
     * @param resolved the resolved to set
     */
    public void setResolved(int resolved) {
        this.resolved = resolved;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
