package com.potapov.touristicservice.Controller.city;

import com.potapov.touristicservice.domain.city.City;
import com.potapov.touristicservice.service.city.CityService;

import java.util.List;

public class CityController {

    CityService cityService;

    public List<City> findAll(){
        return cityService.findAll();
    }

    public City findById(long id){
        return cityService.findById(id);
    }

    public boolean save(City city){
        return cityService.save(city);
    }

    public City update(long id, City city){
        return cityService.update(id, city);
    }

    public boolean delete(long id){
        return cityService.delete(id);
    }
}
