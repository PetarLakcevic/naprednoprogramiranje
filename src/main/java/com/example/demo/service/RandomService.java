package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RandomService {

    public int returnRandomNumberFromRange(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
