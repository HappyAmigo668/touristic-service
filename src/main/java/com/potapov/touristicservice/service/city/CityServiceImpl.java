package com.potapov.touristicservice.service.city;

import com.potapov.touristicservice.repository.city.CityRepository;
import com.potapov.touristicservice.domain.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
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
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City with id: " + id + " is not found.");
            }

        } else {
            throw new RuntimeException("Id is not valid.");
        }
    }

    @Override
    public City findByName(String name){
        City city = cityRepository.findByName(name);

        if (city != null) {
            return city;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City: " + name + " is not found.");
        }
    }


    @Override
    public boolean save(City city) {
        City cityInstance = cityRepository.findByName(city.getName());

        if (cityInstance == null) {
            cityRepository.save(city);
            return true;

        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "City with id: " + city.getId() + " is already exist.");
        }
    }

    @Override
    public City update(long id, City city) {
        City cityInstance = findById(id);

        cityInstance.setName(city.getName());
        cityInstance.setDescription(city.getDescription());

        return cityRepository.save(cityInstance);
    }

    @Override
    public boolean delete(long id) {
        City cityInstance = findById(id);

        cityRepository.delete(cityInstance);
        return true;
    }
}
