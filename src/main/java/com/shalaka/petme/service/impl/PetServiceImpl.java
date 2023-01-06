package com.shalaka.petme.service.impl;

import com.shalaka.petme.dto.Pet;
import com.shalaka.petme.entites.PetInfo;
import com.shalaka.petme.repository.PetRepository;
import com.shalaka.petme.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Override
    public Pet addNewPet(Pet pet) {
        // Converting Bean Object to Data Object
        PetInfo petInfo = new PetInfo();
        petInfo.setPetId(pet.getPetId());
        petInfo.setPetType(pet.getPetType());
        petInfo.setPetName(pet.getPetName());
        petInfo.setPetPrice(pet.getPetPrice());

        //Save Data Object
        PetInfo newPet = petRepository.save(petInfo);

        // Converting Data Object to Bean Object
        pet.setPetId(newPet.getPetId());
        pet.setPetType(newPet.getPetType());
        pet.setPetName(newPet.getPetName());
        pet.setPetPrice(newPet.getPetPrice());

        return pet;
    }

    @Override
    public List<Pet> getAllPets() {

        // Find All
        List<PetInfo> petInfoList = petRepository.findAll();

        // Converting Data Object to Bean Object
        List<Pet> petList = new ArrayList<>();
        for (PetInfo petInfo :petInfoList) {
            Pet pet = new Pet();
            pet.setPetId(petInfo.getPetId());
            pet.setPetType(petInfo.getPetType());
            pet.setPetName(petInfo.getPetName());
            pet.setPetPrice(petInfo.getPetPrice());
            petList.add(pet);
        }

        // Return Bean Object
        return petList;
    }

    @Override
    public Pet getPetById(Long petId) {
        Optional<PetInfo> optionalPet = petRepository.findById(petId);

        Pet pet= new Pet();
        if(optionalPet.isPresent()){
            PetInfo petInfo =  optionalPet.get();
            pet.setPetId(petInfo.getPetId());
            pet.setPetType(petInfo.getPetType());
            pet.setPetName(petInfo.getPetName());
            pet.setPetPrice(petInfo.getPetPrice());
        }
        return pet;
    }

    @Override
    public Pet getPetByType(String type) {
        Optional<PetInfo> optionalPet = petRepository.findByPetType(type);
        Pet pet= new Pet();
        if(optionalPet.isPresent()){
            PetInfo petInfo =  optionalPet.get();
            pet.setPetId(petInfo.getPetId());
            pet.setPetType(petInfo.getPetType());
            pet.setPetName(petInfo.getPetName());
            pet.setPetPrice(petInfo.getPetPrice());
        }
        return pet;
    }

    @Override
    public void deletePetById(Long petId) {
        petRepository.deleteById(petId);
    }

    @Override
    public Pet updatePet(Long petId, Pet pet) {
        Pet dbPet = getPetById(petId);
        if(null != dbPet){
            dbPet.setPetType(pet.getPetType());
            dbPet.setPetName(pet.getPetName());
            dbPet.setPetPrice(pet.getPetPrice());

            // Converting Bean Object to Data Object
            PetInfo petInfo = new PetInfo();
            petInfo.setPetId(dbPet.getPetId());
            petInfo.setPetType(dbPet.getPetType());
            petInfo.setPetName(dbPet.getPetName());
            petInfo.setPetPrice(dbPet.getPetPrice());

            //Save Data Object
            PetInfo newPet = petRepository.save(petInfo);

            // Converting Data Object to Bean Object
            pet.setPetId(newPet.getPetId());
            pet.setPetType(newPet.getPetType());
            pet.setPetName(newPet.getPetName());
            pet.setPetPrice(newPet.getPetPrice());
        }


        return pet;
    }
}
