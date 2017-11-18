package bg.uni.sofia.fmi.mjt.cinema.reservation.system.core;

import java.time.LocalDateTime;

public class Projection {

	private Movie movie;
	private Hall hall;
	private LocalDateTime date;

	public Projection(Movie movie, Hall hall, LocalDateTime date) {
		this.movie = movie;
		this.hall = hall;
		this.date = date;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((hall == null) ? 0 : hall.hashCode());
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		return result;
	}

}
