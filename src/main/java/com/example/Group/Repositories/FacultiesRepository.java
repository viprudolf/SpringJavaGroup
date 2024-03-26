package com.example.Group.Repositories;

import com.example.Group.Models.Faculties;

import java.util.Optional;

public interface FacultiesRepository {
    Iterable<Faculties> findAll();
    Optional<Faculties> findById(long id);
    Faculties saveFaculty(Faculties city);
    Faculties updateFaculty(Faculties city);
    void deleteFaculty(long id);
}
