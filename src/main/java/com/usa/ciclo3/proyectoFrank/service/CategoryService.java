package com.usa.ciclo3.proyectoFrank.service;

import com.usa.ciclo3.proyectoFrank.model.CategoryModel;
import com.usa.ciclo3.proyectoFrank.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    // Consultar todos
    public List<CategoryModel> getAll() {
        return categoryRepository.getAll();
    }
    
    // Consultar uno
    public Optional<CategoryModel> getCategory(Integer id) {
        return categoryRepository.getCategoryModel(id);
    }
    
    // Guardar
    public CategoryModel save(CategoryModel category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<CategoryModel> categoryEncontrado = categoryRepository.getCategoryModel(category.getId());
            if (categoryEncontrado.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
    
    // Actualizar
    public CategoryModel update(CategoryModel category) {
        if(category.getId() != null){
            Optional<CategoryModel> categoryEncontrado = categoryRepository.getCategoryModel(category.getId());
            if(!categoryEncontrado.isEmpty()){
                if(category.getDescription() != null){
                    categoryEncontrado.get().setDescription(category.getDescription());
                }
                if(category.getName() != null ){
                    categoryEncontrado.get().setName(category.getName());
                }
                return categoryRepository.save(categoryEncontrado.get());
            }
        }
        return category;
    }
    
    // Eliminar
    public boolean delete(int id) {
        boolean flag = false;
        Optional<CategoryModel> e = categoryRepository.getCategoryModel(id);
        if(e.isPresent()) {
            categoryRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}

