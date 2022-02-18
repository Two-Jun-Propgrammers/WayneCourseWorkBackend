package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "Location model")
public class Location {
    @ApiModelProperty(value = "Id местоположения. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Город. NotNull.", required = true)
    private String city;
    @ApiModelProperty(value = "Улица. Можно не указывать.")
    private String street;
    @ApiModelProperty(value = "Дом. Можно не указывать.")
    private String house;
}
