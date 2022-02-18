package com.example.coursework.controller;

import com.example.coursework.model.UserRoles;
import com.example.coursework.service.UsersRolesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usersroles")
public class UsersRolesController {
    private final UsersRolesService usersRolesService;

    @Autowired
    public UsersRolesController(UsersRolesService usersRolesService) {
        this.usersRolesService = usersRolesService;
    }

    @ApiOperation(
            value = "Добавление новых прав.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления новых прав.", required = true)
            @RequestBody UserRoles userRoles) {
        final boolean created = usersRolesService.create(userRoles);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных прав.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id прав, данные которых нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных прав.", required = true)
            @RequestBody UserRoles userRoles) {
        final boolean updated = usersRolesService.update(id, userRoles);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных прав.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id прав, которые удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = usersRolesService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> userRoles = usersRolesService.findAll();

        return userRoles != null &&  !userRoles.isEmpty()
                ? new ResponseEntity<>(userRoles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<UserRoles> search(
            @RequestParam(value = "id") UUID id) {
        final UserRoles userRoles = usersRolesService.search(id);

        return userRoles != null
                ? new ResponseEntity<>(userRoles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
