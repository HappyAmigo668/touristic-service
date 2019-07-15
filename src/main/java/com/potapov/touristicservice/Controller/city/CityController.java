package com.potapov.touristicservice.Controller.city;

import com.potapov.touristicservice.domain.city.City;
import com.potapov.touristicservice.service.city.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    CityService cityService;

    private static Logger log = LoggerFactory.getLogger(CityController.class);

    @GetMapping("/")
    public List<City> findAll() {
        log.info("City controller: findAll()");

        try {
            return cityService.findAll();

        } catch (ResponseStatusException e) {
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable long id) {
        log.info("City controller: findById [" + id + "]");

        try {
            return cityService.findById(id);

        } catch (ResponseStatusException e) {
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/findByName/{name}")
    public City findByName(@PathVariable String name) {
        log.info("City controller: findByName [" + name + "]");

        try {
            return cityService.findByName(name);

        } catch (ResponseStatusException e) {
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    @GetMapping("/findAllNames/")
    public List<String> findAllNames() {
        log.info("City controller: findAllByNames");

        try {
            List<City> cities = findAll();
            List<String> cityNames = new ArrayList<>();

            for (City city : cities) {
                cityNames.add(city.getName());
            }
            return cityNames;

        } catch (ResponseStatusException e) {
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PostMapping("/")
    public boolean save(@RequestBody City city) {
        log.info("City controller: save [" + city + "]");

        try {
            return cityService.save(city);

        } catch (ResponseStatusException e) {
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public City update(@PathVariable long id, @RequestBody City city) {
        log.info("City controller: update [" + id + ", " + city + "]");

        try {
            return cityService.update(id, city);

        } catch (ResponseStatusException e) {
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        log.info("City controller: delete [" + id + "]");

        try {
            return cityService.delete(id);

        } catch (ResponseStatusException e) {
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
