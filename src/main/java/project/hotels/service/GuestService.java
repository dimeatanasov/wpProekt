package project.hotels.service;

import project.hotels.model.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    Guest save(Guest guest);

    List<Guest> findAllGuests();

    List<Guest> searchGuest(String guestName);

    Optional<Guest> findById(int guestId);

    void deleteById(int guestId);

}
