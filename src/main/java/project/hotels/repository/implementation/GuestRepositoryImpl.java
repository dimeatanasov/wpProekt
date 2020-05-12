package project.hotels.repository.implementation;

import org.springframework.stereotype.Repository;
import project.hotels.dataHolder.DataHolder;
import project.hotels.model.Guest;
import project.hotels.repository.GuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GuestRepositoryImpl implements GuestRepository {
    @Override
    public Guest save(Guest guest) {

        this.findById(guest.getGuestId()).ifPresent(DataHolder.guests::remove);
        DataHolder.guests.add(guest);
        return guest;
    }

    @Override
    public List<Guest> findAll() {
        return new ArrayList<>(DataHolder.guests);
    }

    @Override
    public List<Guest> searchGuest(String guestName) {
        return DataHolder.guests.stream()
                .filter(g -> g.getGuestName().contains(guestName) || g.getGuestLastName().contains(guestName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Guest> findById(int guestId) {
        return DataHolder.guests.stream().filter(g -> g.getGuestId() == guestId).findFirst();
    }

    @Override
    public void deleteById(int guestId) {
        this.findById(guestId).ifPresent(DataHolder.guests::remove);
    }
}
