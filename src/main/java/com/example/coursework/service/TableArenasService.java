package com.example.coursework.service;

import com.example.coursework.model.TableArenas;
import com.example.coursework.repository.TableArenasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableArenasService {
    @Autowired
    private TableArenasRepository tableArenasRepository;

    public List<TableArenas> findAll() {
        return tableArenasRepository.findAll();
    }
}
