/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author hirraabdulmalik
 */
public class DateUtil {
    public static String GetDateforDateChooser(JDateChooser jDateC){
                            Date selectedDate = jDateC.getDate();
            if (selectedDate != null) {
                // Format the date
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sdf.format(selectedDate);
                return formattedDate;
            }
            else return "";
    } 
    public static Date GetDateFromString(String dateString){
        Date date = null;
        if(dateString.isEmpty()) return date;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateFormat.parse(dateString);  // Convert string to Date
        } catch (ParseException e) {
            e.printStackTrace();  // Handle exception if date parsing fails
        }
        return date;
    }
    public static String GetTodayAsString(){
        Date today = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(today);
    }
    public static int getMonthNumber(String monthName) {
    // Convert the month name to uppercase to match the Month enum
    Month month = Month.valueOf(monthName.toUpperCase());
    return month.getValue(); // Returns the month as an integer (1 for January, 2 for February, etc.)
}
}
