package com.example.coursework.repository.mapper;

import com.example.coursework.model.Duel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class DuelMapper implements RowMapper<Duel> {
    @Override
    public Duel mapRow(ResultSet rs, int rowNum) throws SQLException{
        Duel duel = new Duel();
        duel.setId(UUID.fromString(rs.getString("id")));
        duel.setRoundId(UUID.fromString(rs.getString("round_id")));
        duel.setNumber(rs.getInt("number"));
        duel.setJudgesId(UUID.fromString(rs.getString("judges_id")));
        duel.setPlatformId(UUID.fromString(rs.getString("platform_id")));

        return duel;
    }
}
