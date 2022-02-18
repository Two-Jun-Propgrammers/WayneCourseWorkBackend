package com.example.coursework.controller;

import com.example.coursework.model.Duel;
import com.example.coursework.service.DuelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/duel")
public class DuelController {
    private final DuelService duelService;

    @Autowired
    public DuelController(DuelService duelService) {
        this.duelService = duelService;
    }

    @ApiOperation(
            value = "Добавление нового матча.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления нового матча.", required = true)
            @RequestBody Duel duel) {
        final boolean created = duelService.create(duel);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных матча.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id матча, данные которого нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных матча.", required = true)
            @RequestBody Duel duel) {
        final boolean updated = duelService.update(id, duel);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных матча.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id матча, который удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = duelService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> duels = duelService.findAll();

        return duels != null &&  !duels.isEmpty()
                ? new ResponseEntity<>(duels, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<Duel> search(
            @RequestParam(value = "id") UUID id) {
        final Duel duel = duelService.search(id);

        return duel != null
                ? new ResponseEntity<>(duel, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
