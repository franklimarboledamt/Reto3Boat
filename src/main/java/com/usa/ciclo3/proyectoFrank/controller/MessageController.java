package com.usa.ciclo3.proyectoFrank.controller;

import com.usa.ciclo3.proyectoFrank.model.MessageModel;
import com.usa.ciclo3.proyectoFrank.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;
    
    // Consultar todos
    @GetMapping("/all")
    @Column(name ="email", nullable = false, length = 250)
    public List<MessageModel> getAllMessage(){
        return messageService.getAllMessage();
    }
    
    // Consultar uno
    @GetMapping("/{id}")
    public Optional<MessageModel> getMessage(@PathVariable("id") int id){
        return messageService.getMessage(id);
    }
    
    // Guardar
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel save(@RequestBody MessageModel messageModel){
        return messageService.save(messageModel);
    }
    
    // Actualizar
    @PutMapping("/update")
    public MessageModel update(@RequestBody MessageModel messageModel){
        return messageService.update(messageModel);
    }
    
    // Eliminar
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id){
        return messageService.delete(id);
    }

}
