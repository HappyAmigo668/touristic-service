package com.potapov.touristicservice.service.cityDescription;

import com.potapov.touristicservice.domain.cityDescription.CityDescription;
import com.potapov.touristicservice.repository.cityDescription.CityDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityDescriptionServiceImpl implements CityDescriptionService{

    @Autowired
    CityDescriptionRepository cityDescriptionRepository;

    @Override
    public List<CityDescription> findAll() {
        return (List<CityDescription>) cityDescriptionRepository.findAll();
    }

    @Override
    public List<CityDescription> findAllByDescription(String description) {
        return cityDescriptionRepository.findAllByDescription(description);
    }

    @Override
    public CityDescription findById(long id) {
        if(id >= 0) {
            CityDescription cityDescription = cityDescriptionRepository.findById(id);

            if (cityDescription != null) {
                return cityDescription;

            } else {
                throw new RuntimeException("City description with id: " + id + " is not found.");
            }

        } else {
            throw new RuntimeException("Id is not valid.");
        }
    }

    @Override
    public boolean save(CityDescription cityDescription) {
        CityDescription cityDescriptionInstance = cityDescriptionRepository.findByCityName(cityDescription.getCityName());
        if(cityDescriptionInstance == null) {
            cityDescriptionRepository.save(cityDescription);
            return true;
        } else {
            throw new RuntimeException("City with such description is already exist.");
        }
    }

    @Override
    public CityDescription update(long id, CityDescription cityDescription) {
        CityDescription cityDescriptionInstance = findById(id);
        cityDescriptionInstance.setCityName(cityDescription.getCityName());
        cityDescriptionInstance.setDescription(cityDescription.getDescription());
        return cityDescriptionRepository.save(cityDescriptionInstance);
    }

    @Override
    public boolean delete(long id) {
        CityDescription cityDescriptionInstance = findById(id);
        cityDescriptionRepository.delete(cityDescriptionInstance);
        return true;
    }
}
