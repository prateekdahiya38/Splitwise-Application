package com.project.splitwise.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequestDto {
    private Long userId;
    private String password;
}
