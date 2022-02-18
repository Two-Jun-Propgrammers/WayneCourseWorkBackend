package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "WeaponCategory model")
public class WeaponCategory {
    @ApiModelProperty(value = "Id категории. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Название категории оружия. Уникальное. NotNull.", required = true)
    private String name;
}
