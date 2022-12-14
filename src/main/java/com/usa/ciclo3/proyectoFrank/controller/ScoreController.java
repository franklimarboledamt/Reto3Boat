package com.usa.ciclo3.proyectoFrank.controller;

import com.usa.ciclo3.proyectoFrank.model.ScoreModel;
import com.usa.ciclo3.proyectoFrank.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {

    @Autowired
    private ScoreService scoreService;
    @GetMapping("/all")
    public List<ScoreModel> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ScoreModel> get(@PathVariable Integer id){
        return scoreService.getScore(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ScoreModel save(@RequestBody ScoreModel scoreModel){
        return scoreService.save(scoreModel);
    }

    @PutMapping("/update")
    public ScoreModel update(@RequestBody ScoreModel scoreModel){
        return scoreService.update(scoreModel);
    }
    
    // Eliminar
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return scoreService.delete(id);
    }
}
