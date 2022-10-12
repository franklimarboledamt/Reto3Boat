package com.usa.ciclo3.proyectoFrank.repository;

import com.usa.ciclo3.proyectoFrank.model.ScoreModel;
import com.usa.ciclo3.proyectoFrank.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<ScoreModel> getAllScore(){
        return(List<ScoreModel>) scoreCrudRepository.findAll();
    }

    public Optional<ScoreModel> getScore(int idScoreModel){
        return scoreCrudRepository.findById(idScoreModel);
    }

    public ScoreModel save(ScoreModel score){
        return scoreCrudRepository.save(score);
    }
    public void delete(ScoreModel score){
        scoreCrudRepository.delete(score);
    }
}
