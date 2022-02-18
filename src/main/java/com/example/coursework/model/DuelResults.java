package com.example.coursework.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.UUID;

@Data
@ApiModel(value = "DuelResults model")
public class DuelResults {
    @ApiModelProperty(value = "Id результатов матча. При вставке генерится автоматически. NotNull.")
    private UUID id;
    @ApiModelProperty(value = "Id участника. NotNull.", required = true)
    private UUID participantId;
    @ApiModelProperty(value = "Id матча. NotNull.", required = true)
    private UUID duelId;
    @ApiModelProperty(value = "Очки участника. NotNull.")
    private int points;
}
