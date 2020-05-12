package project.hotels.repository.implementation;

import org.springframework.stereotype.Repository;
import project.hotels.dataHolder.DataHolder;
import project.hotels.model.Room;
import project.hotels.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RoomRepositoryImpl implements RoomRepository {
    @Override
    public Room save(Room room) {
        this.findById(room.getRoomId()).ifPresent(DataHolder.rooms::remove);
        DataHolder.rooms.add(room);
        return room;
    }

    @Override
    public List<Room> findAll() {
        return new ArrayList<>(DataHolder.rooms);
    }

    @Override
    public List<Room> searchRoom(int roomPrice) {
        return DataHolder.rooms.stream()
                .filter(r -> r.getRoomPrice() == roomPrice)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Room> findById(int roomPrice) {
        return DataHolder.rooms.stream().filter(r -> r.getRoomId() == roomPrice).findFirst();
    }

    @Override
    public void deleteById(int roomId) {
        this.findById(roomId).ifPresent(DataHolder.rooms::remove);
    }
}
