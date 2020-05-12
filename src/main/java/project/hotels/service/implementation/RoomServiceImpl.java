package project.hotels.service.implementation;

import org.springframework.stereotype.Service;
import project.hotels.model.Room;
import project.hotels.repository.RoomRepository;
import project.hotels.service.RoomService;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    public final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room save(Room room) {
        return this.roomRepository.save(room);
    }

    @Override
    public List<Room> findAllRooms() {
        return this.roomRepository.findAll();
    }

    @Override
    public List<Room> searchRoom(int roomPrice) {
        return this.roomRepository.searchRoom(roomPrice);
    }

    @Override
    public Optional<Room> findById(int roomId) {
        return this.roomRepository.findById(roomId);
    }

    @Override
    public void deleteById(int roomId) {
        this.roomRepository.deleteById(roomId);
    }
}
