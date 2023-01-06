package com.shalaka.petme.entites;

import jakarta.persistence.*;

@Entity
@Table(name="pet_info")
public class PetInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    private int petId;

    @Column(name="pet_type")
    private String petType;

    @Column(name="pet_name")
    private String petName;

    @Column(name="pet_price")
    private Long petPrice;


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
