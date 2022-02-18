package com.example.coursework.repository;

import com.example.coursework.model.Tournament;
import com.example.coursework.repository.mapper.TournamentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class TournamentRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private TournamentMapper tournamentMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM tournament.tournament";
        List<Tournament> tournaments = template.query(sql, tournamentMapper);
        List<UUID> result = new ArrayList<>();
        for (Tournament tournament : tournaments) {
            result.add(tournament.getId());
        }
        return result;
    }

    public Tournament search(UUID id)
    {
        String sql = "SELECT * FROM tournament.tournament WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, tournamentMapper );
    }

    public boolean create(Tournament tournament) {
        String sql = "INSERT INTO tournament.tournament (id, name, beginning, ending, arena_id) VALUES (:id, :name, :beginning, :ending, :arenaId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("name", tournament.getName())
                .addValue("beginning", tournament.getBeginning())
                .addValue("ending", tournament.getEnding())
                .addValue("arenaId", tournament.getArenaId());
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

    public boolean update(UUID id, Tournament tournament) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE tournament.tournament SET name = :name, beginning = :beginning, ending = :ending, arena_id = :arenaId WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", tournament.getName())
                .addValue("beginning", tournament.getBeginning())
                .addValue("ending", tournament.getEnding())
                .addValue("arenaId", tournament.getArenaId())
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
        String sql = "DELETE FROM tournament.tournament WHERE id = :id";
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
