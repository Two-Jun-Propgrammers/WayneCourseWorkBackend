package com.example.coursework.controller;

import com.example.coursework.model.Round;
import com.example.coursework.service.RoundsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rounds")
public class RoundsController {
    private final RoundsService roundsService;

    @Autowired
    public RoundsController(RoundsService roundsService) {
        this.roundsService = roundsService;
    }

    @ApiOperation(
            value = "Добавление нового раунда.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления нового раунда.", required = true)
            @RequestBody Round round) {
        final boolean created = roundsService.create(round);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных раунда.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id раунда, данные которого нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных раунда.", required = true)
            @RequestBody Round round) {
        final boolean updated = roundsService.update(id, round);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных раунда.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id раунда, который удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = roundsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> rounds = roundsService.findAll();

        return rounds != null &&  !rounds.isEmpty()
                ? new ResponseEntity<>(rounds, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<Round> search(
            @RequestParam(value = "id") UUID id) {
        final Round round = roundsService.search(id);

        return round != null
                ? new ResponseEntity<>(round, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
