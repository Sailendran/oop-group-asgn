package com.my.group_project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author saile
 */
class Accounts {
    
    //testing
    public static void main(String[] args) {
        //System.out.println(kaiserCypher("h0m0sexual".toCharArray()));
    }
    
    //universal shift value 
    static int shift = 8;    
    
    // Encrypts text using shift
    public static String kaiserCypher(char[] chars) {
        
        char[] ciphertext = new char[chars.length];
        int i = 0;
        
        for (char x : chars) {
            
            char y = (char)(x + Accounts.shift);
            ciphertext[i] = y;
            i++;
            
        }
        
        return new String(ciphertext);
    }
 
    
    //login and signup handling
    public static boolean login(String username, char[] password) {
        
        boolean accountExists = false;
        boolean passwordMatch = false;

        JSONParser jp = new JSONParser();
        
        //reading JSON to get language TODO add colour mode later
        try {
            
                Object obj = jp.parse(new FileReader("accounts.json"));
                JSONObject jo = (JSONObject) obj;
                Set<String> accountusernames = jo.keySet();
                
                //testing
                for (String x : accountusernames) {
                    
                    if (username.equals(x)) {
                        accountExists = true;
                        break;
                    }
                
                }
                
                if (accountExists) {
                    String encryptPassInput = kaiserCypher(password);
                    
                    if (encryptPassInput.equals(jo.get(username))) {
                        passwordMatch = true;
                    } else {
                    }
                    
                }
                
                if (accountExists && passwordMatch) {
                    MainMenu mm = new MainMenu();
                    mm.setVisible(true);
                }
                
                return (accountExists && passwordMatch);

                
        } catch (FileNotFoundException e) {
            
            System.out.println("The file wasn't found");
            
        } catch (IOException e) {
            
            System.out.println("There was an IO Exception");
            
        } catch (ParseException e) {
            
            System.out.println("There was an error parsing JSON data");
        }
       
    return false;
    }
    
    
    
    public static boolean signup(String username, char[] password, char[] confirm) throws ParseException {
        
        boolean accountExists = false;
        
        if (MyUtils.arraysEqual(password, confirm)) {
            
            JSONParser jp = new JSONParser();
            Object obj = null;
            try {
                obj = jp.parse(new FileReader("accounts.json"));
            } catch (IOException ex) {
                Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("IO Exception");
                return false;
            }
            JSONObject jo = (JSONObject)obj;
            Set<String> accountusernames = jo.keySet();
            for (String x : accountusernames) {
                
                if (username.equals(x)) {
                    accountExists = true;
                    break;
                }
                
            }
            
            if (accountExists) {
                return false;
            }else if (!accountExists) {
                //add the account to the JSON
                jo.put(username, kaiserCypher(password));
                
                try (FileWriter file = new FileWriter("accounts.json")) {
                    file.write(jo.toJSONString());
                    Login lg = new Login();
                    lg.setVisible(true);
                    
                } catch (IOException ex) {
                    //condition IOException should never be met
                    Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Couldn't write account");
                }
                
            }
            System.out.println("true");
        return true;    
        }
    //default- should never be read
    return false;
    }
    

}