package project.hotels.repository;

import project.hotels.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    Room save(Room room);

    List<Room> findAll();

    List<Room> searchRoom(int roomPrice);

    Optional<Room> findById(int roomPrice);

    void deleteById(int roomId);
}
