package com.example.coursework.controller;

import com.example.coursework.model.TableDuels;
import com.example.coursework.service.TableDuelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/t5")
public class TableDuelsController {
    private final TableDuelsService tableDuelsService;

    @Autowired
    public TableDuelsController(TableDuelsService tableDuelsService) {
        this.tableDuelsService = tableDuelsService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<TableDuels>> findAll() {
        final List<TableDuels> tableDuels = tableDuelsService.findAll();

        return tableDuels != null &&  !tableDuels.isEmpty()
                ? new ResponseEntity<>(tableDuels, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
