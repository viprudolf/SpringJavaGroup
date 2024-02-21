package com.example.Group.Models.Repositories;

import com.example.Group.Interfaces.GroupRepository;
import com.example.Group.Interfaces.SpecialityRepository;
import com.example.Group.Models.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcSpecialityRepository implements SpecialityRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcSpecialityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Speciality> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM \"Speciality\"",
                this::mapRowToSpeciality);
    }

    @Override
    public Optional<Speciality> findById(Integer id) {

        List<Speciality> results = jdbcTemplate.query(
                "SELECT * FROM \"Speciality\" WHERE id = 1\n",
                this::mapRowToSpeciality, id);

        return results.isEmpty() ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public Speciality save(Speciality speciality) {
        jdbcTemplate.update(
                "INSERT INTO \"Speciality\" (\"_nameSpeciality\", \"_profile\") VALUES (?, ?)",
                speciality.GetNameSpeciality(),
                speciality.GetProfile()
        );
        return speciality;
    }

    private Speciality mapRowToSpeciality(ResultSet row, int rowNum) throws SQLException {
        return new Speciality(
                row.getInt("id"),
                row.getDate("createdAt"),
                row.getString("_nameSpeciality"),
                row.getString("_profile"));
    }
}
