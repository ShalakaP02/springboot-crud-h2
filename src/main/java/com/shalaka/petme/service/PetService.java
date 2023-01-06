package com.shalaka.petme.service;

import com.shalaka.petme.dto.Pet;

import java.util.List;

public interface PetService {

     Pet addNewPet(Pet pet);

     List<Pet> getAllPets();

     Pet getPetById(Long petId);

     Pet getPetByType(String type);

     void deletePetById(Long petId);

     Pet updatePet(Long petId, Pet pet);
}
