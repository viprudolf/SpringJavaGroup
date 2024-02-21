package com.example.Group.Interfaces;

import com.example.Group.Models.FormEducation;
import com.example.Group.Models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface FormEducationRepository extends Repository<FormEducation, Integer> {
    Iterable<FormEducation> findAll();
    Optional<FormEducation> findById(Integer id);
    FormEducation save(FormEducation ingredient);
}
