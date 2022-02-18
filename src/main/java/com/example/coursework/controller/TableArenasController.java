package com.example.coursework.controller;

import com.example.coursework.model.TableArenas;
import com.example.coursework.service.TableArenasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/t2")
public class TableArenasController {
    private final TableArenasService tableArenasService;

    @Autowired
    public TableArenasController(TableArenasService tableArenasService) {
        this.tableArenasService = tableArenasService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<TableArenas>> findAll() {
        final List<TableArenas> tableArenas = tableArenasService.findAll();

        return tableArenas != null &&  !tableArenas.isEmpty()
                ? new ResponseEntity<>(tableArenas, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
