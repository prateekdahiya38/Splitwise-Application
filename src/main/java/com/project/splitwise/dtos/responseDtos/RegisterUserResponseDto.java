package com.project.splitwise.dtos.responseDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserResponseDto {
    private Long userId;
    private String userStatus;
    private String message;

}
