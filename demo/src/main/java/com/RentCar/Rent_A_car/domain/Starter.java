package com.RentCar.Rent_A_car.domain;

import com.RentCar.Rent_A_car.domain.Repository.CarsRepository;
import com.RentCar.Rent_A_car.domain.Repository.ErrandRepository;
import com.RentCar.Rent_A_car.domain.Services.ErrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    ErrandRepository errandRepository;

    @Autowired
    ErrandService errandService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        errandRepository.createErrand("Errand in Wrocław");
        errandRepository.createErrand("Errand in Warszawa");

        carsRepository.AddCar("BMW","DW12345",10000);
        carsRepository.AddCar("AUDI","DW23456",23000);
        carsRepository.AddCar("OPEL","DW34567",40000);


    }
}
