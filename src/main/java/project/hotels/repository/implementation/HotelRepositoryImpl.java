package project.hotels.repository.implementation;

import org.springframework.stereotype.Repository;
import project.hotels.dataHolder.DataHolder;
import project.hotels.model.Hotel;
import project.hotels.repository.HotelRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HotelRepositoryImpl implements HotelRepository {
    @Override
    public Hotel save(Hotel hotel) {
        this.findById(hotel.getHotelId()).ifPresent(DataHolder.hotels::remove);
        DataHolder.hotels.add(hotel);
        return hotel;
    }

    @Override
    public List<Hotel> findAll() {
        return new ArrayList<>(DataHolder.hotels);
    }

    @Override
    public List<Hotel> searchHotel(String hotelName) {
        return DataHolder.hotels.stream()
                .filter(h -> h.getHotelName().contains(hotelName) || h.getHotelEmail().contains(hotelName) || h.getHotelAddress().contains(hotelName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Hotel> findById(int hotelId) {
        return DataHolder.hotels.stream().filter(h -> h.getHotelId() == hotelId).findFirst();
    }

    @Override
    public void deleteById(int hotelId) {
        this.findById(hotelId).ifPresent(DataHolder.hotels::remove);
    }
}
