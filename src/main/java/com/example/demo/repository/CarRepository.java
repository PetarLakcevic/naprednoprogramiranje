package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> findByYearGreaterThan(int year);
    
    List<Car> findByYear(int year);

    List<Car> findByYearAndManufacturer(int year, String manufacturer);

    List<Car> findByYearAndManufacturerIgnoreCase(int year, String manufacturer);
}
