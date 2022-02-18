package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Arena model")
public class Arena {
    @ApiModelProperty(value = "Id арены. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Уникальное название. NotNull.", required = true)
    private String name;
    @ApiModelProperty(value = "Id местоположения. NotNull.", required = true)
    private UUID locationId;
}
