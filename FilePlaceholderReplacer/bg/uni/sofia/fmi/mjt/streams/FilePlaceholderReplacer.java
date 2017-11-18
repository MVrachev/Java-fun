package bg.uni.sofia.fmi.mjt.streams;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.PrintWriter;
import java.io.Reader;

import java.util.HashMap;
import java.util.Map;

public class FilePlaceholderReplacer {

	public static void replace(String fromFileName, String toFileName, Map<String, String> placeholders) {

		try (Reader in = new FileReader(fromFileName)) {

			BufferedReader buffer = new BufferedReader(in);
			String line = null;

			PrintWriter out = new PrintWriter(toFileName);
			String inputStr = "";
			while((line = buffer.readLine()) != null) {
				inputStr += line;
				inputStr += System.getProperty("line.separator");
			}
			inputStr = 
					inputStr.substring(0, inputStr.length() - System.getProperty("line.separator").length());
			StringReplacer strReplace = new StringReplacer(inputStr);

			String resultText = strReplace.replace(placeholders);
			
			out.println(resultText);
			out.flush();


		} catch (Exception problem) {
			problem.printStackTrace();
		}

	}

	public static void main(String[] args) {

		// System.out.println("Give me a file:");
		String fromFileName = "Test.txt";
		String toFileName = "result.txt";
		HashMap<String, String> placeHolders = new HashMap<String, String>();
		placeHolders.put("name", "Marti");
		placeHolders.put("date", "15-17 december 2017");
		FilePlaceholderReplacer.replace(fromFileName, toFileName, placeHolders);

	}
}
