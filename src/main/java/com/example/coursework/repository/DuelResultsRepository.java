package com.example.coursework.repository;

import com.example.coursework.model.DuelResults;
import com.example.coursework.repository.mapper.DuelResultsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class DuelResultsRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private DuelResultsMapper duelResultsMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM duel_results.duel_results";
        List<DuelResults> duelResults = template.query(sql, duelResultsMapper);
        List<UUID> result = new ArrayList<>();
        for (DuelResults duelResult : duelResults) {
            result.add(duelResult.getId());
        }
        return result;
    }

    public DuelResults search(UUID id)
    {
        String sql = "SELECT * FROM duel_results.duel_results WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, duelResultsMapper);
    }

    public boolean create(DuelResults duelResults) {
        String sql = "insert into duel_results.duel_results (id, participant_id, duel_id, points) VALUES (:id, :participantId, :duelId, :points)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("participantId", duelResults.getParticipantId())
                .addValue("duelId", duelResults.getDuelId())
                .addValue("points", duelResults.getPoints());
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

    public boolean update(UUID id, DuelResults duelResults) {
        if (check(id)) {
            return false;
        }
        String sql = "update duel_results.duel_results set participant_id = :participantId, duel_id = :duelId, points = :points WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("participantId", duelResults.getParticipantId())
                .addValue("duelId", duelResults.getDuelId())
                .addValue("points", duelResults.getPoints())
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
        String sql = "DELETE FROM duel_results.duel_results WHERE id = :id";
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
