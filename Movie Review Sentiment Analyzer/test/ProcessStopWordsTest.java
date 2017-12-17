package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import parse.input.ParseStopWords;

class ProcessStopWordsTest {
	
	@Test
	void containingWords() {
		Set<String> stopWords = ParseStopWords.parseInput("smallStopWords.txt");
		assertTrue(stopWords.contains("a") && stopWords.contains("about") &&
				   stopWords.contains("above") && stopWords.contains("after"));
	}
 
}
