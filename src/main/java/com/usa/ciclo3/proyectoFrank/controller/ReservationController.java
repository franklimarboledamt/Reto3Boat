package com.usa.ciclo3.proyectoFrank.controller;

import com.usa.ciclo3.proyectoFrank.model.ReservationModel;
import com.usa.ciclo3.proyectoFrank.model.custom.CountClient;
import com.usa.ciclo3.proyectoFrank.model.custom.StatusAmount;
import com.usa.ciclo3.proyectoFrank.service.ReservationService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<ReservationModel> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> getReservation(@PathVariable("id") Integer id){
        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel save(@RequestBody ReservationModel reservationModel){
        return reservationService.save(reservationModel);
    }

    // Actualizar
    @PutMapping("/update")
    public ReservationModel update(@RequestBody ReservationModel reservationModel){
        return reservationService.update(reservationModel);
    }
    
    // Eliminar
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }
    
    // ***** R5 inicio *****
    
    // Reservation/report-status
    @GetMapping("/report-status")
    public StatusAmount getReservationStatus() {
        return reservationService.getStatusReport();
    }
    
    // Reservation/report-clients
    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return reservationService.getTopClients();
    }
    
    // Reservation/report-dates/date1/date2
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<ReservationModel> getDatesReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2) {
        return reservationService.getReservationPeriod(d1, d2);
    }
    
    // ***** R5 fin *****
}


