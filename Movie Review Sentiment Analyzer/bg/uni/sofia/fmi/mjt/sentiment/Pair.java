package bg.uni.sofia.fmi.mjt.sentiment;


public class Pair {

	private int numRatings;
	private int sumRatings;
	
	public Pair(){}
	
	public Pair(int numRatings , int sumRatings) {
		this.numRatings = numRatings;
		this.sumRatings = sumRatings;
	}
	
	public int getSumRatings() {
		return sumRatings;
	}
	public void setSumRatings(int sumRatings) {
		this.sumRatings = sumRatings;
	}
	public int getNumRatings() {
		return numRatings;
	}
	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}


	
	
}
