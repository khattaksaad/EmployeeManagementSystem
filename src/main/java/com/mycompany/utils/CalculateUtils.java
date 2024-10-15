/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import com.mycompany.model.Employee;
import com.mycompany.model.*;
import com.mycompany.views.ViewPayRoll;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hirraabdulmalik
 */
public class CalculateUtils {
        public static int CalculateAdvance(List<Advance> advanceList, Employee employee, int totalAdvance, int month, int year) {
    // Date formatter to parse date strings, assuming the format is "yyyy-MM-dd"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Calculate the salary period: 6th of previous month to 5th of the given month
    YearMonth yearMonth = YearMonth.of(year, month); // Represents the passed month and year
    LocalDate startDate = yearMonth.minusMonths(1).atDay(6); // 6th of the previous month
    LocalDate endDate = yearMonth.atDay(5); // 5th of the current month

    // Loop through advances to calculate the total for this employee within the date range
    if (advanceList != null && advanceList.size() > 0) {
        for (Advance advance : advanceList) {
            // Check if the advance belongs to the specified employee and is unresolved (resolved == 0)
            if (employee.getEmployeeID() == advance.getEmployeeID() && advance.getResolved() == 0) {
                
                // Parse the advance date from String to LocalDate
                try {
                    LocalDate advanceDate = LocalDate.parse(advance.getDate(), formatter);

                    // Check if the advance date is within the salary period
                    if (!advanceDate.isBefore(startDate) && !advanceDate.isAfter(endDate)) {
                        totalAdvance += advance.getAmount(); // Add to total if it's within range
                    }
                } catch (DateTimeParseException e) {
                    Logger.getLogger(ViewPayRoll.class.getName()).log(Level.SEVERE, null, e);
                    // Optionally handle invalid date format errors
                }
            }
        }
    }
    return totalAdvance;
}
    public static int CalculateDeduction(List<OtherDeduction> deductions, Employee employee, int totalDeduction, int month, int year) {
            // Date formatter to parse date strings, assuming the format is "yyyy-MM-dd"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Calculate the salary period: 6th of previous month to 5th of the given month
    YearMonth yearMonth = YearMonth.of(year, month); // Represents the passed month and year
    LocalDate startDate = yearMonth.minusMonths(1).atDay(6); // 6th of the previous month
    LocalDate endDate = yearMonth.atDay(5); // 5th of the current month
        if(deductions!= null && deductions.size() > 0){
            
            for (int index=0; index < deductions.size(); index++){
                if(employee.getEmployeeID() == deductions.get(index).getEmployeeID())
                {
                    
                    try {
                    LocalDate deductionDate = LocalDate.parse(deductions.get(index).getDate(), formatter);

                    // Check if the advance date is within the salary period
                    if (!deductionDate.isBefore(startDate) && !deductionDate.isAfter(endDate)) {
                        if(deductions.get(index).getResolved() == 0){
                        totalDeduction += deductions.get(index).getAmount(); // Add to total if it's within range
                    }}
                } catch (DateTimeParseException e) {
                    Logger.getLogger(ViewPayRoll.class.getName()).log(Level.SEVERE, null, e);
                    // Optionally handle invalid date format errors
                }                                      
            }
        }
        }
        return totalDeduction;
    }
    public static int CalculateMessCharges(List<MessCharge> messCharges,Employee employee, int totalMessCharges, int month, int year) {
                    // Date formatter to parse date strings, assuming the format is "yyyy-MM-dd"
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Calculate the salary period: 6th of previous month to 5th of the given month
    YearMonth yearMonth = YearMonth.of(year, month); // Represents the passed month and year
    LocalDate startDate = yearMonth.minusMonths(1).atDay(6); // 6th of the previous month
    LocalDate endDate = yearMonth.atDay(5); // 5th of the current month
        if(messCharges!= null && messCharges.size() > 0){
            
            for (int index=0; index < messCharges.size(); index++){
                if(employee.getEmployeeID() == messCharges.get(index).getEmployeeID() && messCharges.get(index).getResolved()==0)
                {
                    
                    try {
                    LocalDate deductionDate = LocalDate.parse(messCharges.get(index).getDate(), formatter);

                    // Check if the advance date is within the salary period
                    if (!deductionDate.isBefore(startDate) && !deductionDate.isAfter(endDate)) {
                        totalMessCharges += messCharges.get(index).getAmount(); // Add to total if it's within range
                    }
                } catch (DateTimeParseException e) {
                    Logger.getLogger(ViewPayRoll.class.getName()).log(Level.SEVERE, null, e);
                    // Optionally handle invalid date format errors
                }
            }
        }
        }
        return totalMessCharges;
    }
}
