package com.usa.ciclo3.proyectoManuel.repository;

import com.usa.ciclo3.proyectoManuel.model.AdminModel;
import com.usa.ciclo3.proyectoManuel.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<AdminModel> getAllAdmin(){
        return (List<AdminModel>) adminCrudRepository.findAll();
    }

    public Optional<AdminModel> getAdminModel(int id){
        return adminCrudRepository.findById(id);
    }

    public AdminModel saveAdmin(AdminModel admin){
        return adminCrudRepository.save(admin);
    }
    public void delete(AdminModel admin){
        adminCrudRepository.delete(admin);
    }

    public AdminModel updateAdmin (AdminModel adminModel){
        return adminCrudRepository.save(adminModel);
    }
}
