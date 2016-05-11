Current Version -  1.4

By Cameron Dempster
==============

To open the application, simply run BackupClicker.exe with Java Runtime Environment 8 or higher.
If you do not have JRE 8, follow this link: http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html


If this is your first timer using the application, you will need to either click the 'Select Directories' button to choose the directories you would
like to back up, or manually enter the directories line by line into the text area. Then, click the 'Select Target' button to choose the directory to
copy your files to, or again manually insert the directory yourself, and then click 'Backup'


If you back up the same directories often, after you have entered them into the source text area, you can click the Save Directories button to save them
to a text file, found in data/src.txt, then the next time the application is loaded, it will automatically load those directories for you. Alternatively, you
can also click the 'Load Directories' button.




DISCLAIMER: I do not accept any responsibility if you experience any data loss or any other issues. Data loss is a possible but rare occurence when 
moving large quantities of data with any program or manual transfer. Use at your own risk!




Changelog
==========

Version 1.4   - Further rebuilding of the backup process to increase efficiency
	      - Progress bar now scales with the amount of directories that have been copied
              - Cross platform support for the Help menu, now opens in the OS default text editor
              - Removed warning when the backup button was clicked whilst a backup was in progress, button is disabled during a backup instead
              - Source and target directories are now automatically loaded upon application start up, if they were saved previously
	      - Empty lines in the source directory text box are now removed, and trailing white space at the end of a directory path is now removed
              - Added labels above the progress bar to show the current directory being copied and how many directories have been copied so far, replaces the old
	        messages in the output area
              - Added a file chooser to allow the user to have an interface to choose their directories rather than manually entering them


Version 1.3.1 - Changed the way the backup process is handled, more efficient behind the scenes
	      - Can no longer take anothr backup while a backup is alreay in progress
              - File log now scrolls automatically
              - Fixed an issue where the program would freeze upon receiving a transfer error
              - Changed the font on the UI
              - User is now informed when they save directories & the file log


Version 1.2.1 - Additional program optimizations
	      - The file log is more user friendly, it will now inform the user what directories it is copying and/or deleting
	      - Added functionality to allow the program to delete old backups, instead of overwriting them, which could cause errors in copying
 	      - Added checkbox to allow the user to choose if they want to delete the old backups or simply overwrite them
	      - Removed error popups. If an error occurs, more precise details will now appear in the file log, allowing the user to identify the problem easier.


Version 1.1.1 - Added program icon
	      - Small program optimizations
              - Improved and more relevant error messages
              - Help menu now opens the readme file (currently Windows only)


Version 1.0.1 - Removed the automatic save function when user clicks backup button, instead added separate Save button to make this function independent


Version 1.0.0 - Release Build