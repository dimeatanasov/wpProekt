package project.hotels.controller.restController;

import org.springframework.web.bind.annotation.*;
import project.hotels.model.Room;
import project.hotels.service.RoomService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/rooms")
public class RoomRestController {
    private final RoomService roomService;


    public RoomRestController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> findAll(){
        return this.roomService.findAllRooms();
    }

    @GetMapping("/findByPrice")
    public List<Room> findByPrice(@RequestParam int roomPrice){
        return this.roomService.searchRoom(roomPrice);
    }

    @GetMapping("/{id}")
    public Optional<Room> findById(@PathVariable int id){
        return this.roomService.findById(id);
    }

    @PostMapping
    public Room save(@Valid @RequestBody Room room){
        return this.roomService.save(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable int id){
        this.roomService.deleteById(id);
    }

}
