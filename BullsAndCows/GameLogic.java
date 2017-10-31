import java.util.Random;

public class GameLogic {
	public static int computerNumber = -1;
	private int computerNumDigits = 0;
	private int guessNumDigits = 0;
	private boolean guessArr[];
	private boolean compNumArr[];

	//private int bulls = 0;
	//private int cows = 0;
	
	public void setComputerNumberDigits(int n) {
		computerNumDigits = n;
		compNumArr = new boolean[n];
		for(int i = 0; i < n; ++i)
		{
			compNumArr[i] = false;
		}
	}
	
	
	public void setGuessArr(int numDigits) {
		guessNumDigits = numDigits;
		guessArr = new boolean[numDigits];
		for(int i = 0; i < numDigits; ++i)
		{
			guessArr[i] = false;
		}
	}
	
	
	public static void clearComputerNumber() {
		computerNumber = -1;
	}
	/*
	public void setBull(int bull) {
		this.bulls = bull;
	}
	public void setCows(int cows) {
		this.cows = cows;
	}
	*/
	
	// For tests purposes only
	public void setCompNumTEST(int n) {
		computerNumber = n;
	}
	
	public static int getCompNum(int n) {
		if(computerNumber == -1)
		{
			
			int min = (int)Math.pow(10,n - 1), max = (int)Math.pow(10, n);
			Random rand = new Random();
			int result = rand.nextInt(max - min) + min;
			computerNumber = result;
		
		}
		return computerNumber;
	}
	
	public int checkBulls(int guess) {
		int countCompNum =  0, countGuessNum = 0, compNum = computerNumber,
				result = 0;
		while(countCompNum < computerNumDigits && countGuessNum < guessNumDigits)
		{
			if(guess % 10 == compNum % 10)
			{
				++result;
				guessArr[countGuessNum] = true;
				compNumArr[countCompNum] = true;
			}
			guess /=10;
			compNum /=10;
			++countCompNum;
			++countGuessNum;
		}
		return result;
		
	}
	
	
	private boolean inCompNum(int guessDigit) {
		
		int count = 0, currCompNum = 0, computerNum = computerNumber;
		while(count < computerNumDigits)
		{
			if(compNumArr[count] == true)
			{
				computerNum /= 10;
				++count;
				continue;
			}
			currCompNum = computerNum % 10;
			if(guessDigit == currCompNum)
			{
				compNumArr[count] = true;
				return true;
			}
			computerNum/=10;
			++count;
		}
		return false;
	}
	
	public int checkCows(int guess) {
		int countCompNum =  0, countGuessNum = 0, currentGuessDigit = 0, result = 0;
		while(countCompNum < computerNumDigits && countGuessNum < guessNumDigits)
		{
			if(guessArr[countGuessNum] == true)
			{
				guess/=10;
				++countGuessNum;
				++countCompNum;
				continue;
			}
			currentGuessDigit = guess % 10;
			if(inCompNum(currentGuessDigit))
			{	
				++result;
				guessArr[countGuessNum] = true;
			}
			guess/=10;
			++countGuessNum;
			++countCompNum;
		}
		
		return result;
	}
	
	public void flushArrays() {
		
		for(int i = 0; i < computerNumDigits; ++i)
		{
			compNumArr[i] = false;
		}
		for(int i = 0; i < guessNumDigits; ++i)
		{
			guessArr[i] = false;
		}
	}
}
