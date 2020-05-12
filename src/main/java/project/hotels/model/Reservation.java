package project.hotels.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Getter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservationId;
    private int roomId;
    private String dateIn;
    private String dateOut;
    private int guestId;
    private int hotelId;

    public Reservation(int reservationId, int roomId, String dateIn, String dateOut, int guestId, int hotelId) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.guestId = guestId;
        this.hotelId = hotelId;
    }

    public Reservation() {

    }


    public int getHotelId() {
        return hotelId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getDateIn() {
        return dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public int getGuestId() {
        return guestId;
    }
}
