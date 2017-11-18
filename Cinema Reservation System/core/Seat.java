package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

public class Seat {

	private int row;
	private int seat;	// Seat is for the correct seat in the row
	private boolean isItReserved;
	
	public Seat() {}
	
	public Seat(int row, int seat) {
		this.row = row;
		this.seat = seat;
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getSeat() {
		return seat;
	}


	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	public boolean getIsItReserved() {
		return isItReserved;
	}


	public void setIsItReserved(boolean isItReserved) {
		this.isItReserved = isItReserved;
	}
	
	
}
