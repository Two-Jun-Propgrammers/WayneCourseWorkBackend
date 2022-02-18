package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Platform model")
public class Platform {
    @ApiModelProperty(value = "Id площадки. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Номер площадки. NotNull.", required = true)
    private int number;
    @ApiModelProperty(value = "Название. NotNull.", required = true)
    private String name;
}
