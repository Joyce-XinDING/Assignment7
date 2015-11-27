import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
//This is another solution for Question 1, because I don't know how to pass parameter to Q2 use ReverseFile.
public class RevFile {
	private File file;
	private FileInputStream fis;
	private InputStreamReader isr;
	private BufferedReader br;
	
	public RevFile(String string) throws FileNotFoundException {
		file = new File(string);
		fis = new FileInputStream(file);
		isr = new InputStreamReader(fis);
		br = new BufferedReader(isr);
	}
	public ArrayList<String> readbyline() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		while(true){
			String tempstring = br.readLine();
			if(tempstring==null){
				return list;
			}
			list.add(tempstring);
		}
	}
	public void Revlist (ArrayList<String> content){
		Collections.reverse(content);
		for(String string:content){
			System.out.println(string + "");
		}
	}
	public static void main(String[] args) throws IOException {
		RevFile RF = new RevFile("/Users/Joyce/Desktop/HW7TestFile.txt");
		RF.Revlist(RF.readbyline());
	}
}
