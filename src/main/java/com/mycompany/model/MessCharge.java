/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author hirraabdulmalik
 */
public class MessCharge {
    private int ID;
    private int employeeID;
    private String date;
    private String description;
    private int resolved;
    private double amount;

    public MessCharge(int messBillID, int employeeID, String date, double amount, String description, int resolved) {
        this.ID = messBillID;
        this.employeeID = employeeID;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.resolved = resolved;
    }

    public int getMessBillID() {
        return ID;
    }

    public void setMessBillID(int messBillID) {
        this.ID = messBillID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
}
