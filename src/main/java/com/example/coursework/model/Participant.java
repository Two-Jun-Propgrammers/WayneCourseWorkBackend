package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Participant model")
public class Participant {
    @ApiModelProperty(value = "Id участника. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Уникальный номер участника. NotNull.", required = true)
    private int number;
    @ApiModelProperty(value = "Имя. NotNull.", required = true)
    private String firstName;
    @ApiModelProperty(value = "Фамилия. NotNull.", required = true)
    private String lastName;
    @ApiModelProperty(value = "Id клуба. Можно не указывать.")
    private UUID clubId;
}
