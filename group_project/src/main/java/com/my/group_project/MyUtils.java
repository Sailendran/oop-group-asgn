/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.group_project;

/**
 *
 * @author saile
 */
public class MyUtils {
    
    public static boolean arraysEqual(char[] a, char[] b) {
        
        if (a.length == b.length) {
            
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            } 
            
            return true;
            
        } else {
            return false;
        }
        
    }
    
}
