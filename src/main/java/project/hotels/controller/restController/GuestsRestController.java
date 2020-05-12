package project.hotels.controller.restController;

import org.springframework.web.bind.annotation.*;
import project.hotels.model.Guest;
import project.hotels.service.GuestService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/guests")
public class GuestsRestController {
    private final GuestService guestService;


    public GuestsRestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<Guest> findAll(@RequestParam(required = false) String guestName){
        if(guestName == null){
            return this.guestService.findAllGuests();
        }else{
            return this.guestService.searchGuest(guestName);
        }
    }

    @GetMapping("/findByName")
    public List<Guest> findByName(@RequestParam String guestName){
        return this.guestService.searchGuest(guestName);
    }

    @GetMapping("/{id}")
    public Optional<Guest> findById(@PathVariable int id){
        return this.guestService.findById(id);
    }

    @PostMapping
    public Guest save(@Valid @RequestBody Guest guest){
        return this.guestService.save(guest);
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable int id){
        this.guestService.deleteById(id);
    }
}
