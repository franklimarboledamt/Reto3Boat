package com.usa.ciclo3.proyectoFrank.service;

import com.usa.ciclo3.proyectoFrank.model.ClientModel;
import com.usa.ciclo3.proyectoFrank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    // Consultar todos
    public List<ClientModel> getAllClient() {
        return clientRepository.getAllClient();
    }
    
    // Consultar uno
    public Optional<ClientModel> getClient(Integer id) {
        return clientRepository.getClient(id);
    }
    
    // Guardar
    public ClientModel saveClient(ClientModel clientModel) {
        if (clientModel.getIdClient() == null) {
             return clientRepository.saveClient(clientModel);
        } else {
            Optional<ClientModel> clientEncontrado = getClient(clientModel.getIdClient());
            if (clientEncontrado.isEmpty()) {
                return clientRepository.saveClient(clientModel);
            } else {
                return clientModel;
            }
        }
    }
    
    // Actualizar
    public ClientModel update(ClientModel clientModel){
        if(clientModel.getIdClient() != null){
            Optional<ClientModel> clientEncontrado = getClient(clientModel.getIdClient());
            if (clientEncontrado.isPresent()) {
                if(clientModel.getEmail() != null) {
                    clientEncontrado.get().setEmail(clientModel.getEmail());
                }
                if(clientModel.getName()!=null){
                    clientEncontrado.get().setName(clientModel.getName());
                }
                if(clientModel.getAge()!=null){
                    clientEncontrado.get().setAge(clientModel.getAge());
                }
                if(clientModel.getPassword()!=null){
                    clientEncontrado.get().setPassword(clientModel.getPassword());
                } // Pendiente si se debe verificar 'messages' y 'reservations'
                clientRepository.saveClient(clientEncontrado.get());
                return clientEncontrado.get();
            } else {
                return clientModel;
            }
        } else {
            return clientModel;
        }
    }
    
    // Eliminar
    public boolean delete(int id) {
        boolean flag = false;
        Optional<ClientModel> e = clientRepository.getClient(id);
        if(e.isPresent()) {
            clientRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }

}