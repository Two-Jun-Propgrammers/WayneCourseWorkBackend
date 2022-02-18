package com.example.coursework.repository.mapper;

import com.example.coursework.model.DuelResults;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class DuelResultsMapper implements RowMapper<DuelResults> {
    @Override
    public DuelResults mapRow(ResultSet rs, int rowNum) throws SQLException {
        DuelResults duelResults = new DuelResults();
        duelResults.setId(UUID.fromString(rs.getString("id")));
        duelResults.setParticipantId(UUID.fromString(rs.getString("participant_id")));
        duelResults.setDuelId(UUID.fromString(rs.getString("duel_id")));
        duelResults.setPoints(rs.getInt("points"));

        return duelResults;
    }
}
