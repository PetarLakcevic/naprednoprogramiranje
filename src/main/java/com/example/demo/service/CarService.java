package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.Owner;
import com.example.demo.domain.dto.DTOCar;
import com.example.demo.dto.DTOFilter;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
//    @Autowired
//    private OwnerService ownerService;

    public Car createACar(Car newCar) {
        return carRepository.save(newCar);
    }

    public List<DTOCar> getAllCars() {
        List<Car> carList = carRepository.findAll();
        List<DTOCar> dtoCarList = new ArrayList<>();

        for (Car car : carList){
            dtoCarList.add(new DTOCar(car.getManufacturer(),
                    car.getModel(),car.getYear()));
        }

        return dtoCarList;

    }

    public Car getCarById(int id) throws Exception {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (!optionalCar.isPresent()) {
            throw new Exception();
        }
        return optionalCar.get();
    }

    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }

    public Car updateCarById(int id, Car car) throws Exception {
        Car oldCar = getCarById(id);

        oldCar.setManufacturer(car.getManufacturer());
        oldCar.setModel(car.getModel());
        oldCar.setYear(car.getYear());

        Car savedCar = carRepository.save(oldCar);
        return savedCar;
    }

    public List<Car> getCarsNewerThan(int year) {
        return carRepository.findByYearGreaterThan(year);

    }

    public List<Car> getCarsFromYear(int year) {
        return carRepository.findByYear(year);
    }

    public List<Car> getCarsFiltered(DTOFilter dtoFilter) {
        return carRepository.findByYearAndManufacturerIgnoreCase
                (dtoFilter.getYear(),dtoFilter.getManufacturer());
    }

//    public Car saveOwnerToACar(int carId, int ownerId) throws Exception {
//        Car car = getCarById(carId);
//        Owner owner = ownerService.findOwnerById(ownerId);
//
//        car.setOwner(owner);
//        return carRepository.save(car);
//    }

    public List<Car> findCarsByIds(int[] ids){
        return carRepository.findByIdIn(ids);
    }
}
