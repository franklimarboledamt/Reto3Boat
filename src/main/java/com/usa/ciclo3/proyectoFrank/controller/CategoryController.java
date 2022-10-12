package com.usa.ciclo3.proyectoFrank.controller;

import com.usa.ciclo3.proyectoFrank.model.CategoryModel;
import com.usa.ciclo3.proyectoFrank.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
    // Consultar todo
    @GetMapping("/all")
    public List<CategoryModel> getAll(){
        return categoryService.getAll();
    }
    
    // Consultar uno
    @GetMapping("/{id}")
    public Optional<CategoryModel> getCategory(@PathVariable("id") Integer id){ //
        return categoryService.getCategory(id);
    }
    
    // Guardar
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel save(@RequestBody CategoryModel category){
        return categoryService.save(category);
    }
    
    // Actualizar
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryModel update(@RequestBody CategoryModel c){
        return categoryService.update(c);     
    }
    
    // Eliminar
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete(id);
    }
}

