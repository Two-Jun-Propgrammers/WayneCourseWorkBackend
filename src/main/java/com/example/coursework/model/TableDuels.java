package com.example.coursework.model;

import lombok.Data;

@Data
public class TableDuels {
    private int duelNumber;
    private String judge;
    private String platform;
    private String participant1;
    private int points1;
    private String participant2;
    private int points2;
}
