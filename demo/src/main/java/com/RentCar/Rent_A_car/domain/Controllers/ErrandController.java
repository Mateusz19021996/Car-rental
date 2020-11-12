package com.RentCar.Rent_A_car.domain.Controllers;

import com.RentCar.Rent_A_car.domain.Car;
import com.RentCar.Rent_A_car.domain.Errand;
import com.RentCar.Rent_A_car.domain.Services.CarService;
import com.RentCar.Rent_A_car.domain.Services.ErrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ErrandController {

    @Autowired
    CarService carService;

    @Autowired
    ErrandService errandService;

    @RequestMapping("/assignErrand")
    public String assignErrand(@RequestParam("plate") String plate, Model model){
        Car car = carService.getCar(plate);
        List<Errand> errandList = errandService.getAllCurrentErrands();
        model.addAttribute("car",car);
        model.addAttribute("errands",errandList);;
        return "assignErrand";
    }

    @RequestMapping(value = "/assignErrand", method = RequestMethod.POST)
    public String assignErrand(Car car){
        carService.updateCar(car);
        System.out.println("assignquest");
        System.out.println(car);
        return "redirect:/cars";
    }
}
