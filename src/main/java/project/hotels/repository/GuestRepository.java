package project.hotels.repository;

import project.hotels.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestRepository {
    Guest save(Guest guest);

    List<Guest> findAll();

    List<Guest> searchGuest(String guestName);

    Optional<Guest> findById(int guestId);

    void deleteById(int guestId);
}
