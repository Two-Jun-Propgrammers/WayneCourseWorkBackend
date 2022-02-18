package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "User model")
public class User {
    @ApiModelProperty(value = "Id пользователя. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Логин пользователя. Уникальный. NotNull.", required = true)
    private String username;
    @ApiModelProperty(value = "Пароль пользователя. NotNull.", required = true)
    private String password;
    @ApiModelProperty(value = "Имя. NotNull.", required = true)
    private String firstName;
    @ApiModelProperty(value = "Фамилия. NotNull.", required = true)
    private String lastName;
}
