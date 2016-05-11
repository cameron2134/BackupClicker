package dev.cameron2134.backupclicker;

import dev.cameron2134.backupclicker.display.GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;
import static org.apache.commons.io.FileUtils.deleteDirectory;
import org.apache.commons.lang3.time.StopWatch;


/**
 * @author Cameron Dempster
 * @version 1.4
 * @since 11/04/2015
 */



public class Backup extends SwingWorker<String, Integer> {
    

    
    private String[] srcDirectories;
    private String targetDirectory;
    
    private GUI gui;

   


    
    public Backup(GUI gui) {
        
        this.gui = gui;
        
    }
    
    
    
    
    
        
    @Override
    protected String doInBackground() {

        String backupTimer = "";
        StopWatch timer = new StopWatch();
        
        
        List<String> tempList = new ArrayList();
        String[] temp =  gui.getSourceArea().getText().split("\\n"); 
        targetDirectory = gui.getTargetArea().getText();


        for (int i = 0; i < temp.length; i++) {
            
            // Remove trailing whitespace at the end of directory path
            temp[i] = temp[i].trim();
            
            // Remove empty lines in array picked up from text area
            if (!temp[i].equals(""))
                tempList.add(temp[i]);
        }
        
        srcDirectories = tempList.toArray(new String[0]);



        File targetDir = new File(targetDirectory);
        File srcDir = null;


        
        timer.start();





        for (int x = 0; x < srcDirectories.length; x++) {
            publish(x);
            
            try {  

                srcDir = new File (srcDirectories[x]);

                if (gui.getDeleteStatus() == true) {
                    // If user ticks the checkbox, any old backups will be deleted and replaced instead of overwriting them

                    File oldBackup = new File (targetDir.getPath() + "\\" + srcDir.getName()); // get last subfolder of srcDir and attach it to targetDir


                    if (oldBackup.exists()) { // if an old backup exists of the same directory, delete it and replace with the new one
                        deleteDirectory(oldBackup);
                    }                

                }
                
                FileUtils.copyDirectoryToDirectory(srcDir, targetDir);
                
            }

                catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);
                    return null;
                }

                catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex, "Error!", JOptionPane.ERROR_MESSAGE);
                    return null;
                } 
        }


        timer.stop();		

        
        return timer.toString();
    }




    // Process receives the work updates from doInBackground to publish to the GUI, runs on EDT
    @Override
    protected void process(List<Integer> progress) {
        
        // Adding 1 since count is 0 and we want to make it easier for the user
        int dirsCopied = progress.get(progress.size() - 1) + 1;
        int i = progress.get(progress.size() - 1);
        i = (i * 100) / srcDirectories.length;
        gui.getProgressBar().setValue(i);
        

        gui.getProgressLbl().setText("Now copying " + srcDirectories[dirsCopied - 1]);
        gui.getProgressTotal().setText(dirsCopied + " of " + srcDirectories.length + " being copied");
        

    }

        
    
    @Override
    protected void done() {
        // Allow the user to perform another backup
        gui.getBackupBtn().setEnabled(true);
        gui.getProgressBar().setValue(100);
        
        gui.getProgressLbl().setText("Finished!");
        gui.getProgressTotal().setText(null);
        
        try {
            gui.out("\nBackup completed after " + get());
        } catch (InterruptedException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
