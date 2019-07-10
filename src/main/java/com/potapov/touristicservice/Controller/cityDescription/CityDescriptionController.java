package com.potapov.touristicservice.Controller.cityDescription;

import com.potapov.touristicservice.domain.cityDescription.CityDescription;
import com.potapov.touristicservice.service.cityDescription.CityDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cityDescription")
public class CityDescriptionController {

    @Autowired
    CityDescriptionService cityDescriptionService;

    @GetMapping("/")
    public List<CityDescription> findAll(){
        return cityDescriptionService.findAll();
    }

    @GetMapping("/{id}")
    public CityDescription findById(@PathVariable long id){
        return cityDescriptionService.findById(id);
    }

    @PostMapping("/")
    public boolean save(@RequestBody CityDescription cityDescription){
        return cityDescriptionService.save(cityDescription);
    }

    @PutMapping("/{id}")
    public CityDescription update(@PathVariable long id, @RequestBody CityDescription cityDescription){
        return cityDescriptionService.update(id, cityDescription);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id){
        return cityDescriptionService.delete(id);
    }

}
