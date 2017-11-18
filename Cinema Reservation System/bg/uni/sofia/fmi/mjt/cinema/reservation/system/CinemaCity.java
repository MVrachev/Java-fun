package bg.uni.sofia.fmi.mjt.cinema.reservation.system;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Movie;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Projection;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.core.Ticket;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.AlreadyReservedException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.ExpiredProjectionException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.InvalidSeatException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.ProjectionNotFoundException;
import bg.uni.sofia.fmi.mjt.cinema.reservation.system.exceptions.ReservationNotFoundException;

public class CinemaCity implements CinemaReservationSystem {

	private HashMap<Movie, List<Projection>> cinemaProgram;

	public CinemaCity(Map<Movie, List<Projection>> cinemaProgram) {
		this.cinemaProgram = (HashMap<Movie, List<Projection>>) cinemaProgram;
	}

	@Override
	public void bookTicket(Ticket ticket) throws AlreadyReservedException, ProjectionNotFoundException,
			InvalidSeatException, ExpiredProjectionException {

		if (ticket == null || ticket.getProjection() == null || ticket.getProjection().getDate() == null) {
			return;
		}
		if (ticket.getProjection().getDate().isBefore(LocalDateTime.now())) {
			throw new ExpiredProjectionException();
		}

		ArrayList<Projection> currProjectionList = (ArrayList<Projection>) cinemaProgram
				.get(ticket.getProjection().getMovie());
		if (currProjectionList == null) {
			throw new ProjectionNotFoundException();
		}

		for (Projection projection : currProjectionList) {
			if (projection.equals(ticket.getProjection())) {

				if (projection.getHall().isSeatInHall(ticket.getSeat()) == false)
					throw new InvalidSeatException();

				if (projection.getHall().reserveASeat(ticket.getSeat()) == false) {
					throw new AlreadyReservedException();
				}
				// projection.getHall().reserveASeat(ticket.getSeat());
				return;
			}
		}

		throw new ProjectionNotFoundException();
	}

	@Override
	public void cancelTicket(Ticket ticket) throws ReservationNotFoundException, ProjectionNotFoundException {

		if (ticket == null)
			return;

		ArrayList<Projection> currProjectionList = (ArrayList<Projection>) cinemaProgram
				.get(ticket.getProjection().getMovie());

		for (Projection projection : currProjectionList) {
			if (projection.equals(ticket.getProjection())) {
				if (projection.getHall().freeASeat(ticket.getSeat()) == false) {
					throw new ReservationNotFoundException();
				}
				return;
			}
		}
		throw new ProjectionNotFoundException();

	}

	@Override
	public int getFreeSeats(Projection projection) throws ProjectionNotFoundException {

		ArrayList<Projection> currProjectionList = (ArrayList<Projection>) cinemaProgram.get(projection.getMovie());

		if (currProjectionList == null || currProjectionList.contains(projection) == false) {
			throw new ProjectionNotFoundException();
		}

		return projection.getHall().countFreeSeats();
	}

	@Override
	public Collection<Movie> getSortedMoviesByGenre() {

		Set<Movie> keys = cinemaProgram.keySet();
		if (keys == null)
			return null;
		ArrayList<Movie> keyList = new ArrayList<Movie>();
		keyList.addAll(keys);
		java.util.Collections.sort(keyList);
		return keyList;
	}

}
