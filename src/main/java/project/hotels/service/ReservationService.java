package project.hotels.service;

import project.hotels.model.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    Reservation save(Reservation reservation);

    List<Reservation> findAllReservations();

    List<Reservation> searchReservation(int reservationId);

    Optional<Reservation> findById(int reservationId);

    void deleteById(int reservationId);
}
