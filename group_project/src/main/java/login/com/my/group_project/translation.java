package login.com.my.group_project;

//Used to read JSON files
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.*;
import org.json.simple.*;

//for reading txt files
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class translation {
    
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
    
    
    //translation functions for each part of the programme
//    public String mainMenuString(int line) {
//        
//        ;
//        
//    }
    
    //sphagetti code because I misnamed a folder langauge instead of language.
    //my suffering is immense and my dissapointment immeasureable
    @SuppressWarnings("empty-statement")
    public static String disasterString(int line) throws IOException {
        
        String filename = "disaster.txt";
        //WARNING: EDIT THIS IF #LINES CHANGES
        int totalLines = 6;
        
        
        Path path = translation.getPath().resolve(filename);
//        System.out.println(translation.getPath());
//        System.out.println(path);
        
        if (line>totalLines) {
            return "Error in code - line requested does not exist!";
        }
        
        String text = "Translation module error!!!";
        
        FileInputStream fs;
        BufferedReader br;
        
        try {
            
//            System.out.println(path.toAbsolutePath().normalize().toString());
            
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
    }
    
    //TODO add functions for Big SUUUIIII and Benjamin's modules
    
}
