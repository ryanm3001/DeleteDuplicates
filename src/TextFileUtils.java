import java.io.*;
import java.util.*;

public class TextFileUtils {
	
    public static List<String> readTextFile(String inputFile) throws IOException 
    {
        BufferedReader in = new BufferedReader(new FileReader(inputFile));  //open the file
        List<String> list = new ArrayList<String>();
			
        for (String line = null; (line = in.readLine()) != null;)   // append each line of a text file as separate element to List
        { 
            list.add(line);
        }
        
	in.close();                           // close input connection
        return list;
    }

    public static void writeTextFile(List<String> list, String outputFile) throws IOException 
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFile));
		
        for (String str : list)               // add elements of List outputFile 
        {
            out.println(str);
        }
        
	out.close();
    }

    // private constructor to disallow instantiation outside the class
    // Our goal is to provide a static library of tools.
    private TextFileUtils()
    {
	
    }
}
