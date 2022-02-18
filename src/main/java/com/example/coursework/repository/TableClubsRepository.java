package com.example.coursework.repository;

import com.example.coursework.model.TableClubs;
import com.example.coursework.repository.mapper.TableClubsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableClubsRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private TableClubsMapper tableClubsMapper;

    public List<TableClubs> findAll()
    {
        String sql = "select t1.name, t1.activity, t2.city, t2.street, t2.house from clubs.clubs t1 inner join location.location t2 on t1.location_id = t2.id";
        return template.query(sql, tableClubsMapper);
    }
}
