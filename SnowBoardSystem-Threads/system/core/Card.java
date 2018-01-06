package system.core;

import java.time.LocalDateTime;

public class Card {

	private String nameOwner;
	private LocalDateTime timeHired;
	
	public Card(String owner, LocalDateTime timeHired) {
		this.nameOwner = owner;
		this.timeHired = timeHired;
	}
}
