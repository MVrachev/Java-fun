package parse.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bg.uni.sofia.fmi.mjt.sentiment.Pair;

public class ParseMovieReview {
	
		
		public static void processWord(Map<String,Pair> words, String word, int ranking) {
			
			if(words.containsKey(word) == true) {
				Pair newValue = 
						new Pair(words.get(word).getNumRatings() + 1,
								words.get(word).getSumRatings() + ranking);
				words.put(word, newValue);
			}
			else {
				words.put(word, new Pair(1,ranking));
			}
		}
		
		
		public static void mainProcessing(Map<String,Pair> words, Set<String> stopWords,
				List<String> reviewWords) {
			
			int ranking = reviewWords.get(0).charAt(0);
			for(int i = 1; i < reviewWords.size(); ++i) {
				if(stopWords.contains(reviewWords.get(i))) {
					continue;
				}
				processWord(words,reviewWords.get(i), ranking);
			}
		}
		
		public static List<String> processReviewIntoWords(String review) {
			
			String processedReview = review.toLowerCase();
			List<String> reviewWords = 
					new ArrayList<String>(Arrays.asList(processedReview.split("([^a-zA-Z0-9])+")));
			reviewWords.removeAll(Arrays.asList(""));
			return reviewWords;
		}
		
		
		public static Map<String,Pair> 
		     parseReviewsTrainingFile(String moveiReviewsFilePath, Set<String> stopWords){
			
			Map<String,Pair> words = new HashMap<String,Pair>();
			
			try(BufferedReader r = new BufferedReader(new FileReader(moveiReviewsFilePath))) {
				String review;
				List<String> reviewWords = new ArrayList<String>();
				while((review = r.readLine()) != null) {
					reviewWords = processReviewIntoWords(review);
					
					mainProcessing(words, stopWords, reviewWords);
				};
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return words;
		}
}
