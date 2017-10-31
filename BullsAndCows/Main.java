
// The task is from here:
// https://github.com/fmi/java-course/tree/master/03-oop-in-java-ii/lab

import java.util.Scanner;
public class Main {
	
	private static int numDigits = 0;
	
	public void setNumberDigits(int n) {
		numDigits = n;
		
	}
	
	public static int getComputerNumber() {
		
		return GameLogic.getCompNum(numDigits);
	}
	
	
	public static void clearComputerNumber() {
		GameLogic.clearComputerNumber();
	}
	
	public static void main(String [] args) {
		
		Main work = new Main();
		GameLogic game = new GameLogic();
		System.out.println("Enter length of play number:");
		Scanner in = new Scanner(System.in);
		
		String inputString = in.nextLine();
		int inputN = Integer.parseInt(inputString);
		
		work.setNumberDigits(inputN);
		game.setComputerNumberDigits(inputN);
		int guess = 0, bulls = 0, numberGuessDigits = 0, compNumber = 0;
		
		
		System.out.println("Enter the comp number ");
		inputString = in.nextLine();
		compNumber = Integer.parseInt(inputString);
		game.setCompNumTEST(compNumber);
		
		//System.out.println(getComputerNumber());
		while(bulls != inputN)
		{
			System.out.println("Enter your suggestion:");
			inputString = in.nextLine();
			numberGuessDigits = inputString.length();
			game.setGuessArr(numberGuessDigits);
			guess = Integer.parseInt(inputString);
			
			bulls = game.checkBulls(guess);
			System.out.println(bulls + " bulls and " + game.checkCows(guess) + " cows" );
			game.flushArrays();
		}
		
		System.out.println("Finished");
		in.close();
		work.clearComputerNumber();
	}
}
