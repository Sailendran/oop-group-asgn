package login.com.my.group_project;

import java.awt.Toolkit.*;
import java.awt.event.*;

//TODO create translation module to return appropriate string and 
public class Disaster {
    public static int stringNumber(String country) {
        
        int lineNumber;
        
        switch (country) {
            
            case "Brazil":
                lineNumber = 1;
                break;
            case "Canada":
                lineNumber = 2;
                break;
            case "Iceland":
                lineNumber = 3;
                break;
            case "Malaysia":
                lineNumber = 4;
                break;
            case "New Zealand":
                lineNumber = 5;
                break;
            case "Tanzania":
                lineNumber = 6;
                break;
            default:
                lineNumber = 1;
                
        }
        
    return lineNumber -1;
    }
    
    
}
