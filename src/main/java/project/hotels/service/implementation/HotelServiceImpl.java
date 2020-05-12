package project.hotels.service.implementation;

import org.springframework.stereotype.Service;
import project.hotels.model.*;
import project.hotels.repository.HotelRepository;
import project.hotels.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    public final HotelRepository hotelRepository;
    public final RoomService roomService;
    public final GuestService guestService;
    public final ReservationService reservationService;
    public final WorkerService workerService;

    public HotelServiceImpl(HotelRepository hotelRepository,
                            RoomService roomService,
                            GuestService guestService,
                            ReservationService reservationService,
                            WorkerService workerService) {
        this.hotelRepository = hotelRepository;
        this.roomService = roomService;
        this.guestService = guestService;
        this.reservationService = reservationService;
        this.workerService = workerService;
    }

    @Override
    public Hotel save(Hotel hotel) {

        List<Room> rooms = this.roomService.findAllRooms();
        List<Guest> guests = this.guestService.findAllGuests();
        List<Reservation> reservations = this.reservationService.findAllReservations();
        List<Worker> workers = this.workerService.findAllWorkers();

        List<Room> roomsInHotel = new ArrayList<>();
        List<Guest> guestsInHotel = new ArrayList<>();
        List<Reservation> reservationsInHotel = new ArrayList<>();
        List<Worker> workersInHotel = new ArrayList<>();

        for (Room room: rooms) {
            if(room.getHotelId() == hotel.getHotelId())
                roomsInHotel.add(room);
        }

        for (Guest guest: guests) {
            if(guest.getHotelId() == hotel.getHotelId())
                guestsInHotel.add(guest);
        }

        for (Reservation reservation: reservations) {
            if(reservation.getHotelId() == hotel.getHotelId())
                reservationsInHotel.add(reservation);
        }

        for (Worker worker: workers) {
            if(worker.getHotelId() == hotel.getHotelId())
                workersInHotel.add(worker);
        }

        Hotel newHotel = new Hotel(hotel.getHotelId(), hotel.getHotelName(),
                hotel.getHotelAddress(), hotel.getHotelEmail(), roomsInHotel,workersInHotel,
                guestsInHotel, reservationsInHotel);

        return this.hotelRepository.save(newHotel);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return this.hotelRepository.findAll();
    }

    @Override
    public List<Hotel> searchHotel(String hotelName) {
        return this.hotelRepository.searchHotel(hotelName);
    }

    @Override
    public Optional<Hotel> findById(int hotelId) {
        return this.hotelRepository.findById(hotelId);
    }

    @Override
    public void deleteById(int hotelId) {
        this.hotelRepository.deleteById(hotelId);
    }
}
