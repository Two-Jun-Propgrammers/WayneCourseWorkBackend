package com.example.coursework.controller;

import com.example.coursework.model.TableTournaments;
import com.example.coursework.service.TableTournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/t1")
public class TableTournamentController {
    private final TableTournamentService tableTournamentService;

    @Autowired
    public TableTournamentController(TableTournamentService tableTournamentService) {
        this.tableTournamentService = tableTournamentService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<TableTournaments>> findAll() {
        final List<TableTournaments> tableTournaments = tableTournamentService.findAll();

        return tableTournaments != null &&  !tableTournaments.isEmpty()
                ? new ResponseEntity<>(tableTournaments, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
