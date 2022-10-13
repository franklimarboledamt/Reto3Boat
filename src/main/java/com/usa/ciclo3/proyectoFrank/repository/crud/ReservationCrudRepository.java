package com.usa.ciclo3.proyectoFrank.repository.crud;

import com.usa.ciclo3.proyectoFrank.model.ReservationModel;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
    // ***** R5 inicio *****
    
    // Top de clientes que más dinero han dejado a la compañia
    @Query("SELECT r.client, COUNT(r.client) FROM ReservationModel AS r GROUP BY r.client ORDER BY COUNT(r.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
    // Reservaciones entre dos fechas
    public List<ReservationModel> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // Resevaciones canceladas y completadas (Atributo 'status')
    public List<ReservationModel> findAllByStatus(String status);
    
    // ***** R5 fin *****
}
