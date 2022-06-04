/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.my.group_project;

import java.awt.Checkbox;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author saile
 */
public class SurveyResults {
    
    static String selection1;
    
    public static void main(String[] args) {

        //System.out.println("lol");

    }
    
    public static void scoreCount(boolean c1, boolean c2, boolean c3, boolean c4, boolean c5) {
        
        Object obj;
        
        JSONParser jp = new JSONParser();
        JSONObject jo = null;
        
        try {
            
            obj = jp.parse(new FileReader("surveydata.json"));
            jo = (JSONObject) obj;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SurveyResults.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(SurveyResults.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (c1) {
            long value = (long) jo.get("Earthquakes");
            jo.put("Earthquakes", value+1);
        } 
        
        if (c2) {
            long value = (long) jo.get("Floods");
            jo.put("Floods", value+1);
        } 
        
        if (c3) {
            long value = (long) jo.get("Landslides");
            jo.put("Landslides", value+1);
        } 
        
        if (c4) {
            long value = (long) jo.get("Hailstorms");
            jo.put("Hailstorms", value+1);
        } 
        
        if (c5) {
            long value = (long) jo.get("Wildfires&Haze");
            jo.put("Wildfires&Haze", value+1);
        }
        
        try (FileWriter file = new FileWriter("surveydata.json")) {
            file.write(jo.toJSONString());

        } catch (IOException ex) {
            //condition IOException should never be met
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Couldn't write account");
        }

    }
        
}
