package com.RentCar.Rent_A_car.domain.Repository;

import com.RentCar.Rent_A_car.domain.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CarsRepository {

    Map<String, Car> CarList = new HashMap<>();

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void AddCar(String mark, String plate, int mileage) {
        Car newCar = new Car(mark, plate, mileage);
        em.persist(newCar);

    }

    @Transactional
    public void AddCar(Car car) {
        em.persist(car);

    }

    @Transactional
    public void DellateCar(String plate) {
        Car c = em.find(Car.class, plate);
        em.remove(c);
    }

    public Car getCar(String plate) {

        Car car = em.createQuery("from Car c where c.plate=:plate", Car.class)
                .setParameter("plate", plate).getSingleResult();
        return car;
    }

    public Collection<Car> getAllCars() {
        return em.createQuery("from Car", Car.class).getResultList();

    }

    @Transactional
    public void updateCar(String plate, Car car) {
        em.merge(car);

    }

    @Override
    public String toString() {

        return "cars repository";
    }


}
