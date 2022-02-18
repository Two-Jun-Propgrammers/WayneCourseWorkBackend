package com.example.coursework.repository.mapper;

import com.example.coursework.model.WeaponCategory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class WeaponCategoryMapper implements RowMapper<WeaponCategory> {
    @Override
    public WeaponCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        WeaponCategory weaponCategory = new WeaponCategory();
        weaponCategory.setId(UUID.fromString(rs.getString("id")));
        weaponCategory.setName(rs.getString("name"));

        return weaponCategory;
    }
}
