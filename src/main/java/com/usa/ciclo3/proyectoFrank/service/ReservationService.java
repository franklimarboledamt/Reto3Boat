package com.usa.ciclo3.proyectoFrank.service;

import com.usa.ciclo3.proyectoFrank.model.ReservationModel;
import com.usa.ciclo3.proyectoFrank.repository.ReservationRepository;
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
    
}