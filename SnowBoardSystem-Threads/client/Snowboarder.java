
package client;

import system.core.CashDesk;

public class Snowboarder implements Runnable {

	// Max and min time are for using a card 
	private static int MIN_USE = 10;
	private static int MAX_USE = 500;
	
	private String name;
	private int randomUse;
	
	// Every snowboarder is connected with a certain cash desk
	// which cash desk serves the snowboarder
	private CashDesk cashDeskServingTheSnowBoarder;
	
	public Snowboarder(String name, CashDesk cashDeskToBeUsed) {
		this.name = name;
		this.cashDeskServingTheSnowBoarder = cashDeskToBeUsed;
		randomUse = MIN_USE + ( (int)Math.random() * (MAX_USE - MIN_USE));
	}
	
	@Override
	public void run() {
		cashDeskServingTheSnowBoarder.buyCard(this);
		try {
			Thread.sleep(randomUse);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		cashDeskServingTheSnowBoarder.returnCard();
	}

	public String getName() {
		return name;
	}

	
}
