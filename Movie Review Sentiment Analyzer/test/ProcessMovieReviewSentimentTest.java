package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import bg.uni.sofia.fmi.mjt.sentiment.Pair;
import parse.input.ParseMovieReview;

class ProcessMovieReviewSentimentTest {

	@Test
	void processReviewIntoWordsT() {
		String review = "!!!Come o%n ,D co!me here i aM yo.r tr!!ue faw1tHer 's hi!";
		List<String> expectedResult = new ArrayList<String>(Arrays.asList("come", "o","n", "d", "co", "me", "here",
				"i", "am", "yo", "r", "tr", "ue", "faw1ther", "s", "hi"));
		List<String> trueResult = ParseMovieReview.processReviewIntoWords(review);
		 assertEquals(trueResult,expectedResult);
	}
	  
	 
	
	@Test
	void processWord() {
		Map<String,Pair> words = new HashMap<String,Pair>();
		words.put("me", new Pair(3,4));
		words.put("hi", new Pair(2,2));
		
		ParseMovieReview.processWord(words, "me", 1);
		ParseMovieReview.processWord(words, "hi", 3);
		ParseMovieReview.processWord(words, "dis", 0);
		
		assertTrue(words.get("me").getNumRatings() == 4 && words.get("me").getSumRatings() == 5
		    && words.get("hi").getNumRatings() == 3 && words.get("hi").getSumRatings() == 5
		    && words.get("dis").getNumRatings() == 1 && words.get("dis").getSumRatings() == 0);
	}
	
	

}
