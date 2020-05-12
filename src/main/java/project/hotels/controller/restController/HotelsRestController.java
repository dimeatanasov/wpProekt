package project.hotels.controller.restController;

import org.springframework.web.bind.annotation.*;
import project.hotels.model.Hotel;
import project.hotels.service.HotelService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins="http://localhost:3000")
public class HotelsRestController {

    private final HotelService hotelService;


    public HotelsRestController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Hotel> findAll(@RequestParam(required = false) String hotelName){
        if(hotelName == null){
            return this.hotelService.findAllHotels();
        }else{
            return this.hotelService.searchHotel(hotelName);
        }
    }

    @GetMapping("/findByName")
    public List<Hotel> findByName(@RequestParam String hotelName){
        return this.hotelService.searchHotel(hotelName);
    }

    @GetMapping("/{id}")
    public Optional<Hotel> findById(@PathVariable int id){
        return this.hotelService.findById(id);
    }

//    @PostMapping
//    public Hotel save(@RequestParam int hotelId,
//                      @RequestParam String hotelName,
//                      @RequestParam String hotelAddresss,
//                      @RequestParam String hotelEmail
//                      ){
//        Hotel hotel = new Hotel();
//        hotel.setHotelId(hotelId);
//        hotel.setHotelName(hotelName);
//        hotel.setHotelAddress(hotelAddresss);
//        hotel.setHotelEmail(hotelEmail);
//        return this.hotelService.save(hotel);
//    }

    @PostMapping
    public Hotel save(@Valid @RequestBody Hotel hotel){
        return this.hotelService.save(hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable int id){
        this.hotelService.deleteById(id);
    }
}
