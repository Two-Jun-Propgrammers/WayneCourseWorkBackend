package com.example.coursework.repository;

import com.example.coursework.model.Club;
import com.example.coursework.repository.mapper.ClubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ClubRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private ClubMapper clubMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM clubs.clubs";
        List<Club> clubs = template.query(sql, clubMapper);
        List<UUID> result = new ArrayList<>();
        for (Club club : clubs) {
            result.add(club.getId());
        }
        return result;
    }

    public Club search(UUID id)
    {
        String sql = "SELECT * FROM clubs.clubs WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, clubMapper);
    }

    public boolean create(Club club) {
        String sql = "INSERT INTO clubs.clubs (id, name, activity, location_id) VALUES (:id, :name, :activity, :locationId)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("name", club.getName())
                .addValue("activity", club.isActivity())
                .addValue("locationId", club.getLocationId());
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

    public boolean update(UUID id, Club club) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE clubs.clubs SET name = :name, activity = :activity, location_id = :locationId WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", club.getName())
                .addValue("activity", club.isActivity())
                .addValue("locationId", club.getLocationId())
                .addValue("id", id);
        try {
            template.update(sql, params);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(UUID id) { //todo может этот метод назвать setActive/changeActive? ставит противоположное значение
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE clubs.clubs SET activity = :activity WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("activity", !search(id).isActivity())
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
