package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.Owner;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;

    public Owner createAOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner bindACar(int ownerId, int carId) throws Exception {
        Owner owner = findOwnerById(ownerId);
        Car car = carService.getCarById(carId);

        car.setOwner(owner);

        carRepository.save(car);
        return owner;
    }


    public Owner findOwnerById(int id) throws Exception {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (!optionalOwner.isPresent()) {
            throw new Exception("Invalid owner id");
        }
        return optionalOwner.get();
    }

    public Owner saveCarsToAOwner(int id, int[] carIds) throws Exception {
        Owner owner = findOwnerById(id);
        List<Car> carList = carService.findCarsByIds(carIds);

        if (carList.size() != carIds.length) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Id mismatch"
            );
        }

        owner.setCarList(carList);
        return ownerRepository.save(owner);

    }

    public void deleteAOwner(int id) {
        ownerRepository.deleteById(id);
    }
}
