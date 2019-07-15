package com.potapov.touristicservice.domain.city;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class City {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    @Column(name = "description",
            length = 6000,
            columnDefinition = "VARCHAR(6000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci")
    private String description;

    public City() {
    }

    public City(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
