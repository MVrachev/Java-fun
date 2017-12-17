package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import bg.uni.sofia.fmi.mjt.sentiment.MovieReviewSentimentAnalyzer;
import bg.uni.sofia.fmi.mjt.sentiment.Pair;

class MovieReviewSentimentTest {	

	//private static Map<String,Pair> words;
	//private static MovieReviewSentimentAnalyzer processReviews;
	
	@Test
	void wordSentiment() {
		MovieReviewSentimentAnalyzer reviewsAnalyzer = new MovieReviewSentimentAnalyzer();

		Map<String,Pair> exampleWords = new HashMap<String,Pair>();
		exampleWords.put("me", new Pair(3,6));
		reviewsAnalyzer.setWords(exampleWords);
		assertTrue(reviewsAnalyzer.getWordSentiment("me") == 2 && reviewsAnalyzer.getWordSentiment("hi") == -1);
	}
	
	@Test
	void reviewSentimentAsName() {
		MovieReviewSentimentAnalyzer reviewsAnalyzer = 
				new MovieReviewSentimentAnalyzer("smallTest.txt","stopwords.txt");
		
		Map<String,Pair> words = new HashMap<String,Pair>();
		words.put("movie", new Pair(3,6));
		words.put("really", new Pair(2,4));
		words.put("bad", new Pair(2,2));
		words.put("horrible", new Pair(10,0));
		reviewsAnalyzer.setWords(words);
		String review = "The movie is really bad and horrible!";
		assertTrue(reviewsAnalyzer.getReviewSentimentAsName(review) == "somewhat negative");
	}
	
	@Test
	void getSentimentDictionarySize() {
		MovieReviewSentimentAnalyzer reviewsAnalyzer = 
				new MovieReviewSentimentAnalyzer("smallTest.txt","stopwords.txt");
		
		Map<String,Pair> exampleWords = new HashMap<String,Pair>();
		exampleWords.put("movie", new Pair(3,6));
		exampleWords.put("really", new Pair(2,4));
		exampleWords.put("bad", new Pair(2,2));
		exampleWords.put("horrible", new Pair(10,0));
		reviewsAnalyzer.setWords(exampleWords);
		assertTrue(reviewsAnalyzer.getSentimentDictionarySize() == 4);
	}  
	 
	
	@Test
	void mostFrequentWords() {

		Map<String,Pair> words = new HashMap<String,Pair>();
		MovieReviewSentimentAnalyzer processReviews = new MovieReviewSentimentAnalyzer();
		words.put("come", new Pair(2,2));
		words.put("here", new Pair(1,3));
		words.put("friend", new Pair(10,3));
		words.put("movie", new Pair(7,3));
		words.put("cool", new Pair(6,3));
		processReviews.setWords(words);
		Collection<String> trueResult = new ArrayList<String>();
		trueResult = processReviews.getMostFrequentWords(3);
		Collection<String> expectedResults = new ArrayList<String>();
		expectedResults.add("friend");
		expectedResults.add("movie");
		expectedResults.add("cool");
		assertEquals(expectedResults, trueResult);
		}
	
	@Test
	void getMostPositiveWords() {
		Map<String,Pair> words = new HashMap<String,Pair>();
		MovieReviewSentimentAnalyzer processReviews = new MovieReviewSentimentAnalyzer();
		words.put("come", new Pair(2,2));
		words.put("here", new Pair(1,3));
		words.put("friend", new Pair(10,3));
		words.put("movie", new Pair(7,14));
		words.put("cool", new Pair(6,24));
		processReviews.setWords(words); 
		List<String> expectedResult= new ArrayList<String>();
	
		expectedResult.add("cool");
		expectedResult.add("here");
		expectedResult.add("movie");
		expectedResult.add("come");
		expectedResult.add("friend");
		List<String> trueResult = (ArrayList<String>) processReviews.getMostPositiveWords(5);
		assertEquals(expectedResult, trueResult);
		}
	
	
	@Test
	void getMostNegativeWords() {
		
		Map<String,Pair> words = new HashMap<String,Pair>();
		MovieReviewSentimentAnalyzer processReviews = new MovieReviewSentimentAnalyzer();
		words.put("come", new Pair(2,2));
		words.put("here", new Pair(1,3));
		words.put("friend", new Pair(10,3));
		words.put("movie", new Pair(7,14));
		words.put("cool", new Pair(6,24));
		processReviews.setWords(words); 
		
		List<String> expectedResult= new ArrayList<String>();
		expectedResult.add("friend");
		expectedResult.add("come");
		expectedResult.add("movie");
		expectedResult.add("here");
		expectedResult.add("cool");
		List<String> trueResult = (ArrayList<String>) processReviews.getMostNegativeWords(5);
		assertEquals(expectedResult, trueResult);
	}

}
