package com.usa.ciclo3.proyectoFrank.service;

import com.usa.ciclo3.proyectoFrank.model.MessageModel;
import com.usa.ciclo3.proyectoFrank.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    // Consultar todos
    public List<MessageModel> getAllMessage() {
        return messageRepository.getAllMessage();
    }
    
    // Consultar uno
    public Optional<MessageModel> getMessage(Integer id) {
        return messageRepository.getMessage(id);
    }
    
    // Guardar
    public MessageModel save(MessageModel message) {
        return messageRepository.save(message);
    }
    
    // Actualizar
    public MessageModel update(MessageModel message) {
        if(message.getIdMessage() != null){
            Optional<MessageModel> mesageEncontrado = messageRepository.getMessage(message.getIdMessage());
            if(mesageEncontrado.isPresent()){
                if(message.getMessageText() != null){
                    mesageEncontrado.get(). setMessageText(message.getMessageText());
                }
                messageRepository.save(mesageEncontrado.get());
                return mesageEncontrado.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }
    
    // Eliminar
    public boolean delete(int id) {
        boolean flag = false;
        Optional<MessageModel> e = messageRepository.getMessage(id);
        if(e.isPresent()) {
            messageRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
    
}