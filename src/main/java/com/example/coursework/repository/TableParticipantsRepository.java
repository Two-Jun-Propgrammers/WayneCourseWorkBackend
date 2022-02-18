package com.example.coursework.repository;

import com.example.coursework.model.TableParticipants;
import com.example.coursework.repository.mapper.TableParticipantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableParticipantsRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private TableParticipantsMapper tableParticipantsMapper;

    public List<TableParticipants> findAll()
    {
        String sql = "select t1.number, t1.firstname, t1.lastname, t2.name from participants.participants t1 inner join clubs.clubs t2 on t1.club_id = t2.id";
        return template.query(sql, tableParticipantsMapper);
    }
}
