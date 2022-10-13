package com.usa.ciclo3.proyectoFrank.repository;

import com.usa.ciclo3.proyectoFrank.model.ClientModel;
import com.usa.ciclo3.proyectoFrank.model.ReservationModel;
import com.usa.ciclo3.proyectoFrank.model.custom.CountClient;
import com.usa.ciclo3.proyectoFrank.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAll(){
        return(List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getById(int id){
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel save(ReservationModel reservation){
        return reservationCrudRepository.save(reservation);
    }
    public void delete(ReservationModel reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    // ***** R5 inicio *****
    
    // Listar reservaciones por 'status' (candelled, completed)
    public List<ReservationModel> getReservationsByStatus(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    // Listar reservaciones entre dos fechas
    public List<ReservationModel> getReservationPeriod(Date dateOne, Date dateTwo) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    // Listdo de clientes con sus reservaciones
    public List<CountClient> getTopClients() {
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i = 0; i <  report.size(); i++) {
            ClientModel cli = (ClientModel) report.get(i)[0];
            Integer cantidad = Integer.parseInt(report.get(i)[1].toString());
            CountClient cc = new CountClient(cantidad, cli);
            res.add(cc);
        }
        return res;
    }
    
    // ***** R5 fin *****    
}