package com.RentCar.Rent_A_car.domain.Services;

import com.RentCar.Rent_A_car.domain.Car;
import com.RentCar.Rent_A_car.domain.Repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarService {

    @Autowired
    CarsRepository carsRepository;

    public List<Car> getAllCars () {
        List<Car> cars = new ArrayList<>(carsRepository.getAllCars());
        return cars;
    }

    public Car getCar(String plate){
        return carsRepository.getCar(plate);
    }

    public void saveCar(Car car) {
        carsRepository.AddCar(car);
    }
    @Transactional
    public void deleteCar(String plate) {
        carsRepository.DellateCar(plate);
    }

    public void updateCar(Car car) {
        carsRepository.updateCar(car.getPlate(), car);
    }

}
