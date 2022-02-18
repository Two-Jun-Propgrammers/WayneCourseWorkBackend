package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "UserRoles model")
public class UserRoles {
    @ApiModelProperty(value = "Id. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Id пользователя. NotNull.", required = true)
    private UUID userId;
    @ApiModelProperty(value = "Id роли/прав доступа. NotNull.", required = true)
    private UUID roleId;
}
