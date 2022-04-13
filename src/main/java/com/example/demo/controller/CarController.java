package com.example.demo.controller;

import com.example.demo.domain.Car;
import com.example.demo.dto.DTOFilter;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;


    @PostMapping("/api/car/search")
    public List<Car> getCarsFiltered(@RequestBody DTOFilter  dtoFilter){
        return carService.getCarsFiltered(dtoFilter);
    }

    @GetMapping("/api/car/search/{year}")
    public List<Car> getCarsNewerThan(@PathVariable("year") int year){
        return carService.getCarsNewerThan(year);
    }

    @GetMapping("/api/car/exact/{year}")
    public List<Car> getCarsFromYear(@PathVariable("year") int year){
        return carService.getCarsFromYear(year);
    }


    @PostMapping("/api/car")
    public Car createACar(@RequestBody Car newCar){
        return carService.createACar(newCar);
    }

    @GetMapping("/api/car")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/api/car/{id}")
    public Car getCarById(@PathVariable("id") int id) throws Exception{
        return carService.getCarById(id);
    }

    @DeleteMapping("/api/car/{id}")
    public void deleteCarById(@PathVariable("id") int id){
        carService.deleteCarById(id);
    }

    @PutMapping("/api/car/{id}")
    public Car updateCarById(@PathVariable("id") int id,
                              @RequestBody Car car) throws Exception{
        return carService.updateCarById(id,car);
    }

}
