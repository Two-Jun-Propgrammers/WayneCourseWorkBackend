package com.example.coursework.repository;

import com.example.coursework.model.TableTournaments;
import com.example.coursework.repository.mapper.TableTournamentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableTournamentRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private TableTournamentsMapper tableTournamentsMapper;

    public List<TableTournaments> findAll()
    {
        String sql = "select t1.name, t2.name, t1.beginning, t1.ending from tournament.tournament t1 inner join arena.arena t2 on t1.arena_id = t2.id";
        return template.query(sql, tableTournamentsMapper);
    }
}
