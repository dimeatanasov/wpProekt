package project.hotels.repository.implementation;

import org.springframework.stereotype.Repository;
import project.hotels.dataHolder.DataHolder;
import project.hotels.model.Reservation;
import project.hotels.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {
    @Override
    public Reservation save(Reservation reservation) {
        this.findById(reservation.getReservationId()).ifPresent(DataHolder.reservations::remove);
        DataHolder.reservations.add(reservation);
        return reservation;
    }

    @Override
    public List<Reservation> findAll() {
        return new ArrayList<>(DataHolder.reservations);
    }

    @Override
    public List<Reservation> searchReservation(int reservationId) {
        return DataHolder.reservations.stream()
                .filter(r -> r.getReservationId() == reservationId || r.getRoomId() == reservationId)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reservation> findById(int reservationId) {
        return DataHolder.reservations.stream().filter(r -> r.getReservationId() == reservationId).findFirst();
    }

    @Override
    public void deleteById(int reservationId) {
        this.findById(reservationId).ifPresent(DataHolder.reservations::remove);
    }
}
