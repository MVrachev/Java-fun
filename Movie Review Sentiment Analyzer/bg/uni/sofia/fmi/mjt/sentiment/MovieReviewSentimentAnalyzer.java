package bg.uni.sofia.fmi.mjt.sentiment;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import parse.input.ParseStopWords;
import parse.input.ParseMovieReview;


public class MovieReviewSentimentAnalyzer implements SentimentAnalyzer{

	private Set<String> stopWords;
	private Map<String,Pair> words;
	
	public MovieReviewSentimentAnalyzer() {}
	
	public MovieReviewSentimentAnalyzer(String reviewsFileName, String stopwordsFileName) {
		this.stopWords = ParseStopWords.parseInput(stopwordsFileName);
		this.words = ParseMovieReview.parseReviewsTrainingFile(reviewsFileName, stopWords);
	}
	 
	public void setWords(Map<String,Pair> words) {
		this.words = words;
	}
	
	public Map<String,Pair> getWords(){
		return this.words;
	}
	
	@Override
	public double getWordSentiment(String word) {
		Pair wordValues = words.get(word);
		if(words.get(word) == null){
			return -1.0;
		}
		return (wordValues.getSumRatings() / wordValues.getNumRatings());
	} 
	
	
	
	@Override
	public double getReviewSentiment(String review) {
		List<String> reviewIntoWords = ParseMovieReview.processReviewIntoWords(review);
		double sumOfWordSentiments = 0;
		double currWordSentiment = 0;
		int numberOfProcessedWords = 0;
		for(String word : reviewIntoWords) {
			if(stopWords.contains(word)) {
				continue;
			}
			currWordSentiment = this.getWordSentiment(word);
			if(currWordSentiment == -1.0){
				continue;
			}
			sumOfWordSentiments+= currWordSentiment;
			++numberOfProcessedWords;
		}
		
		if(numberOfProcessedWords == 0){
			return -1.0;
		}
		return (sumOfWordSentiments/numberOfProcessedWords);
	}

	// Standard rounding rules apply, e.g. 1.49 is 1 while 1.50 is 2
	@Override
	public String getReviewSentimentAsName(String review) {
		int overAllReviewSentiment = (int) this.getReviewSentiment(review);
		switch(overAllReviewSentiment){
		case 0: return "negative";
		case 1: return "somewhat negative";
		case 2: return "neutral";
		case 3: return "somewhat positive";
		case 4: return "positive";
		default: return "unknown";
		} 
	}

 
	
	/**
     * Returns a collection of the n most frequent words found in the reviews
     */
	@Override
	public Collection<String> getMostFrequentWords(int n) {
		
		List<Map.Entry<String, Pair>>entries = new ArrayList<Map.Entry<String,Pair>>(words.entrySet());
		Comparator<Map.Entry<String, Pair>> currComparator = new Comparator<Map.Entry<String, Pair>>() {
            public int compare(Map.Entry<String, Pair> o1, Map.Entry<String, Pair> o2) {
                return Integer.compare(o1.getValue().getNumRatings(), o2.getValue().getNumRatings());}};
		Collections.sort(entries,Collections.reverseOrder(currComparator));

		
		List<String> mostFrequentWords = new ArrayList<String>();
		int i = 0;
		for(Map.Entry<String, Pair> entry : entries) {
			if(i >= n) {
				break;
			}
			mostFrequentWords.add(entry.getKey());
			++i;
		}
		return mostFrequentWords;
	}

	
	// Two helper functions for getMostPositive and getMostNegative functions 
	private List<Map.Entry<String, Double>> createPairEntries(){
		
        Map<String,Double> allWordsSentiments= new HashMap<String,Double>();
		
		List<Map.Entry<String, Pair>>entries = new ArrayList<Map.Entry<String,Pair>>(words.entrySet());
		for(Map.Entry<String, Pair> entry : entries) {
			allWordsSentiments.put(entry.getKey(), this.getWordSentiment(entry.getKey()));
		}
		
		List<Map.Entry<String, Double>> allWordSentimentsPair = 
				new ArrayList<Map.Entry<String, Double>>(allWordsSentiments.entrySet());
		return allWordSentimentsPair;
	}
	
	
	private List<Map.Entry<String, Double>> sortEntries
			(List<Map.Entry<String, Double>> allWordSentimentsPair, boolean isReversed){
		
		Comparator<Map.Entry<String, Double>> currComparator = 
				new Comparator<Map.Entry<String,Double>>(){
				public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
						return Double.compare(o1.getValue(),o2.getValue());
					}};
					
				if(isReversed == true) {
					Collections.sort(allWordSentimentsPair,Collections.reverseOrder(currComparator));
				}
				else {
					Collections.sort(allWordSentimentsPair,currComparator);
				}
				return allWordSentimentsPair;
	}
	
	
	/**
     * Returns a collection of the n most positive words in the reviews
     */
	@Override
	public Collection<String> getMostPositiveWords(int n) {
		
		List<Map.Entry<String, Double>> allWordSentimentsPair = 
				this.sortEntries(this.createPairEntries(), true);
		
		
		List<String> result = new ArrayList<String>();
		int i = 0;
		for(Map.Entry<String, Double> entry: allWordSentimentsPair) {
			if (i >= n) {
				break;
			}
			result.add(entry.getKey());
			++i;
		}
		return result;
	}

	  /**
     * Returns a collection of the n most negative words in the reviews
     */
	@Override
	public Collection<String> getMostNegativeWords(int n) {
		
		
		List<Map.Entry<String, Double>> allWordSentimentsPair = 
				this.sortEntries(this.createPairEntries(), false);
		
		List<String> result = new ArrayList<String>();
		int i = 0;
		for(Map.Entry<String, Double> entry: allWordSentimentsPair) {
			if (i >= n) {
				break;
			}
			result.add(entry.getKey());
			++i;
		}
		return result;
	} 
	
 
	@Override
	public int getSentimentDictionarySize() {
		return words.size();
	}

	@Override
	public boolean isStopWord(String word) {
		return (stopWords.contains(word) == true ? true : false);
	}
	 

}
