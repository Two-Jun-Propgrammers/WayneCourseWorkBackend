package com.example.coursework.controller;

import com.example.coursework.model.WeaponCategory;
import com.example.coursework.service.WeaponCategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/weapon")
public class WeaponCategoryController {
    private final WeaponCategoryService weaponCategoryService;

    @Autowired
    public WeaponCategoryController(WeaponCategoryService weaponCategoryService) {
        this.weaponCategoryService = weaponCategoryService;
    }

    @ApiOperation(
            value = "Добавление нового оружия.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления нового оружия.", required = true)
            @RequestBody WeaponCategory weaponCategory) {
        final boolean created = weaponCategoryService.create(weaponCategory);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных оружия.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id оружия, данные которого нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных оружия.", required = true)
            @RequestBody WeaponCategory weaponCategory) {
        final boolean updated = weaponCategoryService.update(id, weaponCategory);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных оружия.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id оружия, который удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = weaponCategoryService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> weapons = weaponCategoryService.findAll();

        return weapons != null &&  !weapons.isEmpty()
                ? new ResponseEntity<>(weapons, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<WeaponCategory> search(
            @RequestParam(value = "id") UUID id) {
        final WeaponCategory weaponCategory = weaponCategoryService.search(id);

        return weaponCategory != null
                ? new ResponseEntity<>(weaponCategory, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
