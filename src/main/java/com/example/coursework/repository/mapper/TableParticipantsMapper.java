package com.example.coursework.repository.mapper;

import com.example.coursework.model.TableParticipants;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TableParticipantsMapper implements RowMapper<TableParticipants> {
    @Override
    public TableParticipants mapRow(ResultSet rs, int rowNum) throws SQLException {
        TableParticipants tableParticipants = new TableParticipants();
        tableParticipants.setNumber(rs.getInt(1));
        tableParticipants.setFirstName(rs.getString(2));
        tableParticipants.setLastName(rs.getString(3));
        tableParticipants.setClub(rs.getString(4));

        return tableParticipants;
    }
}
