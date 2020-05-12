package project.hotels.repository;

import org.springframework.stereotype.Repository;
import project.hotels.model.Hotel;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository {
    Hotel save(Hotel hotel);

    List<Hotel> findAll();

    List<Hotel> searchHotel(String hotelName);

    Optional<Hotel> findById(int hotelId);

    void deleteById(int hotelId);
}
