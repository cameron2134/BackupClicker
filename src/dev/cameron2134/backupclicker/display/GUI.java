
package dev.cameron2134.backupclicker.display;


import dev.cameron2134.backupclicker.Backup;
import dev.cameron2134.backupclicker.utils.Utilities;
import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class GUI extends javax.swing.JFrame {

    private final File dataFolder = new File ("data");
    private final File srcDirFile = new File("data/src.txt");
    private final File targetFile = new File("data/target.txt");
    
    private boolean deleteOld = true;
    
    private JFileChooser sourceChooser;
    private JFileChooser targetChooser;
    
    
    
    public GUI() { 
        
        feel();
        initComponents();
        setIcon();
        
        autoLoad();
        
        sourceChooser = new JFileChooser();
        targetChooser = new JFileChooser();
        
        sourceChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        sourceChooser.setApproveButtonToolTipText("Select a directory to back up");
        sourceChooser.setMultiSelectionEnabled(true);
        
        targetChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        targetChooser.setApproveButtonToolTipText("Select a directory to back your files to");
        
        if (!dataFolder.exists())
            dataFolder.mkdir();
    }

    
    
    
    
    
    private void setIcon() {
       
        ImageIcon img = new ImageIcon("resources/icon.png");
        this.setIconImage(img.getImage());
 
    }

    
    
    
    
    
    public void out(String msg) {
        // Receives a string, outputs it to the display area
        
        TA_displayText.append(msg + "\n");
        
        TA_displayText.setCaretPosition(TA_displayText.getDocument().getLength());
    }
    
    
    
    // Auto loads directories from file
    private void autoLoad() {
        
        String[] loadedDir;
        String targetDir;
        
        if (!srcDirFile.exists())
            out("Cannot auto load source directories - no data detected.");
        
        else {      
            loadedDir = Utilities.loadDirList(srcDirFile);
            TA_srcDir.setText(null);
            
            for (int i = 0; i < loadedDir.length; i++)
                TA_srcDir.append(loadedDir[i] + "\n");
        }
        
        
        if (!targetFile.exists())
            out("Cannot auto load target directory - no data detected.");
        
        else {     
            targetDir = Utilities.loadTargetDir(targetFile);
            TF_targetDir.setText(targetDir);
        }

    }
    
    
    
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
 
    }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Look and Feel"> 
    private void feel() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // </editor-fold>
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TA_displayText = new javax.swing.JTextArea();
        btn_clearTxt = new javax.swing.JButton();
        btn_saveLog = new javax.swing.JButton();
        btn_Quit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TA_srcDir = new javax.swing.JTextArea();
        TF_targetDir = new javax.swing.JTextField();
        lbl_backupDir = new javax.swing.JLabel();
        lbl_targetDir = new javax.swing.JLabel();
        btn_backupAllDir = new javax.swing.JButton();
        progBar_backupProgress = new javax.swing.JProgressBar();
        lbl_progBar = new javax.swing.JLabel();
        btn_loadDir = new javax.swing.JButton();
        btn_saveDir = new javax.swing.JButton();
        check_deleteBackups = new javax.swing.JCheckBox();
        btn_deleteHelp = new javax.swing.JButton();
        lbl_total = new javax.swing.JLabel();
        btn_sourceChooser = new javax.swing.JButton();
        btn_targetChooser = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuOptions = new javax.swing.JMenu();
        menu_Help = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BackupClicker v1.4");
        setResizable(false);

        TA_displayText.setEditable(false);
        TA_displayText.setColumns(20);
        TA_displayText.setLineWrap(true);
        TA_displayText.setRows(5);
        TA_displayText.setWrapStyleWord(true);
        jScrollPane1.setViewportView(TA_displayText);

        btn_clearTxt.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_clearTxt.setText("Clear");
        btn_clearTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearTxtActionPerformed(evt);
            }
        });

        btn_saveLog.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_saveLog.setText("Save Log");
        btn_saveLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveLogActionPerformed(evt);
            }
        });

        btn_Quit.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_Quit.setText("Quit");
        btn_Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuitActionPerformed(evt);
            }
        });

        TA_srcDir.setColumns(20);
        TA_srcDir.setRows(5);
        jScrollPane2.setViewportView(TA_srcDir);

        lbl_backupDir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_backupDir.setText("Source Directories");

        lbl_targetDir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_targetDir.setText("Target Directory");

        btn_backupAllDir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_backupAllDir.setText("Backup");
        btn_backupAllDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backupAllDirActionPerformed(evt);
            }
        });

        progBar_backupProgress.setStringPainted(true);

        lbl_progBar.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lbl_progBar.setText("Nothing is happening at the moment!");
        lbl_progBar.setToolTipText("");

        btn_loadDir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_loadDir.setText("Load Directories");
        btn_loadDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadDirActionPerformed(evt);
            }
        });

        btn_saveDir.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_saveDir.setText("Save Directories");
        btn_saveDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveDirActionPerformed(evt);
            }
        });

        check_deleteBackups.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        check_deleteBackups.setSelected(true);
        check_deleteBackups.setText("Delete old backups");
        check_deleteBackups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_deleteBackupsActionPerformed(evt);
            }
        });

        btn_deleteHelp.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btn_deleteHelp.setText("?");
        btn_deleteHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteHelpActionPerformed(evt);
            }
        });

        btn_sourceChooser.setText("Select Directories");
        btn_sourceChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sourceChooserActionPerformed(evt);
            }
        });

        btn_targetChooser.setText("Select Target");
        btn_targetChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_targetChooserActionPerformed(evt);
            }
        });

        menuOptions.setText("Options");
        menuOptions.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        menu_Help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menu_Help.setText("Help");
        menu_Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_HelpActionPerformed(evt);
            }
        });
        menuOptions.add(menu_Help);

        menuBar.add(menuOptions);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_progBar)
                                .addComponent(lbl_backupDir)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_clearTxt)
                                        .addComponent(btn_saveLog)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(TF_targetDir, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(lbl_targetDir))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btn_saveDir)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_loadDir))
                                        .addComponent(btn_sourceChooser)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(check_deleteBackups)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btn_deleteHelp))
                                        .addComponent(btn_targetChooser))))
                            .addComponent(lbl_total))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(progBar_backupProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Quit)
                        .addGap(18, 18, 18)
                        .addComponent(btn_backupAllDir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_clearTxt, btn_saveLog});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_saveLog)
                        .addGap(18, 18, 18)
                        .addComponent(btn_clearTxt))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(lbl_backupDir)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_sourceChooser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_saveDir)
                            .addComponent(btn_loadDir))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check_deleteBackups)
                            .addComponent(btn_deleteHelp))
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)))
                .addComponent(lbl_targetDir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_targetDir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_targetChooser))
                .addGap(18, 18, 18)
                .addComponent(lbl_total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_progBar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progBar_backupProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_backupAllDir)
                    .addComponent(btn_Quit))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lbl_progBar, progBar_backupProgress});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    
    public JProgressBar getProgressBar() {
        return progBar_backupProgress;
    }
    
    public JTextArea getOutputArea() {
        return TA_displayText;
    }
    
    public JTextArea getSourceArea() {
        return TA_srcDir;
    }
    
    public JTextField getTargetArea() {
        return TF_targetDir;
    }
    
    public JLabel getProgressLbl() {
        return lbl_progBar;
    }
    
    public JLabel getProgressTotal() {
        return lbl_total;
    }
    
    public JButton getBackupBtn() {
        return btn_backupAllDir;
    }
    
    public boolean getDeleteStatus() {
        return deleteOld;
    }
    

    
    
    
    
    private void btn_QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuitActionPerformed
      
        System.exit(0);
   
    }//GEN-LAST:event_btn_QuitActionPerformed

    
    private void btn_backupAllDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backupAllDirActionPerformed

        if ((TA_srcDir.getText().equals("")) || (TF_targetDir.getText().equals("")))
            JOptionPane.showMessageDialog(null,"Enter source directories and target destination!", "Error", JOptionPane.ERROR_MESSAGE);
        
        else {
            out("Now backing up your files. Please wait...");
            btn_backupAllDir.setEnabled(false);
            new Backup(this).execute();
        }
        
        
              
    }//GEN-LAST:event_btn_backupAllDirActionPerformed

  
    
    
    private void btn_clearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearTxtActionPerformed
       
        TA_displayText.setText(null);
    
    }//GEN-LAST:event_btn_clearTxtActionPerformed

    private void btn_saveLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveLogActionPerformed
 
        String txtLog = TA_displayText.getText();
        Utilities.saveLogs(txtLog);
        
        out("Log saved! File can be found in data/logs.txt");
        
    }//GEN-LAST:event_btn_saveLogActionPerformed

    private void btn_loadDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadDirActionPerformed
        
        autoLoad();
     
    }//GEN-LAST:event_btn_loadDirActionPerformed

    private void btn_saveDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveDirActionPerformed
       
        String[] src = TA_srcDir.getText().split("\\n"); // gets text from source box and target box, saves to file on click
        String target = TF_targetDir.getText();
        
        Utilities.saveDirList(src, target, targetFile, srcDirFile); 
        out("Directories saved! File can be found in data/src.txt & data/target.txt");
        
    }//GEN-LAST:event_btn_saveDirActionPerformed

    private void menu_HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_HelpActionPerformed
        
        try {
            Desktop.getDesktop().edit(new File("readme.txt"));
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    }//GEN-LAST:event_menu_HelpActionPerformed

    private void check_deleteBackupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_deleteBackupsActionPerformed
        
        deleteOld = check_deleteBackups.isSelected();
        
    }//GEN-LAST:event_check_deleteBackupsActionPerformed

    private void btn_deleteHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteHelpActionPerformed
        JOptionPane.showMessageDialog(null,"If you are taking a backup of a folder which already exists in your backup destination, \nthe old folder will be deleted, instead of the backup overwriting it.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btn_deleteHelpActionPerformed

    private void btn_sourceChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sourceChooserActionPerformed
        
        int result = sourceChooser.showDialog(sourceChooser, "Select");
        
        if (result == JFileChooser.APPROVE_OPTION) {
           for (File file : sourceChooser.getSelectedFiles()) 
               TA_srcDir.append(file.toString() + "\n");
           
            
        } 

        

    }//GEN-LAST:event_btn_sourceChooserActionPerformed

    private void btn_targetChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_targetChooserActionPerformed
        
        int result = targetChooser.showDialog(targetChooser, "Select");
        
        if (result == JFileChooser.APPROVE_OPTION) 
            TF_targetDir.setText(targetChooser.getSelectedFile().toString());
        

        
    }//GEN-LAST:event_btn_targetChooserActionPerformed

    
    
    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TA_displayText;
    private javax.swing.JTextArea TA_srcDir;
    private javax.swing.JTextField TF_targetDir;
    private javax.swing.JButton btn_Quit;
    private javax.swing.JButton btn_backupAllDir;
    private javax.swing.JButton btn_clearTxt;
    private javax.swing.JButton btn_deleteHelp;
    private javax.swing.JButton btn_loadDir;
    private javax.swing.JButton btn_saveDir;
    private javax.swing.JButton btn_saveLog;
    private javax.swing.JButton btn_sourceChooser;
    private javax.swing.JButton btn_targetChooser;
    private javax.swing.JCheckBox check_deleteBackups;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_backupDir;
    private javax.swing.JLabel lbl_progBar;
    private javax.swing.JLabel lbl_targetDir;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JMenuItem menu_Help;
    private javax.swing.JProgressBar progBar_backupProgress;
    // End of variables declaration//GEN-END:variables
}



