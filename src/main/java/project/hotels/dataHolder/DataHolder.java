package project.hotels.dataHolder;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.hotels.model.*;
import project.hotels.repository.jpaRepository.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
@Getter
public class DataHolder {
    public static final List<Hotel> hotels = new ArrayList<>();
    public static final List<Room> rooms = new ArrayList<>();
    public static final List<Guest> guests = new ArrayList<>();
    public static final List<Reservation> reservations= new ArrayList<>();
    public static final List<Worker> workers = new ArrayList<>();

    public final jpaGuestRepository jpaGuestRepository;
    public final jpaHotelRepository jpaHotelRepository;
    public final jpaReservationRepository jpaReservationRepository;
    public final jpaRoomRepository jpaRoomRepository;
    public final jpaWorkerRepository jpaWorkerRepository;


    public DataHolder(jpaGuestRepository jpaGuestRepository,
                      jpaHotelRepository jpaHotelRepository,
                      jpaReservationRepository jpaReservationRepository,
                      jpaRoomRepository jpaRoomRepository,
                      jpaWorkerRepository jpaWorkerRepository) {

        this.jpaGuestRepository = jpaGuestRepository;
        this.jpaHotelRepository = jpaHotelRepository;
        this.jpaReservationRepository = jpaReservationRepository;
        this.jpaRoomRepository = jpaRoomRepository;
        this.jpaWorkerRepository = jpaWorkerRepository;
    }

    @PostConstruct
    public void init() {

        hotels.add(new Hotel(0, "Hotel Feni", "Kavadarci","feni@gmail.com",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        hotels.add(new Hotel(1, "Hotel Angropromet", "Kavadarci",
                "angropromet@gmail.com",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        hotels.add(new Hotel(2, "Hotel Continental", "Skopje",
                "continental@gmail.com",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        hotels.add(new Hotel(3, "Hotel Marriot", "Skopje","marriot@gmail.com",
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        rooms.add(new Room(0, 11,2, 20, 0));
        rooms.add(new Room(1, 64,1, 15, 1));
        rooms.add(new Room(2, 23,2, 20, 1));
        rooms.add(new Room(3, 345,2, 20, 3));
        rooms.add(new Room(4, 253,3, 30, 2));
        rooms.add(new Room(5, 67,4, 40, 3));

        guests.add(new Guest(0, "Petko", "Petkovski", 0, 1234));
        guests.add(new Guest(1, "Dime", "Atanasov", 2, 1221));
        guests.add(new Guest(2, "Tamara", "Gorgieva", 3, 1123));
        guests.add(new Guest(3, "Trajko", "Trajkovski", 3, 1243));
        guests.add(new Guest(4, "Elizabeta", "Dimova", 1, 1212));
        guests.add(new Guest(5, "Marko", "Markovski", 1, 1324));

        reservations.add(new Reservation(0, 0, "10.03.2020", "16.03.2020",
                0, 0));
        reservations.add(new Reservation(1, 4, "10.03.2020", "16.03.2020",
                1, 2));
        reservations.add(new Reservation(2, 3, "10.03.2020", "16.03.2020",
                2, 3));
        reservations.add(new Reservation(3, 1, "10.03.2020", "16.03.2020",
                4, 1));
        reservations.add(new Reservation(4, 2, "10.03.2020", "16.03.2020",
                5, 1));
        reservations.add(new Reservation(5, 5, "10.03.2020", "16.03.2020",
                3, 3));

        workers.add(new Worker(0, "Petar", "Petrov", 0, 1));
        workers.add(new Worker(1, "Igor", "Letnikov", 0, 2));
        workers.add(new Worker(2, "Kire", "Kirov", 1, 1));
        workers.add(new Worker(3, "Milena", "Milanova", 1, 2));
        workers.add(new Worker(4, "Ana", "Acevska", 2, 1));
        workers.add(new Worker(5, "Nadica", "Arsova", 2, 2));
        workers.add(new Worker(6, "Goke", "Gokov", 3, 1));
        workers.add(new Worker(7, "Ile", "Ilov", 3, 2));
    }

}
