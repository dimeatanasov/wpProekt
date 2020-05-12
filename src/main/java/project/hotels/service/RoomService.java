package project.hotels.service;

import project.hotels.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room save(Room room);

    List<Room> findAllRooms();

    List<Room> searchRoom(int roomPrice);

    Optional<Room> findById(int roomId);

    void deleteById(int roomId);
}
