package com.potapov.touristicservice.service.cityDescription;

import com.potapov.touristicservice.domain.cityDescription.CityDescription;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityDescriptionService {

    List<CityDescription> findAll();

    List<CityDescription> findAllByDescription(String description);

    CityDescription findById(long id);

    boolean save(CityDescription cityDescription);

    CityDescription update(long id, CityDescription cityDescription);

    boolean delete(long id);
}
