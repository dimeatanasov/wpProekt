package project.hotels.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;
    private int roomNumber;
    private int typeOfRoom;
    private int roomPrice;
    private int hotelId;

    public Room(int roomId, int roomNumber, int typeOfRoom, int roomPrice, int hotelId) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.typeOfRoom = typeOfRoom;
        this.roomPrice = roomPrice;
        this.hotelId = hotelId;
    }

    public Room() {

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getTypeOfRoom() {
        return typeOfRoom;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public int getHotelId() {
        return hotelId;
    }
}
