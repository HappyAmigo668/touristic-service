package com.potapov.touristicservice.Controller.city;

import com.potapov.touristicservice.domain.city.City;
import com.potapov.touristicservice.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cityDescription")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("/")
    public List<City> findAll(){
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable long id){
        return cityService.findById(id);
    }

    @GetMapping("/{name}")
    public City findByName(@PathVariable String name){return cityService.findByName(name); }

    @PostMapping("/")
    public boolean save(@RequestBody City city){
        return cityService.save(city);
    }

    @PutMapping("/{id}")
    public City update(@PathVariable long id, @RequestBody City city){
        return cityService.update(id, city);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id){
        return cityService.delete(id);
    }

}
