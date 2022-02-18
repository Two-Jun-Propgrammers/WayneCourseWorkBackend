package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Round model")
public class Round {
    @ApiModelProperty(value = "Id раунда. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Id номинации. NotNull.", required = true)
    private UUID nominationId;
    @ApiModelProperty(value = "Номер раунда. NotNull.", required = true)
    private int number;
    @ApiModelProperty(value = "Название раунда. Можно не указывать.")
    private String name;
    @ApiModelProperty(value = "Id категории оружия. NotNull.", required = true)
    private UUID weaponId;
}
