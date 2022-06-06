package com.my.group_project;

/**
 *
 * @author saile
 */
public class Disaster {
    public static int stringNumber(String country) {
        
        int lineNumber;
        
        switch (country) {
            
            case "Brazil":
                lineNumber = 1;
                break;
            case "bā xī":
                lineNumber = 1;
                break;
            case "Canada":
                lineNumber = 2;
                break;
            case "jiā ná dà":
                lineNumber = 2;
                break;
            case "Iceland":
                lineNumber = 3;
                break;
            case "bīng dǎo":
                lineNumber = 3;
                break;
            case "Malaysia":
                lineNumber = 4;
                break;
            case "mǎ lái xī yà":
                lineNumber = 4;
                break;
            case "New Zealand":
                lineNumber = 5;
                break;
            case "xīn xī lán":
                lineNumber = 5;
                break;
            default:
                lineNumber = 1;
                
        }
        
    return lineNumber -1;
    }
    
    
}
