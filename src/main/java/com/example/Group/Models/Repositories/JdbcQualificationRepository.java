package com.example.Group.Models.Repositories;

import com.example.Group.Interfaces.FormEducationRepository;
import com.example.Group.Interfaces.GroupRepository;
import com.example.Group.Interfaces.QualificationRepository;
import com.example.Group.Models.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcQualificationRepository implements QualificationRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcQualificationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Qualification> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM \"Qualification\"",
                this::mapRowToQualification);
    }

    @Override
    public Optional<Qualification> findById(Integer id) {

        List<Qualification> results = jdbcTemplate.query(
                "SELECT * FROM \"Qualification\" WHERE id = 1\n",
                this::mapRowToQualification, id);

        return results.isEmpty() ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Qualification save(Qualification group) {
        jdbcTemplate.update(
                "INSERT INTO \"Qualification\" (\"_nameQualification\") VALUES (?)",
                group.GetNameQualification()
        );
        return group;
    }

    private Qualification mapRowToQualification(ResultSet row, int rowNum) throws SQLException {
        return new Qualification(
                row.getInt("id"),
                row.getDate("createdAt"),
                row.getString("_nameQualification"));
    }
}

