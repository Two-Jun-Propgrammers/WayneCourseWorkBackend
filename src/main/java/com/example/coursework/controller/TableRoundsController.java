package com.example.coursework.controller;

import com.example.coursework.model.TableRounds;
import com.example.coursework.service.TableRoundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/t3")
public class TableRoundsController {
    private final TableRoundsService tableRoundsService;

    @Autowired
    public TableRoundsController(TableRoundsService tableRoundsService) {
        this.tableRoundsService = tableRoundsService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<TableRounds>> findAll() {
        final List<TableRounds> tableRounds = tableRoundsService.findAll();

        return tableRounds != null &&  !tableRounds.isEmpty()
                ? new ResponseEntity<>(tableRounds, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
