package com.usa.ciclo3.proyectoFrank.controller;


import com.usa.ciclo3.proyectoFrank.model.BoatModel;
import com.usa.ciclo3.proyectoFrank.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping("/all")
    public List<BoatModel> getAll(){
        return boatService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<BoatModel> getBoat(@PathVariable("id") Integer id){ //
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel save(@RequestBody BoatModel boatModel){
        return boatService.save(boatModel);
    }

    // Actualizar
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel update(@RequestBody BoatModel b){
        return boatService.update(b);     
    }
    
    // Eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return boatService.delete(id);
    }
}


