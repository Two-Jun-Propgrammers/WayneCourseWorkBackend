package com.example.coursework.controller;

import com.example.coursework.model.Location;
import com.example.coursework.service.LocationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ApiOperation(
            value = "Добавление новой локации.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления новой локации.", required = true)
            @RequestBody Location location) {
        final boolean created = locationService.create(location);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных локации.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id локации, данные которой нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных локации.", required = true)
            @RequestBody Location location) {
        final boolean updated = locationService.update(id, location);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных локации.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id локации, которую удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = locationService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> locations = locationService.findAll();

        return locations != null &&  !locations.isEmpty()
                ? new ResponseEntity<>(locations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<Location> search(
            @RequestParam(value = "id") UUID id) {
        final Location location = locationService.search(id);

        return location != null
                ? new ResponseEntity<>(location, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
