package com.usa.ciclo3.proyectoFrank.repository;

import com.usa.ciclo3.proyectoFrank.model.AdminModel;
import com.usa.ciclo3.proyectoFrank.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    // Consultar todos
    public List<AdminModel> getAllAdmin(){
        return (List<AdminModel>) adminCrudRepository.findAll();
    }
    
    // Consultar uno
    public Optional<AdminModel> getAdminModel(int id){
        return adminCrudRepository.findById(id);
    }
    
    // Guardar
    public AdminModel saveAdmin(AdminModel admin){
        return adminCrudRepository.save(admin);
    }
    
    // Actualizar
    public AdminModel updateAdmin (AdminModel adminModel){
        return adminCrudRepository.save(adminModel);
    }
    
    // Eliminar
    public void delete(AdminModel admin){
        adminCrudRepository.delete(admin);
    }
}
