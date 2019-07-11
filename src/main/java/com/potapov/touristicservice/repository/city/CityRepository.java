package com.potapov.touristicservice.repository.city;

import com.potapov.touristicservice.domain.city.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {

    City findById(long id);

    City findByName(String name);

}
