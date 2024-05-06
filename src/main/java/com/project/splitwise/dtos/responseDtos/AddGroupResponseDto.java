package com.project.splitwise.dtos.responseDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGroupResponseDto {
    private Long groupId;
    private String status;
    private String message;
}
