package com.example.coursework.repository.mapper;

import com.example.coursework.model.UserRoles;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class UserRolesMapper implements RowMapper<UserRoles> {
    @Override
    public UserRoles mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserRoles userRoles = new UserRoles();
        userRoles.setId(UUID.fromString(rs.getString("id")));
        userRoles.setUserId(UUID.fromString(rs.getString("user_id")));
        userRoles.setRoleId(UUID.fromString(rs.getString("role_id")));

        return userRoles;
    }
}
