package com.shalaka.petme.repository;

import com.shalaka.petme.entites.PetInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetInfo,Long> {

    Optional<PetInfo> findByPetType(String type);
}
