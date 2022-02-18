package com.example.coursework.repository;

import com.example.coursework.model.Duel;
import com.example.coursework.repository.mapper.DuelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class DuelRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private DuelMapper duelMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM duel.duel";
        List<Duel> duels = template.query(sql, duelMapper);
        List<UUID> result = new ArrayList<>();
        for (Duel duel : duels) {
            result.add(duel.getId());
        }
        return result;
    }

    public Duel search(UUID id)
    {
        String sql = "SELECT * FROM duel.duel WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, duelMapper);
    }

    public boolean create(Duel duel) {
        String sql = "INSERT INTO duel.duel (id, round_id, number, judges_id, platform_id) VALUES (:id, :roundId, :number, :judgesId, :platformId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("roundId", duel.getRoundId())
                .addValue("number", duel.getNumber())
                .addValue("judgesId", duel.getJudgesId())
                .addValue("platformId", duel.getPlatformId());
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

    public boolean update(UUID id, Duel duel) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE duel.duel SET round_id = :roundId, number = :number, judges_id = : judgesId, platform_id = :platformId WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("roundId", duel.getRoundId())
                .addValue("number", duel.getNumber())
                .addValue("judgesId", duel.getJudgesId())
                .addValue("platformId", duel.getPlatformId())
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
        String sql = "DELETE FROM duel.duel WHERE id = :id";
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
