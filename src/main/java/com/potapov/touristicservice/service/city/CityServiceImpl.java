package com.potapov.touristicservice.service.city;

import com.potapov.touristicservice.domain.city.City;
import com.potapov.touristicservice.repository.city.CityRepository;

import java.util.List;

public class CityServiceImpl implements CityService {

    CityRepository cityRepository;


    @Override
    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public City findById(long id) {
        if(id >= 0) {
            City city = cityRepository.findById(id);

            if (city != null) {
                return city;

            } else {
                throw new RuntimeException("City with id: " + id + " is not found.");
            }

        } else {
            throw new RuntimeException("Id is not valid.");
        }
    }

    @Override
    public City findByName(String name){
        return cityRepository.findByName(name);
    }

    @Override
    public boolean save(City city) {
        City cityDescriptionInstance = cityRepository.findByName(city.getCityName());
        if(cityDescriptionInstance == null) {
            cityRepository.save(city);
            return true;
        } else {
            throw new RuntimeException("This city is already exist.");
        }
    }

    @Override
    public City update(long id, City city) {
        City cityInstance = findById(id);
        cityInstance.setCityName(city.getCityName());
        cityInstance.setId(city.getId());
        return cityRepository.save(cityInstance);
    }

    @Override
    public boolean delete(long id) {
        City cityInstance = findById(id);
        cityRepository.delete(cityInstance);
        return true;
    }
}
