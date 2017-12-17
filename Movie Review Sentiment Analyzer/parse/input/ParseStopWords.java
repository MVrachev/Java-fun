package parse.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class ParseStopWords {

	public static Set<String> parseInput(String fileNameStopWords){
		
		Set<String> stopWords = new HashSet<String>();
		try(BufferedReader r = new BufferedReader(new FileReader(fileNameStopWords))) {
			String line;
			 
			while((line = r.readLine()) != null) {
				stopWords.add(line);
			};
			
		} catch(Exception e) {
			e.printStackTrace(); 
		}
		
		return stopWords;
		
	}
	
}

