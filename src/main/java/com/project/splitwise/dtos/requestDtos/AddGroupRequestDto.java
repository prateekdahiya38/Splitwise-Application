package com.project.splitwise.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGroupRequestDto {
    private String groupName;
    private Long UserId;
}
