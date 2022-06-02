package com.my.group_project;

//Used to read JSON files
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.*;
import org.json.simple.*;

//to write to JSON
import java.io.FileWriter;

//for reading txt files
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Translation {
    
    public static void main(String[] args) {
        setLang("Mandarin");
    }
    
    //reads what language must be used and sets path to appropriate langauge folder
    
    public static String getLang() {
        JSONParser jp = new JSONParser();
        
        //reading JSON to get language TODO add colour mode later
        try {
            
                Object obj = jp.parse(new FileReader("settings.json"));
                JSONObject jo = (JSONObject) obj;
                String language = (String) jo.get("language");
                return language;

                
        } catch (FileNotFoundException e) {
            
            System.out.println("The file wasn't found");
            
        } catch (IOException e) {
            
            System.out.println("There was an IO Exception");
            
        } catch (ParseException e) {
            
            System.out.println("There was an error parsing JSON data");
        }
       
    //if code fails, return English as default language
    return "English";
    
    }

    
        //selecting folders to refer to
    private static Path getPath() throws IOException {
        
        Path LanguageFilesFolder = Path.of("LanguageFiles/");
//        System.out.println(LanguageFilesFolder.toRealPath().normalize().toString());
        
        String language = getLang();
        
        Path filepath;
                
        switch (language){
            
            case "English", "BM", "Mandarin" -> filepath = LanguageFilesFolder.resolve(language + "/");
            default -> filepath = LanguageFilesFolder.resolve("English/");
        }    
        
        
    return filepath;
    }
    
    public static void setLang(String lang) {
        
        JSONParser jp = new JSONParser();
        try {
            
                Object obj = jp.parse(new FileReader("settings.json"));
                JSONObject jo = (JSONObject) obj;
                
                switch (lang) {
                case "English":
                    jo.put("language", "English");
                    break;
                case "BM":
                    jo.put("language", "BM");
                    break;
                case "Mandarin":
                    jo.put("language", "Mandarin");
                    break;
                default:
                    jo.put("language", "English");
                }
                
                System.out.println(jo);
                
                 try (FileWriter file = new FileWriter("settings.json")) 
                {
                    file.write(jo.toString());
                }

                
        } catch (FileNotFoundException e) {
            
            System.out.println("The file wasn't found");
            
        } catch (IOException e) {
            
            System.out.println("There was an IO Exception");
            
        } catch (ParseException e) {
            
            System.out.println("There was an error parsing JSON data");
        }
        
    }
    
    //sphagetti code because I misnamed a folder langauge instead of language.
    //my suffering is immense and my dissapointment immeasureable
    @SuppressWarnings("empty-statement")
    public static String disasterString(int line) {
        
        try {
            
            String filename = "disaster.txt";
            //WARNING: EDIT THIS IF #LINES CHANGES
            int totalLines = 6;
            
            
            Path path = Translation.getPath().resolve(filename);
        //        System.out.println(Translation.getPath());
        //        System.out.println(path);

        if (line>totalLines) {
            return "Error in code - line requested does not exist!";
        }

        String text = "Translation module error!!!";

        FileInputStream fs;
        BufferedReader br;

        try {

        //System.out.println(path.toAbsolutePath().normalize().toString());
        fs = new FileInputStream((String) path.toAbsolutePath().normalize().toString());
        br = new BufferedReader(new InputStreamReader(fs));

        try {

            for (int i = 0; i < line; i++) {
                br.readLine();
            }

            text = br.readLine();
            //System.out.println(text);

        } catch (IOException ex) {

            ;

        }

        } catch (FileNotFoundException e) {
            System.out.println("Language file not found!!");
        }

        return text;
        } catch (IOException ex) {
            Logger.getLogger(Translation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "Translation module error!";
    }
    
        public static String dmsString(int line) {
        
        try {
            
            String filename = "disastermainscreen.txt";
            //WARNING: EDIT THIS IF #LINES CHANGES
            int totalLines = 6;
            
            
            Path path = Translation.getPath().resolve(filename);
        //        System.out.println(Translation.getPath());
        //        System.out.println(path);

        if (line>totalLines) {
            return "Error in code - line requested does not exist!";
        }

        String text = "Translation module error!!!";

        FileInputStream fs;
        BufferedReader br;

        try {

        //System.out.println(path.toAbsolutePath().normalize().toString());

        fs = new FileInputStream((String) path.toAbsolutePath().normalize().toString());
        br = new BufferedReader(new InputStreamReader(fs));

        try {

            for (int i = 1; i < line; i++) {
                br.readLine();
            }

            text = br.readLine();
            //System.out.println(text);

        } catch (IOException ex) {
            
        }

        } catch (FileNotFoundException e) {
            System.out.println("Language file not found!!");
        }

        return text;
        } catch (IOException ex) {
            Logger.getLogger(Translation.class.getName()).log(Level.SEVERE, null, ex);
        }
    return "Translation module error!";
    }
    
        
    public static String accountString(int line) {
        
        String filename = "accountfunctions.txt";
        int totalLines = 13;
        
        Path path;
        try {
            path = Translation.getPath().resolve(filename);
        } catch (IOException ex) {
            Logger.getLogger(Translation.class.getName()).log(Level.SEVERE, null, ex);
            return "Translation module error! Path not found";
        }
        
        if (line>totalLines) {
            return "Error in code - line requested does not exist!";
        }
        
        String text = "Translation module error!!!";
        
        FileInputStream fs;
        BufferedReader br;
        
        try {
            
            fs = new FileInputStream((String) path.toAbsolutePath().normalize().toString());
            br = new BufferedReader(new InputStreamReader(fs));
            
            try { 
                
                for (int i = 1; i < line; i++) {
                    br.readLine();
                }
                
                text = br.readLine();
                //System.out.println(text);
                
            } catch (IOException ex) {
                
                System.out.println("IO exception");
                
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Language file not found!!");
        }
            
        return text;
    }
    
        public static String mainString(int line) {
        
        String filename = "mainmenu.txt";
        int totalLines = 5;
        
        Path path;
        try {
            path = Translation.getPath().resolve(filename);
        } catch (IOException ex) {
            Logger.getLogger(Translation.class.getName()).log(Level.SEVERE, null, ex);
            return "Translation module error! Path not found";
        }
        
        if (line>totalLines) {
            return "Error in code - line requested does not exist!";
        }
        
        String text = "Translation module error!!!";
        
        FileInputStream fs;
        BufferedReader br;
        
        try {
            
            fs = new FileInputStream((String) path.toAbsolutePath().normalize().toString());
            br = new BufferedReader(new InputStreamReader(fs));
            
            try { 
                
                for (int i = 1; i < line; i++) {
                    br.readLine();
                }
                
                text = br.readLine();
                //System.out.println(text);
                
            } catch (IOException ex) {
                
                ;
                
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Language file not found!!");
        }
            
        return text;
    }
    //TODO add functions for Big SUUUIIII and Benjamin's modules
    
}