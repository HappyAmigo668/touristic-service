package com.potapov.touristicservice.repository.cityDescription;

import com.potapov.touristicservice.domain.cityDescription.CityDescription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDescriptionRepository extends CrudRepository<CityDescription, Long> {

    CityDescription findByCityName(String cityName);

    CityDescription findById(long id);

    List<CityDescription> findAllByDescription(String description);

}
