/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import com.mycompany.model.Employee;
import com.mycompany.model.*;
import java.util.List;

/**
 *
 * @author hirraabdulmalik
 */
public class CalculateUtils {
        public static int CalculateAdvance(List<Advance> advanceList,Employee employee, int totalAdvance) {
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
    public static int CalculateDeduction(List<OtherDeduction> deductions, Employee employee, int totalDeduction) {
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
    public static int CalculateMessCharges(List<MessCharge> messCharges,Employee employee, int totalMessCharges) {
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
}
