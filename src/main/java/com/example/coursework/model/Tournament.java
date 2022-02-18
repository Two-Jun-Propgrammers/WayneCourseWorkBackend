package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@ApiModel(value = "Tournament model")
public class Tournament {
    @ApiModelProperty(value = "Id турнира. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Уникальное название турнира. NotNull.", required = true)
    private String name;
    @ApiModelProperty(value = "Дата начала. NotNull.", required = true)
    private Date beginning;
    @ApiModelProperty(value = "Дата окончания.")
    private Date ending;
    @ApiModelProperty(value = "Id арены. NotNull.", required = true)
    private UUID arenaId;
}
