package com.potapov.touristicservice.domain.cityDescription;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CityDescription {

    @Id
    @NotNull
    private long id;

    @NotNull
    @Column(unique = true)
    private String cityName;

    @NotNull
    private String description;

    public CityDescription() {
    }

    public CityDescription(String cityName, String description) {
        this.cityName = cityName;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
