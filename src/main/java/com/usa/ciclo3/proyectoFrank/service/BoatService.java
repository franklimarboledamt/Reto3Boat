package com.usa.ciclo3.proyectoFrank.service;

import com.usa.ciclo3.proyectoFrank.model.BoatModel;
import com.usa.ciclo3.proyectoFrank.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;
    
    // Consultar todos
    public List<BoatModel> getAll() {
        return boatRepository.getAll();
    }
    
    // Consultar uno
    public Optional<BoatModel> getBoat(Integer id) {
        return boatRepository.getBoatModel(id);
    }
    
     // Guardar
    public BoatModel save(BoatModel boat) {
        return boatRepository.save(boat);
    }
    
     // Actualizar
    public BoatModel update(BoatModel boat) {
        if(boat.getId() != null){
            Optional<BoatModel> boatEncontrado = boatRepository.getBoatModel(boat.getId());
            if(boatEncontrado.isPresent()){
                if(boat.getBrand() != null){
                    boatEncontrado.get().setBrand(boat.getBrand());
                }
                if(boat.getName() != null ){
                    boatEncontrado.get().setName(boat.getName());
                }
                if(boat.getYear() != null ){
                    boatEncontrado.get().setYear(boat.getYear());
                }
                if(boat.getDescription() != null ){
                    boatEncontrado.get().setDescription(boat.getDescription());
                }
                if(boat.getCategory() != null) {
                    boatEncontrado.get().setCategory(boat.getCategory());
                }
                boatRepository.save(boatEncontrado.get());
                return boatEncontrado.get();
            } else {
                return boat;
            }
        } else {
            return boat;
        }
    }
    
    // Eliminar
    public boolean delete(int id) {
        boolean flag = false;
        Optional<BoatModel> e = boatRepository.getBoatModel(id);
        if(e.isPresent()) {
            boatRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
    
}
