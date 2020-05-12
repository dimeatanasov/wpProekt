package project.hotels.controller.restController;

import org.springframework.web.bind.annotation.*;
import project.hotels.model.Reservation;
import project.hotels.service.ReservationService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reservations")
public class ReservationsRestController {
    private final ReservationService reservationService;


    public ReservationsRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> findAll(){
            return this.reservationService.findAllReservations();
    }

    @GetMapping("/findByName")
    public List<Reservation> findByName(@RequestParam int reservationId){
        return this.reservationService.searchReservation(reservationId);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> findById(@PathVariable int id){
        return this.reservationService.findById(id);
    }

    @PostMapping
    public Reservation save(@Valid @RequestBody Reservation reservation){
        return this.reservationService.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id){
        this.reservationService.deleteById(id);
    }

}
