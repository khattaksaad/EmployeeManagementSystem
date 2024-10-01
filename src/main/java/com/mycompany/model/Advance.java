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

    public Advance(int advanceID, int employeeID, String date, double amount) {
        this.advanceID = advanceID;
        this.employeeID = employeeID;
        this.date = date;
        this.amount = amount;
    }
}
