package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Duel model")
public class Duel {
    @ApiModelProperty(value = "Id матча. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Id раунда. NotNull.", required = true)
    private UUID roundId;
    @ApiModelProperty(value = "Номер матча. NotNull.", required = true)
    private int number;
    @ApiModelProperty(value = "Id судьи. NotNull.", required = true)
    private UUID judgesId;
    @ApiModelProperty(value = "Id площадки. NotNull.", required = true)
    private UUID platformId;
}
