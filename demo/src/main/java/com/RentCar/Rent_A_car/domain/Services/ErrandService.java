package com.RentCar.Rent_A_car.domain.Services;

import com.RentCar.Rent_A_car.domain.Car;
import com.RentCar.Rent_A_car.domain.Errand;
import com.RentCar.Rent_A_car.domain.Repository.CarsRepository;
import com.RentCar.Rent_A_car.domain.Repository.ErrandRepository;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrandService {

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    ErrandRepository errandRepository;

    public void assignErrand(String plate, int IdOfErrand){
        List<Errand> allErands = errandRepository.getAll();
        Errand errand = allErands.get(IdOfErrand);
        carsRepository.getCar(plate).setErrand(errand);
        errandRepository.delateErrand(IdOfErrand);
    }


    public List<Errand> getAllCurrentErrands(){
        List<Errand> CurrentErrands = errandRepository.getAll();
        return CurrentErrands;
    }

    public void delateErrand(Errand errand){
        errandRepository.delateErrand(errand);
    }

    public void addErrand(Errand errand){
        errandRepository.createErrand(errand);

    }

}

