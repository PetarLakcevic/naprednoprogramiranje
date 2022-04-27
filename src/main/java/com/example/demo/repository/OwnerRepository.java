package com.example.demo.repository;

import com.example.demo.domain.Car;
import com.example.demo.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {

}
