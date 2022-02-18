package com.example.coursework.repository;

import com.example.coursework.model.Participant;
import com.example.coursework.repository.mapper.ParticipantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ParticipantRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private ParticipantMapper participantMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM participants.participants";
        List<Participant> participants = template.query(sql, participantMapper);
        List<UUID> result = new ArrayList<>();
        for (Participant participant : participants) {
            result.add(participant.getId());
        }
        return result;
    }

    public Participant search(UUID id)
    {
        String sql = "SELECT * FROM participants.participants WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, participantMapper);
    }

    public boolean create(Participant participant) {
        String sql = "INSERT INTO participants.participants (id, firstname, lastname, club_id) VALUES (:id, :firstName, :lastName, :clubId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("firstName", participant.getFirstName())
                .addValue("lastName", participant.getLastName())
                .addValue("clubId", participant.getClubId());
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

    public boolean update(UUID id, Participant participant) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE participants.participants SET firstname = :firstName, lastname = :lastName, club_id = :clubId WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("firstName", participant.getFirstName())
                .addValue("lastName", participant.getLastName())
                .addValue("clubId", participant.getClubId())
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
        String sql = "DELETE FROM participants.participants WHERE id = :id";
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
