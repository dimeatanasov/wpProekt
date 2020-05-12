package project.hotels.service.implementation;

import org.springframework.stereotype.Service;
import project.hotels.model.Guest;
import project.hotels.repository.GuestRepository;
import project.hotels.service.GuestService;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {

    public final GuestRepository guestRepository;

    public GuestServiceImpl(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest save(Guest guest) {
        return this.guestRepository.save(guest);
    }

    @Override
    public List<Guest> findAllGuests() {
        return this.guestRepository.findAll();
    }

    @Override
    public List<Guest> searchGuest(String guestName) {
        return this.guestRepository.searchGuest(guestName);
    }

    @Override
    public Optional<Guest> findById(int guestId) {
        return this.guestRepository.findById(guestId);
    }

    @Override
    public void deleteById(int guestId) {
        this.guestRepository.deleteById(guestId);
    }
}
