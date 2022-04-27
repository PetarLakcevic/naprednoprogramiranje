package com.example.demo.controller;

import com.example.demo.domain.Owner;
import com.example.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/")
    public Owner CreateAOwner(@RequestBody Owner owner){
        return ownerService.createAOwner(owner);
    }

    @GetMapping("/")
    public List<Owner> getAllOwners(){
        return ownerService.getAllOwners();
    }

//    @PatchMapping("/{owner}/car/{car}")
//    public Owner bindACar(@PathVariable("owner") int ownerId,
//                          @PathVariable("car") int carId) throws Exception {
//        return ownerService.bindACar(ownerId,carId);
//    }

    @PatchMapping("/{id}")
    public Owner saveCarsToAOwner(@PathVariable("id") int id,
                                  @RequestBody int[] carIds) throws Exception {
        return ownerService.saveCarsToAOwner(id,carIds);
    }


    @DeleteMapping("/{id}")
    public void deleteAOwner(@PathVariable("id") int id){
         ownerService.deleteAOwner(id);
    }

}
