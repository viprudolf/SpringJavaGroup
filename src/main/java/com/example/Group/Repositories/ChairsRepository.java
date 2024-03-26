package com.example.Group.Repositories;

import com.example.Group.Models.Chairs;

import java.util.Optional;

public interface ChairsRepository {
    Iterable<Chairs> findAll();
    Optional<Chairs> findById(long id);
    Chairs saveChair(Chairs chairs);
    Chairs updateChair(Chairs chairs);
    void deleteChair(long id);
}
