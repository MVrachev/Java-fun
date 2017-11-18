package bg.uni.sofia.fmi.mjt.streams;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class AllTests {

	private String beginFilePath;
	private String resultFile;
	private String fileContains;
	private String result;
	private HashMap<String, String> dictionary;
	
	/*
	@Before
	public void inicialiase() {
		
		fileContains = "Скъпи {name},\r\n" + 
				"\r\n" + 
				"Включи се в най-якия хакатон по тези ширини, "
				+ "FMI{Codes}! Очакваме те във ФМИ на {date}.";
		String fromFileName = "Test.txt";
		String toFileName = "result.txt";
		HashMap<String, String> placeHolders = new HashMap<String, String>();
		placeHolders.put("name", "Marti");
		placeHolders.put("date", "15-17 december 2017");
		beginFilePath = "test.txt";
		try(PrintWriter out = new PrintWriter(beginFilePath)){
			
		}
	}
	*/
	
	/*
	
	//@Test
	public void firstTest() {
		String current = null;
		while ((current = buffer.readLine()) != null) {
			for (Map.Entry<String, String> entry : placeholders.entrySet()) {
				line = line.replace('{' + entry.getKey() + '}', entry.getValue());
			}
			out.println(line);
			out.flush();
			System.out.println(line);
			// out.println
		}
	}
	
	*/

}
