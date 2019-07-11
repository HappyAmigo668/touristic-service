package com.potapov.touristicservice.repository.city;

import com.potapov.touristicservice.domain.city.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    City findById(long id);

    City findByName(String name);

}
