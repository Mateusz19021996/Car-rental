package com.RentCar.Rent_A_car.domain.Controllers;

import com.RentCar.Rent_A_car.domain.Car;
import com.RentCar.Rent_A_car.domain.Repository.CarsRepository;
import com.RentCar.Rent_A_car.domain.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;


    @RequestMapping("/cars")
    public String getCars(Model model) {
        List<Car> CarList = carService.getAllCars();
        model.addAttribute("cars", CarList);
        return "cars";
    }

    @RequestMapping("/newcar")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "newcar";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String saveCar(Car car) {
            carService.saveCar(car);
            return "redirect:/cars";
    }

    @RequestMapping("/car")
    public String getCar(@RequestParam("plate") String plate, Model model) {
        Car car = carService.getCar(plate);
        model.addAttribute("car", car);
        return "car";
    }

    @RequestMapping(value = "/car/delete/{plate}")
    public String deleteCar(@PathVariable("plate") String plate, Model model) {
        carService.deleteCar(plate);
        return "redirect:/cars";
    }
}

