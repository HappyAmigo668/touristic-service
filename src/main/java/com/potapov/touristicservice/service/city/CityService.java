package com.potapov.touristicservice.service.city;

import com.potapov.touristicservice.domain.city.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<City> findAll();

    City findById(long id);

    City findByName(String name);

    boolean save(City city);

    City update(long id, City city);

    boolean delete(long id);
}
