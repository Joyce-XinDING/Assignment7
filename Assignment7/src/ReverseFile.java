import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;

/*1. Open a local file, read the file line by line. 
 * Each line should be imported as a string and stored in ArrayList. 
 * Then print out the ArrayList reversely. You can create your own file to test.
 */

public class ReverseFile extends JFrame{

	
	 public static void readFileByLines(FileInputStream fis) throws IOException {
		 InputStreamReader isr = new InputStreamReader(fis);  
		 BufferedReader reader = null;  
		 List<String> list = new ArrayList<String>();
	        try {  
	            reader = new BufferedReader(isr);  
	            String tempString = null;  
	            int line = 1;  
	            while ((tempString = reader.readLine()) != null) {  
	                
	                list.add(line-1, tempString);
	                line++;  
	            }  
	            reader.close();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (reader != null) {  
	                try {  
	                    reader.close();  
	                } catch (IOException e1) {  
	                }  
         }
	 }
	        Collections.reverse(list);
			for(String string:list){
				System.out.println(string + "");
			}
	 } 
	
	public static void main(String[] args) throws IOException {
		File file = new File("/Users/Joyce/Desktop/HW7TestFile.txt");
		FileInputStream fis = new FileInputStream(file);
		readFileByLines(fis);
		
		

	}

	
	}


