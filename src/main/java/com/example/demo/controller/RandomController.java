package com.example.demo.controller;

import com.example.demo.service.RandomService;
import com.example.demo.dto.DTOFromTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RandomController {
    @Autowired
    RandomService randomService;
    @GetMapping("/api/random")
    public int returnARandomInt(){
        return randomService.returnRandomNumberFromRange(1, 100);
    }
    @GetMapping("/api/random/{min}/to/{max}")
    public int returnARandomIntFromRange
            (@PathVariable("min") int min,@PathVariable("max") int max){
        return randomService.returnRandomNumberFromRange(min, max);
    }

    @PostMapping("/api/random")
    public int returnARandomIntFromRange2(@RequestBody DTOFromTo dtoFromTo){
        return randomService.returnRandomNumberFromRange
                (dtoFromTo.getMin(),dtoFromTo.getMax());
    }



}
