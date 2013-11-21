import java.io.*;
import java.util.*; 


public class FindTextFiles 
{
      List<String> nextDir = new ArrayList<String>();
      List<String> listOfFiles = new ArrayList<String>();
      String argument;


      public FindTextFiles(String argument)
      {
         this.argument = argument;
         
    	 nextDir.add(argument);                          // ArrayList nextDir either takes the parent directory from above; OR if an argument is entered at
                                                         // the command line, it receives the argument instead
      }
      
      
      public void getTextFilesFromDirectory()
      {
            while(nextDir.size() > 0)                    // size() returns number of elements in ArrayList nextDir
            { 
               File pathName = new File(nextDir.get(0)); // instantiate pathName with first element in ArrayList nextDir, which is a directory
               
               
               
               String[] fileNames = pathName.list();     // instantiates fileNames with an array of strings naming all files and directories in the 
               
               System.out.println(fileNames);
                                                         //      directory that pathName holds. Each string is a file name rather than a complete path. 
               for(int i = 0; i < fileNames.length; i++) // iterate through array fileNames
               { 
                  
                  File f = new File(pathName.getPath(), fileNames[i]); // make new file with File contructor that receives parent and child parameters
                                                                       // uses getPath() to get the pathname string (converted from abstract pathname) for the parent directory
                                                                       // in this loop, the child will continue to change, thus resinstantiating File f until we reach the end of array fileNames.
                  String string = f.getPath();		
                  int length1 = string.length() - 4;
                  int length2 = string.length();
                  String fileType = string.substring(length1, length2);
                  
                  
                  if (f.isDirectory())                                      // if this file is a directory (as opposed to a file???)...
                  { 
                     nextDir.add(f.getPath());                         // and add pathname to ArrayList<String> nextDir
                  }
                  else if(fileType.equals(".txt") )
                  {
                     listOfFiles.add(f.getPath());
                  }
                  
                } 
               nextDir.remove(0);                                      // while nextDir.size() > 0, loop; at end of each loop delete element at position 0
            }
            
      }


  }