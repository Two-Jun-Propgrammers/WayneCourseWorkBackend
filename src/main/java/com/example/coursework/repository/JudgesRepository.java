package com.example.coursework.repository;

import com.example.coursework.model.Judge;
import com.example.coursework.repository.mapper.JudgesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class JudgesRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private JudgesMapper judgesMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM judges.judges";
        List<Judge> judges = template.query(sql, judgesMapper);
        List<UUID> result = new ArrayList<>();
        for (Judge judge : judges) {
            result.add(judge.getId());
        }
        return result;
    }

    public Judge search(UUID id)
    {
        String sql = "SELECT * FROM judges.judges WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, judgesMapper);
    }

    public boolean create(Judge judge) {
        String sql = "INSERT INTO judges.judges (id, firstname, lastname) VALUES (:id, :firstName, :lastName)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("firstName", judge.getFirstName())
                .addValue("lastName", judge.getLastName());
        try {
            template.update(sql, params);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean check(UUID id) {
        return search(id) == null;
    }

    public boolean update(UUID id, Judge judge) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE judges.judges SET firstname = :firstName, lastname = :lastName WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("firstName", judge.getFirstName())
                .addValue("lastName", judge.getLastName())
                .addValue("id", id);
        try {
            template.update(sql, params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(UUID id) {
        if (check(id)) {
            return false;
        }
        String sql = "DELETE FROM judges.judges WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        try{
            template.update(sql, params);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
