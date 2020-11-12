package com.RentCar.Rent_A_car.domain;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.persistence.Entity;
@Entity
public class Errand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private String description;


    private Errand() {
    }

    public Errand(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        return description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
