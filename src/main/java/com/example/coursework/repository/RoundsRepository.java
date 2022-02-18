package com.example.coursework.repository;

import com.example.coursework.model.Round;
import com.example.coursework.repository.mapper.RoundMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class RoundsRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private RoundMapper roundMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM rounds.rounds";
        List<Round> rounds = template.query(sql, roundMapper);
        List<UUID> result = new ArrayList<>();
        for (Round round : rounds) {
            result.add(round.getId());
        }
        return result;
    }

    public Round search(UUID id)
    {
        String sql = "SELECT * FROM rounds.rounds WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, roundMapper );
    }

    public boolean create(Round round) {
        String sql = "INSERT INTO rounds.rounds (id, nomination_id, number, name, weapon_id)  VALUES (:id, :nominationId, :number, :name, :weaponId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("nominationId", round.getNominationId())
                .addValue("number", round.getNumber())
                .addValue("name", round.getName())
                .addValue("weaponId", round.getWeaponId());
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

    public boolean update(UUID id, Round round) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE rounds.rounds SET nomination_id = :nominationId, number = :number, name = :name, weapon_id = :weaponId WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("nominationId", round.getNominationId())
                .addValue("number", round.getNumber())
                .addValue("name", round.getName())
                .addValue("weaponId", round.getWeaponId())
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
        String sql = "DELETE FROM rounds.rounds WHERE id = :id";
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
