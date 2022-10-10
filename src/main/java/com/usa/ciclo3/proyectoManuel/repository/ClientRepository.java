package com.usa.ciclo3.proyectoManuel.repository;

import com.usa.ciclo3.proyectoManuel.model.ClientModel;
import com.usa.ciclo3.proyectoManuel.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClient() {
        return (List<ClientModel>) clientCrudRepository.findAll();
    }

    public Optional<ClientModel> getClient(Integer id) {
        return clientCrudRepository.findById(id);
    }

    public ClientModel saveClient(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }
    public void delete(ClientModel clientModel){
        clientCrudRepository.delete(clientModel);
    }

    public ClientModel update(ClientModel clientModel){
        return clientCrudRepository.save(clientModel);
    }
}
