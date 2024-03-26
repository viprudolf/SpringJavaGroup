package com.example.Group.Repositories.JDBC;

import com.example.Group.Models.Chairs;
import com.example.Group.Models.Faculties;
import com.example.Group.Repositories.ChairsRepository;
import com.example.Group.Repositories.FacultiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcChairRepository implements ChairsRepository {
    private final JdbcTemplate jdbcTemplate;
    private final FacultiesRepository facultiesRepository;
    @Autowired
    public JdbcChairRepository(JdbcTemplate jdbcTemplate, FacultiesRepository facultiesRepository) {
        this.facultiesRepository = facultiesRepository;
        this.jdbcTemplate = jdbcTemplate;}
    @Override
    public Iterable<Chairs> findAll() {return jdbcTemplate.query("select * from chairs", this::mapRow);}
    @Override
    public Optional<Chairs> findById(long id) {
        List<Chairs> results = jdbcTemplate.query("select * from chairs where id=?", this::mapRow, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }
    private Chairs mapRow(ResultSet row, int rowNum) throws SQLException {
        Faculties select = facultiesRepository.findById(row.getInt("faculty_id")).get();
        return new Chairs(row.getLong("id"), select.getId(), row.getString("name"),
                row.getString("abbr"),row.getString("chief"),
                row.getString("phone"),
                select);
    }
    @Override
    public Chairs saveChair(Chairs chairs) {
        jdbcTemplate.update(
                "insert into chairs (faculty_id, name, abbr, chief, phone) " +
                        "values (?, ?, ?, ?, ?)",
                chairs.getFaculties().getId(),
                chairs.getName(),
                chairs.getAbbr(),
                chairs.getChief(),
                chairs.getPhone());
        return chairs;
    }
    @Override
    public void deleteChair(long id){
        jdbcTemplate.update("delete from chairs where id=?", id);
    }
    @Override
    public Chairs updateChair(Chairs chairs){
        jdbcTemplate.update("update chairs set faculty_id=?,name=?,abbr=?,chief=?,phone=? where id=?",
                chairs.getFaculties().getId(),
                chairs.getName(),
                chairs.getAbbr(),
                chairs.getChief(),
                chairs.getPhone(),
                chairs.getId());
        return chairs;
    }
}
