package com.example.coursework.controller;

import com.example.coursework.model.Judge;
import com.example.coursework.service.JudgesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/judges")
public class JudgesController {
    private final JudgesService judgesService;

    @Autowired
    public JudgesController(JudgesService judgesService) {
        this.judgesService = judgesService;
    }

    @ApiOperation(
            value = "Добавление нового судьи.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PostMapping(value = "/user/create")
    public ResponseEntity<?> create(
            @ApiParam(value = "Модель для добавления нового судьи.", required = true)
            @RequestBody Judge judge) {
        final boolean created = judgesService.create(judge);
        return created
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Модификация данных судьи.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @PutMapping(value = "/user/update")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id судьи, данные которого нужно изменить.", required = true)
            @RequestParam(value = "id") UUID id,
            @ApiParam(value = "Модель для изменения данных судьи.", required = true)
            @RequestBody Judge judge) {
        final boolean updated = judgesService.update(id, judge);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @ApiOperation(
            value = "Удаление данных судьи.",
            notes = "Доступ имеют только судьи(users) и админы(admins).")
    @DeleteMapping(value = "/user/delete")
    public ResponseEntity<?> delete(
            @ApiParam(value = "Id судьи, который удаляем.", required = true)
            @RequestParam(value = "id") UUID id) {
        final boolean deleted = judgesService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/user/findAll")
    public ResponseEntity<List<UUID>> findAll() {
        final List<UUID> judges = judgesService.findAll();

        return judges != null &&  !judges.isEmpty()
                ? new ResponseEntity<>(judges, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/search")
    public ResponseEntity<Judge> search(
            @RequestParam(value = "id") UUID id) {
        final Judge judge = judgesService.search(id);

        return judge != null
                ? new ResponseEntity<>(judge, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
