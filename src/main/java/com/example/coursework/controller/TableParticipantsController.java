package com.example.coursework.controller;

import com.example.coursework.model.TableParticipants;
import com.example.coursework.service.TableParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/t4")
public class TableParticipantsController {
    private final TableParticipantsService tableParticipantsService;

    @Autowired
    public TableParticipantsController(TableParticipantsService tableParticipantsService) {
        this.tableParticipantsService = tableParticipantsService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<TableParticipants>> findAll() {
        final List<TableParticipants> tableParticipants = tableParticipantsService.findAll();

        return tableParticipants != null &&  !tableParticipants.isEmpty()
                ? new ResponseEntity<>(tableParticipants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
