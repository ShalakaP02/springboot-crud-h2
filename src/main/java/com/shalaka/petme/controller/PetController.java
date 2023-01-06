package com.shalaka.petme.controller;


import com.shalaka.petme.dto.Pet;
import com.shalaka.petme.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PetController {

    Logger log = LoggerFactory.getLogger(PetController.class);

    @Autowired
    PetService petService;

    @GetMapping("/pets")
    public  ResponseEntity<List<Pet>> getAllPets(){
        log.info("PetController getAllPets executing..");
        List<Pet> petList = petService.getAllPets();
        return new ResponseEntity<>(petList,HttpStatus.OK);

    }

    @GetMapping("/pets/id/{petId}")
    public  ResponseEntity<Pet> getPetById(@PathVariable Long petId){
        log.info("PetController getPetById executing..");
        Pet pet = petService.getPetById(petId);
        return new ResponseEntity<>(pet,HttpStatus.OK);

    }

    @GetMapping("/pets/type/{petType}")
    public  ResponseEntity<Pet> getPetById(@PathVariable String petType){
        log.info("PetController getPetById executing..");
        Pet pet = petService.getPetByType(petType);
        return new ResponseEntity<>(pet,HttpStatus.OK);

    }

    @PostMapping("/pet")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        Pet createdPet = petService.addNewPet(pet);
        return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
    }

    @PutMapping("/pets/{petId}")
    public ResponseEntity<Pet> updateUser(@PathVariable Long petId,
                                           @RequestBody Pet pet){

        Pet updatedPet = petService.updatePet(petId,pet);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }

    @DeleteMapping("/pets/{petId}")
    public ResponseEntity<String> addPet(@PathVariable Long petId) {
        petService.deletePetById(petId);
        return new ResponseEntity<>("Pet Info successfully deleted!", HttpStatus.OK);
    }




//    @GetMapping("/pets")
//    public List<Pet> getAllPets(){
//        log.info("PetController getAllPets executing..");
//        log.debug(" DEBUG PetController getAllPets executing..");
//        return Arrays.asList(new Pet(1, PetType.CAT.toString(),"Lucy", 1000L),
//                new Pet(2, PetType.DOG.toString(),"Mike", 2000L));
//
//    }
}
