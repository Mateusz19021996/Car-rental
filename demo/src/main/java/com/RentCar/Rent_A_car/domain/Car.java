package com.RentCar.Rent_A_car.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Car {

    @Id
    private String plate;
    private String mark;
    private int mileage;

    @OneToOne(cascade = CascadeType.ALL)
    private Errand errand;


    public Car() { }

    public Car(String mark, String plate, int mileage) {
        this.mark = mark;
        this.plate = plate;
        this.mileage = mileage;

    }


    public void setErrand(Errand errand) {
        this.errand = errand;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Errand getErrand() {
        return errand;
    }

    /*
        To jest sposób na wstryzkiwanie przez metodę


         */
    //    public Car(String mark, String plate, int mileage) {
//        this.mark = mark;
//        this.plate = plate;
//        this.mileage = mileage;
//    }
//
    @Override
    public String toString() {
        // dodać czy jest uszkodzone, stoi na parkingu, jest u mechanika
        if(errand == null){
            return "Car " + mark + ". Plate number: " + plate + ". Milage: " + mileage +
                    ". Errand of car : Car have no errand";
        } else {
            return "Car " + mark + ". Plate number: " + plate + ". Milage: " + mileage +
                    ". Current errand: " + errand;
        }
    }
}
