package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Club model")
public class Club {
    @ApiModelProperty(value = "Id клуба. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Название клуба. NotNull.", required = true)
    private String name;
    @ApiModelProperty(value = "Активность. NotNull.")
    private boolean activity;
    @ApiModelProperty(value = "Id местоположения. NotNull.", required = true)
    private UUID locationId;
}
