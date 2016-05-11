package dev.cameron2134.backupclicker.utils;


import dev.cameron2134.backupclicker.display.GUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Utilities {

    // Contains utility methods to be used by all classes
    
    
    
    // Saving
    
    public static void saveDirList(String[] directories, String targetDir, File targetFile, File srcDirFile){
        
        // receives the source directory array, writes it to txt file
        
        try {
        	
            
            FileWriter fileWriter = new FileWriter(srcDirFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            for (int i = 0; i < directories.length; i++){ // writes the directory array to file
            	
            	writer.write(directories[i]); 
                writer.newLine();
            }

            writer.close();
            
        }
        
        catch(IOException ex) {
        	
            JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);

        }
        
        

        
        try {
        	
            
            FileWriter fileWriter = new FileWriter(targetFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.write(targetDir); 

            writer.close();
            
        }
        
        catch(IOException ex) {
        	
        	JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);

        }
        
    } 
    
    
    
    
    
    
    public static void saveLogs(String log){
        File dataLog = new File("data/logs.txt");
        
 
        
        
        try {
            FileWriter filewriter = new FileWriter(dataLog);
            BufferedWriter writer = new BufferedWriter(filewriter);
            
            
            writer.write(log);
            writer.close();
            
        } 
        
        
        
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    } // end of saveLogs
    
    
    
    
    
    // Loading
    
    
    public static String[] loadDirList(File srcDirFile){
        
        List<String> list = new ArrayList<String>(); // creating an array list for dynamic sizing, as no idea how big it will need to be
        
        try {
        	
            
            FileReader fileReader = new FileReader(srcDirFile);
            BufferedReader reader = new BufferedReader(fileReader);

            
            String line;
            while ((line = reader.readLine()) != null) { // read text file line by line, store in array list
               list.add(line);
               
            }

            reader.close();
            
            
        }
        
        catch(IOException ex) {
        	
        	JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);

        }
        
        
        String[] directoryArray = list.toArray(new String[0]); // converts the array list back to an array to be returned
        
        return directoryArray;
        
    } // end of loadDirList
    
    
    
    
    
    public static String loadTargetDir(File targetFile){
        
        String target = "";
        
        try {
        	
            
            FileReader fileReader = new FileReader(targetFile);
            BufferedReader reader = new BufferedReader(fileReader);

            
            target = reader.readLine();

            reader.close();
            
            
        }// end try
        
        catch(IOException ex) {
        	
        	JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);

        }// end catch
        

        return target;
        
    } // end of loadTargetDir
    
    

  
}
