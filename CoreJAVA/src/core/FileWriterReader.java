package core;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {
	public static void main(String[] args) throws IOException {
		String string = "hello java"; 
		FileWriter fr  = new FileWriter("t2.txt");
		fr.write(string);
		fr.flush();
		fr.close();
		System.err.println("written");
		
		FileReader fReader = new FileReader("t2.txt");
		int i;
		while((i = fReader.read())!=-1) {
			System.out.print((char)i);
		}
	}
}
