package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue
    public int id;

    public String name;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    public List<Car> carList;

    public Owner() {
    }

    public Owner(int id, String name, List<Car> carList) {
       this.id = id;
        this.name = name;
        this.carList = carList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
