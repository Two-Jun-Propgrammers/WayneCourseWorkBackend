package com.example.coursework.repository.mapper;

import com.example.coursework.model.Round;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class RoundMapper implements RowMapper<Round> {
    @Override
    public Round mapRow(ResultSet rs, int rowNum) throws SQLException {
        Round round = new Round();
        round.setId(UUID.fromString(rs.getString("id")));
        round.setNominationId(UUID.fromString(rs.getString("nomination_id")));
        round.setNumber(rs.getInt("number"));
        round.setName(rs.getString("name"));
        round.setWeaponId(UUID.fromString(rs.getString("weapon_id")));

        return round;
    }
}
