package com.RentCar.Rent_A_car.domain.Repository;

import com.RentCar.Rent_A_car.domain.Errand;
import com.RentCar.Rent_A_car.domain.Services.ErrandService;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ErrandRepository {

    @PersistenceContext
    private EntityManager ee;

    List<Errand> ErrandList = new ArrayList<>();

    @Transactional
    public void createErrand(String description) {
        Errand newErrand = new Errand(description);
        ee.persist(newErrand);
        System.out.println(newErrand);

    }

    public void createErrand(Errand errand){ErrandList.add(errand); }

    public List<Errand> getAll () {
       return ee.createQuery("from Errand", Errand.class).getResultList();
    }

    public void delateErrand(Errand errand) {
        ee.remove(errand);
    }

    @Transactional
    public void delateErrand(int x) {
        ErrandList.remove(x);
    }

    public Errand getErrandId(Integer x){
        return ee.find(Errand.class, x );
    }

    @Override
    public String toString() {
        return "ErrandRepository{" +
                "ErrandList=" + ErrandList +
                '}';
    }
}
