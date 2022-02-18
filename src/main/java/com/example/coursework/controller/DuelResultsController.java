package com.example.coursework.controller;

import com.example.coursework.model.DuelResults;
import com.example.coursework.service.DuelResultsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/duelresults")
public class DuelResultsController {
    private final DuelResultsService duelResultsService;

    @Autowired
    public DuelResultsController(DuelResultsService duelResultsService) {
        this.duelResultsService = duelResultsService;
    }

    @ApiOperation(
            value = "Добавление новых результатов.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления новых результатов.", required = true)
            @RequestBody DuelResults duelResults) {
        final boolean created = duelResultsService.create(duelResults);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных результатов.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id результатов, данные котороых нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных результатов.", required = true)
            @RequestBody DuelResults duelResults) {
        final boolean updated = duelResultsService.update(id, duelResults);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных результатов.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id результатов, которые удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = duelResultsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> duelResults = duelResultsService.findAll();

        return duelResults != null &&  !duelResults.isEmpty()
                ? new ResponseEntity<>(duelResults, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<DuelResults> search(
            @RequestParam(value = "id") UUID id) {
        final DuelResults duelResults = duelResultsService.search(id);

        return duelResults != null
                ? new ResponseEntity<>(duelResults, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
