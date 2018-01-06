package system.core;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDateTime;

import client.Snowboarder;

public class CashDesk  {

	private static final int MAX_CLIENT_CAPACITY = 1000;
	private static final int CARD_PRICE = 50;
	private static final int DEPOSIT = 1;
	
	private AtomicInteger usedClientCapacity;
	private AtomicInteger overallMoney;
	private AtomicInteger overAllHiredCards;
	private Vector<Card> cardsGiven;
	
	public CashDesk() {
		usedClientCapacity = new AtomicInteger(0);
		overallMoney = new AtomicInteger(0);
		overAllHiredCards = new AtomicInteger(0);
		cardsGiven = new Vector<Card>();
	}
	
	public synchronized void buyCard(Snowboarder newClient){
	
		if (usedClientCapacity.get() >= MAX_CLIENT_CAPACITY) {
			
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		overallMoney.set(overallMoney.get() + CARD_PRICE + DEPOSIT);
		usedClientCapacity.set(usedClientCapacity.get() + 1);
		overAllHiredCards.set(overAllHiredCards.get() + 1);
		Card newCard = new Card(newClient.getName(), LocalDateTime.now());
		cardsGiven.add(newCard);
	}
	
	public synchronized void returnCard() {
		if( usedClientCapacity.get() <= 0) {
			return;
		}
		overallMoney.set(overallMoney.get() - DEPOSIT);
		usedClientCapacity.set(usedClientCapacity.get() - 1);
		cardsGiven.remove(cardsGiven.size() - 1);
		
		if(usedClientCapacity.get() == MAX_CLIENT_CAPACITY - 1) {
			notify();
		}
	}
	
	public void cashDetails() {
		System.out.println("Money in the cash desk: " + overAllHiredCards.get()*CARD_PRICE);
		System.out.println("Cards hired: " + overAllHiredCards.get());
	}
	
	
}
