package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Nomination model")
public class Nomination {
    @ApiModelProperty(value = "Id номинации. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Id турнира. NotNull.", required = true)
    private UUID tournamentId;
    @ApiModelProperty(value = "Название. NotNull.", required = true)
    private String name;
}
