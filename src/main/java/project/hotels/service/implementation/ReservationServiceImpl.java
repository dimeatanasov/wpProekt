package project.hotels.service.implementation;

import org.springframework.stereotype.Service;
import project.hotels.model.Reservation;
import project.hotels.repository.ReservationRepository;
import project.hotels.service.ReservationService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    public final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAllReservations() {
        return this.reservationRepository.findAll();
    }

    @Override
    public List<Reservation> searchReservation(int reservationId) {
        return this.reservationRepository.searchReservation(reservationId);
    }

    @Override
    public Optional<Reservation> findById(int reservationId) {
        return this.reservationRepository.findById(reservationId);
    }

    @Override
    public void deleteById(int reservationId) {
        this.reservationRepository.deleteById(reservationId);
    }
}
