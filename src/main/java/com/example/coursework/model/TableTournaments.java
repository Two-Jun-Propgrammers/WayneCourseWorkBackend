package com.example.coursework.model;

import lombok.Data;

import java.util.Date;

@Data
public class TableTournaments {
    private String name;
    private String arena;
    private Date beginning;
    private Date ending;
}
