package bg.uni.sofia.fmi.mjt.streams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class AllTests {

	@Test
	public void replaceStringTest() {
		
		String input  = "Скъпи {name},\n"
 + "Включи се в най-якия хакатон по тези ширини," 
 + "FMI{Codes}! Очакваме те във ФМИ на {date}.";
		String expectedResult = "Скъпи Marti,\n"
				 + "Включи се в най-якия хакатон по тези ширини," 
				 + "FMI{Codes}! Очакваме те във ФМИ на 15-17 december 2017.";
		StringReplacer strReplacer = new StringReplacer(input);
		
		HashMap<String, String> placeHolders = new HashMap<String, String>();
		placeHolders.put("name", "Marti");
		placeHolders.put("date", "15-17 december 2017");
		String trueResult = strReplacer.replace(placeHolders);
		
		assertEquals(trueResult, expectedResult);	
	}

}

