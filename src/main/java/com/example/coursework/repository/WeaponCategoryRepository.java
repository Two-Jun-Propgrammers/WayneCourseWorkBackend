package com.example.coursework.repository;

import com.example.coursework.model.WeaponCategory;
import com.example.coursework.repository.mapper.WeaponCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class WeaponCategoryRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    @Autowired
    private WeaponCategoryMapper weaponCategoryMapper;

    public List<UUID> findAll() {
        String sql = "SELECT * FROM weapon_category.weapon_category";
        List<WeaponCategory> weaponCategories = template.query(sql, weaponCategoryMapper);
        List<UUID> result = new ArrayList<>();
        for (WeaponCategory weaponCategory : weaponCategories) {
            result.add(weaponCategory.getId());
        }
        return result;
    }

    public WeaponCategory search(UUID id)
    {
        String sql = "SELECT * FROM weapon_category.weapon_category WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return template.queryForObject(sql, params, weaponCategoryMapper);
    }

    public boolean create(WeaponCategory weaponCategory) {
        String sql = "INSERT INTO weapon_category.weapon_category (id, name) VALUES (:id, :name)";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", UUID.randomUUID())
                .addValue("name", weaponCategory.getName());
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

    public boolean update(UUID id, WeaponCategory weaponCategory) {
        if (check(id)) {
            return false;
        }
        String sql = "UPDATE weapon_category.weapon_category SET name = :name WHERE id = :id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", weaponCategory.getName())
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
        String sql = "DELETE FROM weapon_category.weapon_category WHERE id = :id";
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
