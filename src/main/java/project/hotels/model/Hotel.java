package project.hotels.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelEmail;

    @ManyToMany
    private List<Room> rooms;
    @ManyToMany
    private List<Worker> workers;
    @OneToMany
    private List<Guest> guests;
    @ManyToMany
    private List<Reservation> reservations;

    public Hotel(int hotelId,
                 String hotelName,
                 String hotelAddress,
                 String hotelEmail,
                 List<Room> rooms,
                 List<Worker> workers,
                 List<Guest> guests,
                 List<Reservation> reservations) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelEmail = hotelEmail;
        this.rooms = rooms;
        this.workers = workers;
        this.guests = guests;
        this.reservations = reservations;
    }

    public Hotel() {

    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
