package com.example.coursework.controller;

import com.example.coursework.model.Role;
import com.example.coursework.service.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/roles")
public class RolesController {
    private final RoleService roleService;

    @Autowired
    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(
            value = "Добавление новой роли.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления новой роли.", required = true)
            @RequestBody Role role) {
        final boolean created = roleService.create(role);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных роли.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id роли, данные которой нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных роли.", required = true)
            @RequestBody Role role) {
        final boolean updated = roleService.update(id, role);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных роли.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id роли, которую удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = roleService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> roles = roleService.findAll();

        return roles != null &&  !roles.isEmpty()
                ? new ResponseEntity<>(roles, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<Role> search(
            @RequestParam(value = "id") UUID id) {
        final Role role = roleService.search(id);

        return role != null
                ? new ResponseEntity<>(role, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
