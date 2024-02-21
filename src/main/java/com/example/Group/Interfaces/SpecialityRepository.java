package com.example.Group.Interfaces;

import com.example.Group.Models.Qualification;
import com.example.Group.Models.Speciality;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface SpecialityRepository extends Repository<Speciality, Integer> {
    Iterable<Speciality> findAll();
    Optional<Speciality> findById(Integer id);
    Speciality save(Speciality ingredient);
}
