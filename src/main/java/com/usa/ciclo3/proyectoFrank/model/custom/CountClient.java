/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo3.proyectoFrank.model.custom;

import com.usa.ciclo3.proyectoFrank.model.ClientModel;
import com.usa.ciclo3.proyectoFrank.model.ReservationModel;

/**
 *
 * @author frankdev
 */
public class CountClient {
    private Integer total;
    private ClientModel client;

    public CountClient(Integer total, ClientModel client) {
        this.total = total;
        this.client = client;
    }
        
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }    
}
