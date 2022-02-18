package com.example.coursework.repository;

import com.example.coursework.model.Location;
import com.example.coursework.repository.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class LocationRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private LocationMapper locationMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM location.location";
        List<Location> locations = template.query(sql, locationMapper);
        List<UUID> result = new ArrayList<>();
        for (Location location : locations) {
            result.add(location.getId());
        }
        return result;
    }

    public Location search(UUID id)
    {
        String sql = "SELECT * FROM location.location WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, locationMapper);
    }

    public boolean create(Location location) {
        String sql = "INSERT INTO location.location (id, city, street, house) VALUES (:id, :city, :street, :house)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("city", location.getCity())
                .addValue("street", location.getStreet())
                .addValue("house", location.getHouse());
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

    public boolean update(UUID id, Location location) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE location.location SET city = :city, street = :street, house = :house WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("city", location.getCity())
                .addValue("street", location.getStreet())
                .addValue("house", location.getHouse())
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
        String sql = "DELETE FROM location.location WHERE id = :id";
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
