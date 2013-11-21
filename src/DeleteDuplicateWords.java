import java.util.*;


public class DeleteDuplicateWords {

	public static void main(String[] args) {
				
		try {
			
			List<String> files = new ArrayList<String>();
			
			if(args.length == 0)
			{
				System.out.println("Argument required: java DeleteDuplicateWords <file.txt or directory>");	
			}
			else	
			{
				String argument = args[0];
			}
				
			
			if(argument.contains("."))    // identifies a file, and not a directory, and adds to List called file
			{	
				files.add(argument);	  // this is a file so add it to List called files
			}
			else			      		  // else gets a directory
			{
				FindTextFiles textFiles = new FindTextFiles(argument);   // Calls FindTextFiles class, passes the directory
				textFiles.getTextFilesFromDirectory();					 // 								 			
				files = textFiles.listOfFiles;							 // local variable files now contains a List of text files
			}
			}
			
		
			/*Now that input files and/or directories have been sorted, now we can read from text file, delete duplicate words,
		    then write the clean data back to the same filename */
		
			for (int i=0; i < files.size(); i++) // this loop allows program to iterate through multiple text files from the command line
			{
				// Step 1: Read Text From File
				List<String> textData = TextFileUtils.readTextFile(files.get(i));  // readTextFile() opens the file, appends each line
																				   // to a List, returns the List
				
				// Step 2: Process Text Data
				List<String> cleanData = deleteDuplicates(textData);    // deleteDuplicates passes textData from above, returns a List free of dublicate words
				
				
				// Step 3: Write Text Data to File
				TextFileUtils.writeTextFile(cleanData, files.get(i));   // pass List cleanData, and pass the file name, Returns the new clean data with 
																		// the same filename, thus replacing old file
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static List<String> deleteDuplicates(List<String> textData) {
		StringBuffer sb = new StringBuffer();
		List<String> localList = new ArrayList<String>();
		
		/* for each line in text file, split words such that each word is an element in tokens array,
		then compare leading element in array to following element. If they are the same word, append 
		the leading element only to StringBuffer, skipping the following element, then add the reformed
		line to localList. Then, return localList.*/
		for(String line : textData)     
		{
			String tokens[] = line.split(" ");
			int x = 0;
			int y = 1;
			
			while(x < tokens.length)
			{
				if(y == tokens.length)
				{
					sb.append(tokens[x] + " ");
					//break;
				}
				
				else if (tokens[x].equals(tokens[y]))
				{
					sb.append(tokens[x] + " ");
					x++;
					y++;
				}
				
				else
				{
					sb.append(tokens[x] + " ");
				}
				
				x++;
				y++;
			}
			
			localList.add(sb.toString());	
		 }
		
		

		return localList;
	}
	
	
	
}
