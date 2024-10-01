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
    private int messBillID;
    private int employeeID;
    private String date;
    private double amount;

    public MessCharge(int messBillID, int employeeID, String date, double amount) {
        this.messBillID = messBillID;
        this.employeeID = employeeID;
        this.date = date;
        this.amount = amount;
    }

    public int getMessBillID() {
        return messBillID;
    }

    public void setMessBillID(int messBillID) {
        this.messBillID = messBillID;
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
}
