package project.hotels.service;

import project.hotels.model.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel save(Hotel hotel);

    List<Hotel> findAllHotels();

    List<Hotel> searchHotel(String hotelName);

    Optional<Hotel> findById(int hotelId);

    void deleteById(int hotelId);
}
