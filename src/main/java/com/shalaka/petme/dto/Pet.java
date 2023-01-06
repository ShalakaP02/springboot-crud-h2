package com.shalaka.petme.dto;

public class Pet {

    private int petId;
    private String petType;
    private String petName;
    private Long petPrice;

    public Pet(){

    }

    public Pet(int petId, String petType, String petName, Long petPrice) {
        this.petId = petId;
        this.petType = petType;
        this.petName = petName;
        this.petPrice = petPrice;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Long getPetPrice() {
        return petPrice;
    }

    public void setPetPrice(Long petPrice) {
        this.petPrice = petPrice;
    }
}
