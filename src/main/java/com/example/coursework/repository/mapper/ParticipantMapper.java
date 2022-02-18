package com.example.coursework.repository.mapper;

import com.example.coursework.model.Participant;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class ParticipantMapper implements RowMapper<Participant> {
    @Override
    public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Participant participant = new Participant();
        participant.setId(UUID.fromString(rs.getString("id")));
        participant.setNumber(rs.getInt("number"));
        participant.setFirstName(rs.getString("firstname"));
        participant.setLastName(rs.getString("lastname"));
        participant.setClubId(UUID.fromString(rs.getString("club_id")));

        return participant;
    }
}
