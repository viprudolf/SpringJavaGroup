package com.example.Group.Interfaces;

import com.example.Group.Models.FormEducation;
import com.example.Group.Models.Qualification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface QualificationRepository extends Repository<Qualification, Integer> {
    Iterable<Qualification> findAll();
    Optional<Qualification> findById(Integer id);
    Qualification save(Qualification ingredient);
}
