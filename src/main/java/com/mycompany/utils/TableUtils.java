/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author hirraabdulmalik
 */
public class TableUtils {
    public static void hideColumn(JTable table, int columnIndex) {
        TableColumn column = table.getColumnModel().getColumn(columnIndex);
        table.getColumnModel().removeColumn(column);
    }
    
}
