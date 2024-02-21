package com.example.Group.Interfaces;

import com.example.Group.Models.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface GroupRepository extends Repository<Group, Integer> {
    Iterable<Group> findAll();
    Optional<Group> findById(Integer id);
    Group save(Group ingredient);
}

