package com.example.coursework.repository;

import com.example.coursework.model.Nomination;
import com.example.coursework.repository.mapper.NominationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class NominationRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private NominationMapper nominationMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM nomination.nomination";
        List<Nomination> nominations = template.query(sql, nominationMapper);
        List<UUID> result = new ArrayList<>();
        for (Nomination nomination : nominations) {
            result.add(nomination.getId());
        }
        return result;
    }

    public Nomination search(UUID id)
    {
        String sql = "SELECT * FROM nomination.nomination WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, nominationMapper);
    }

    public boolean create(Nomination nomination) {
        String sql = "INSERT INTO nomination.nomination (id, tournament_id, name) VALUES (:id, :tournamentId, :name)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("tournamentId", nomination.getTournamentId())
                .addValue("name", nomination.getName());
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

    public boolean update(UUID id, Nomination nomination) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE nomination.nomination SET tournament_id = :tournamentId, name = :name WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("tournamentId", nomination.getTournamentId())
                .addValue("name", nomination.getName())
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
        String sql = "DELETE FROM nomination.nomination WHERE id = :id";
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
