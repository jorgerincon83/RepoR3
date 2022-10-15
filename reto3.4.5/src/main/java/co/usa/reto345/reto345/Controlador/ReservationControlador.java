package co.usa.reto345.reto345.Controlador;


import co.usa.reto345.reto345.modelo.Reservation;
import co.usa.reto345.reto345.service.ReservationServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
public class ReservationControlador {

    @Autowired
    private ReservationServicio reservationService;

    public ReservationControlador() {
    }

    @GetMapping("/all")
    public List<Reservation> getAll() {
        return this.reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getAdmin(@PathVariable("id") int id) {
        return this.reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return this.reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return this.reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        this.reservationService.deleteReservation(id);
    }

}
