package project.hotels.repository;

import project.hotels.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);

    List<Reservation> findAll();

    List<Reservation> searchReservation(int reservationId);

    Optional<Reservation> findById(int reservationId);

    void deleteById(int reservationId);
}
