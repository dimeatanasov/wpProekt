package project.hotels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.hotels.model.*;
import project.hotels.service.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hotels")
public class ProjectHotelsControler {

    public final GuestService guestService;
    public final HotelService hotelService;
    public final ReservationService reservationService;
    public final RoomService roomService;
    public final WorkerService workerService;

    public ProjectHotelsControler(GuestService guestService,
                                  HotelService hotelService,
                                  ReservationService reservationService,
                                  RoomService roomService,
                                  WorkerService workerService) {
        this.guestService = guestService;
        this.hotelService = hotelService;
        this.reservationService = reservationService;
        this.roomService = roomService;
        this.workerService = workerService;
    }

    //HOTEL
    @GetMapping
    public String showHotels(Model model){

        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("/addHotel")
    public String addHotel(Model model){
        model.addAttribute("hotel", new Hotel());
        return "addHotel";
    }

    @PostMapping("/addHotel")
    public String saveHotel(@Valid Hotel hotel,
                            Model model){
        this.hotelService.save(hotel);
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("/{id}/editHotel")
    public String editHotel(Model model, @PathVariable int id){
        try{
            Optional<Hotel> optionalHotel = this.hotelService.findById(id);
            Hotel hotel = optionalHotel.get();
            model.addAttribute("hotel", hotel);
            return "addHotel";
        }catch(RuntimeException ex){
            return "redirect:/hotels/hotel?error=" + ex.getMessage();
        }
    }

    @PostMapping("/{id}/deleteHotel")
    public String deleteHotel(@PathVariable int id){
        this.hotelService.deleteById(id);
        return "redirect:/hotels";
    }

    //ROOM
    @GetMapping("/{id}/rooms")
    public String showRooms(Model model, @PathVariable int id){
        List<Room> allRooms = this.roomService.findAllRooms();
        List<Room> rooms = new ArrayList<>();
        Optional<Hotel> optionalHotel = this.hotelService.findById(id);
        Hotel hotel = optionalHotel.get();
        for (Room room: allRooms) {
            if(room.getHotelId() == id){
                rooms.add(room);
            }
        }

        model.addAttribute("rooms", rooms);
        model.addAttribute("hotel", hotel);
        return "rooms";
    }

    @GetMapping("/addRoom")
    public String addRoom(Model model){
        model.addAttribute("room", new Room());
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "addRoom";
    }

    @PostMapping("/addRoom")
    public String saveRoom(@Valid Room room,
                           Model model){
        this.roomService.save(room);
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("/{id}/editRoom")
    public String editRoom(Model model, @PathVariable int id){
        try{
            Optional<Room> optionalRoom = this.roomService.findById(id);
            Room room = optionalRoom.get();
            List<Hotel> hotels = this.hotelService.findAllHotels();
            model.addAttribute("hotels", hotels);
            model.addAttribute("room",room);
            return "addRoom";
        }catch(RuntimeException ex){
            return "redirect:/hotels/room?error=" + ex.getMessage();
        }
    }

    @PostMapping("/{id}/deleteRoom")
    public String deleteRoom(@PathVariable int id){
        this.roomService.deleteById(id);
        return "redirect:/hotels";
    }

    //GUEST
    @GetMapping("/{id}/guests")
    public String showGuests(Model model, @PathVariable int id){
        List<Guest> allGuests = this.guestService.findAllGuests();
        List<Guest> guests = new ArrayList<>();
        Optional<Hotel> optionalHotel = this.hotelService.findById(id);
        Hotel hotel = optionalHotel.get();
        for (Guest guest: allGuests) {
            if(guest.getHotelId() == id){
                guests.add(guest);
            }
        }

        model.addAttribute("guests", guests);
        model.addAttribute("hotel", hotel);
        return "guests";
    }

    @GetMapping("/addGuest")
    public String addGuest(Model model){
        model.addAttribute("guest", new Guest());
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "addGuest";
    }

    @PostMapping("/addGuest")
    public String saveGuest(@Valid Guest guest,
                            Model model){
        this.guestService.save(guest);
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("/{id}/editGuest")
    public String editGuest(Model model, @PathVariable int id){
        try{
            Optional<Guest> optionalGuest = this.guestService.findById(id);
            Guest guest = optionalGuest.get();
            List<Hotel> hotels = this.hotelService.findAllHotels();
            model.addAttribute("hotels", hotels);
            model.addAttribute("guest", guest);
            return "addGuest";
        }catch(RuntimeException ex){
            return "redirect:/hotels/guest?error=" + ex.getMessage();
        }
    }

    @PostMapping("/{id}/deleteGuest")
    public String deleteGuesst(@PathVariable int id){
        this.guestService.deleteById(id);
        return "redirect:/hotels";
    }

    //RESERVATION
    @GetMapping("/{id}/reservations")
    public String showReservations(Model model, @PathVariable int id){
        List<Reservation> allReservations= this.reservationService.findAllReservations();
        List<Reservation> reservations = new ArrayList<>();
        Optional<Hotel> optionalHotel = this.hotelService.findById(id);
        Hotel hotel = optionalHotel.get();
        for (Reservation reservation: allReservations) {
            if(reservation.getHotelId() == id){
                reservations.add(reservation);
            }
        }

        model.addAttribute("reservations", reservations);
        model.addAttribute("hotel", hotel);
        return "reservations";
    }

    @GetMapping("/addReservation")
    public String addReservation(Model model){
        model.addAttribute("reservation", new Reservation());
        List<Hotel> hotels = this.hotelService.findAllHotels();
        List<Room> rooms = this.roomService.findAllRooms();
        List<Guest> guests = this.guestService.findAllGuests();
        model.addAttribute("hotels", hotels);
        model.addAttribute("rooms", rooms);
        model.addAttribute("guests", guests);
        return "addReservation";
    }

    @PostMapping("/addReservation")
    public String saveReservation(@Valid Reservation reservation,
                                  Model model){
        this.reservationService.save(reservation);
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("/{id}/editReservation")
    public String editReservation(Model model, @PathVariable int id){
        try{
            Optional<Reservation> optionalReservation = this.reservationService.findById(id);
            Reservation reservation = optionalReservation.get();
            List<Hotel> hotels = this.hotelService.findAllHotels();
            List<Room> rooms = this.roomService.findAllRooms();
            List<Guest> guests = this.guestService.findAllGuests();
            model.addAttribute("hotels", hotels);
            model.addAttribute("rooms", rooms);
            model.addAttribute("guests", guests);
            model.addAttribute("reservation", reservation);
            return "addReservation";
        }catch(RuntimeException ex){
            return "redirect:/hotels/reservation?error=" + ex.getMessage();
        }
    }

    @PostMapping("/{id}/deleteReservation")
    public String deleteReservation(@PathVariable int id){
        this.reservationService.deleteById(id);
        return "redirect:/hotels";
    }

    //WORKER
    @GetMapping("/{id}/workers")
    public String showWorkers(Model model, @PathVariable int id){
        List<Worker> allWorkers = this.workerService.findAllWorkers();
        List<Worker> workers = new ArrayList<>();
        Optional<Hotel> optionalHotel = this.hotelService.findById(id);
        Hotel hotel = optionalHotel.get();
        for (Worker worker: allWorkers) {
            if(worker.getHotelId() == id){
                workers.add(worker);
            }
        }

        model.addAttribute("workers", workers);
        model.addAttribute("hotel", hotel);
        return "workers";
    }

    @GetMapping("/addWorker")
    public String addWorker(Model model){
        model.addAttribute("worker", new Worker());
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "addWorker";
    }

    @PostMapping("/addWorker")
    public String saveWorker(@Valid Worker worker,
                       Model model){
        this.workerService.save(worker);
        List<Hotel> hotels = this.hotelService.findAllHotels();
        model.addAttribute("hotels", hotels);
        return "hotels";
    }

    @GetMapping("/{id}/editWorker")
    public String editWorker(Model model, @PathVariable int id){
        try{
            Optional<Worker> optionalWorker = this.workerService.findById(id);
            Worker worker = optionalWorker.get();
            List<Hotel> hotels = this.hotelService.findAllHotels();
            model.addAttribute("hotels", hotels);
            model.addAttribute("worker",worker);
            return "addWorker";
        }catch(RuntimeException ex){
            return "redirect:/hotels/worker?error=" + ex.getMessage();
        }
    }

    @PostMapping("/{id}/deleteWorker")
    public String deleteWorker(@PathVariable int id){
        this.workerService.deleteById(id);
        return "redirect:/hotels";
    }

}
