package com.usa.ciclo3.proyectoFrank.service;

import com.usa.ciclo3.proyectoFrank.model.ReservationModel;
import com.usa.ciclo3.proyectoFrank.model.custom.CountClient;
import com.usa.ciclo3.proyectoFrank.model.custom.StatusAmount;
import com.usa.ciclo3.proyectoFrank.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    // Consultar todos
    public List<ReservationModel> getAll() {
        return reservationRepository.getAll();
    }
    
    // Consultar uno
    public Optional<ReservationModel> getReservation(int id) {
        return reservationRepository.getById(id);
    }
    
    // Guardar
    public ReservationModel save(ReservationModel reservation) {
        return reservationRepository.save(reservation);
    
    }
    
    // Actualizar
    public ReservationModel update(ReservationModel reservation) {
        if(reservation.getIdReservation() != null){
            Optional<ReservationModel> reservationEncontrado = reservationRepository.getById(reservation.getIdReservation());
            if(reservationEncontrado.isPresent()){
                if (reservation.getStartDate()!=null){
                    reservationEncontrado.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null){
                    reservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!=null){
                    reservationEncontrado.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(reservationEncontrado.get());
                return reservationEncontrado.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
    
    // Eliminar
    public boolean delete(int id) {
        boolean flag = false;
        Optional<ReservationModel> e = reservationRepository.getById(id);
        if(e.isPresent()) {
            reservationRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
    
    // ***** R5 inicio *****
    
    // Listar clientes con mayores reservaciones
    public List<CountClient> getTopClients() {
        return reservationRepository.getTopClients();
    }
    
    // Listar las reservaciones canceladas y las completadas
    public StatusAmount getStatusReport() {
        List<ReservationModel> completed = reservationRepository.getReservationsByStatus("completed");
        List<ReservationModel> cancelled = reservationRepository.getReservationsByStatus("cancelled");
        StatusAmount statAmt = new StatusAmount(completed.size(), cancelled.size());
        return statAmt;
    }
    
    // Listar reservaciones entre un periodo de fechas
    public List<ReservationModel> getReservationPeriod(String d1, String d2) {
        // Formatear fecha
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(d1);
            dateTwo = parser.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)) {
            System.out.println("Ingresó al if");
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }
    }
    
    // ***** R5 fin *****
    
}