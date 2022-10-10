package com.usa.ciclo3.proyectoManuel.model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdminModel;
    private String email;
    private String name;
    private String password;

    public Integer getIdAdminModel() {
        return idAdminModel;
    }

    public void setIdAdminModel(Integer idAdminModel) {
        this.idAdminModel = idAdminModel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
