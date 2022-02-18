package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Judge model")
public class Judge {
    @ApiModelProperty(value = "Id судьи. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Имя. NotNull.", required = true)
    private String firstName;
    @ApiModelProperty(value = "Фамилия. NotNull.", required = true)
    private String lastName;
}
