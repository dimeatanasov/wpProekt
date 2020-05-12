package project.hotels.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Getter
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int guestId;
    private String guestName;
    private String guestLastName;
    private int hotelId;
    private int idLicence;

    public Guest(int guestId, String guestName, String guestLastName, int hotelId, int idLicence) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.guestLastName = guestLastName;
        this.hotelId = hotelId;
        this.idLicence = idLicence;
    }

    public Guest() {

    }

    public int getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getIdLicence() {
        return idLicence;
    }

}
