package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

public class Hall {

	// Number is the number of the hall
	private int number;
	private int rows;
	private int rowSeats;
	private Seat seats[][];

	public Hall(int number, int rows, int rowSeats) {
		this.number = number;
		this.rows = rows;
		this.rowSeats = rowSeats;
		seats = new Seat[rows][];
		for (int i = 0; i < rows; ++i) {
			seats[i] = new Seat[rowSeats];
			for (int j = 0; j < rowSeats; ++j) {
				seats[i][j] = new Seat();
			}
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getRowSeats() {
		return rowSeats;
	}

	public void setRowSeats(int rowSeats) {
		this.rowSeats = rowSeats;
	}

	public boolean isSeatInHall(Seat seat) {
		if (seat == null)
			return false;
		if (seat.getRow() < 1 || seat.getRow() > rows || seat.getSeat() < 1 || seat.getSeat() > rowSeats)
			return false;
		return true;

	}

	public boolean reserveASeat(Seat seat) {
		if (seat == null) {
			return false;
		}

		if (seats[seat.getRow()][seat.getSeat()].getIsItReserved() == true) {
			return false;
		}

		seats[seat.getRow()][seat.getSeat()].setIsItReserved(true);
		return true;
	}

	public boolean freeASeat(Seat seat) {

		if (seat == null) {
			return false;
		}

		if (seats[seat.getRow()][seat.getSeat()].getIsItReserved() == false) {
			return false;
		}

		seats[seat.getRow()][seat.getSeat()].setIsItReserved(false);
		return true;
	}

	public int countFreeSeats() {
		int result = rows * rowSeats;

		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < rowSeats; ++j) {
				if (seats[i][j] != null && seats[i][j].getIsItReserved() == true) {
					--result;
				}
			}
		}
		return result;

	}

}
