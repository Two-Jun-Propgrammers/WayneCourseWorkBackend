package com.example.coursework.controller;

import com.example.coursework.model.TableClubs;
import com.example.coursework.service.TableClubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/t6")
public class TableClubsController {
    private final TableClubsService tableClubsService;

    @Autowired
    public TableClubsController(TableClubsService tableClubsService) {
        this.tableClubsService = tableClubsService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<TableClubs>> findAll() {
        final List<TableClubs> tableClubs = tableClubsService.findAll();

        return tableClubs != null &&  !tableClubs.isEmpty()
                ? new ResponseEntity<>(tableClubs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
