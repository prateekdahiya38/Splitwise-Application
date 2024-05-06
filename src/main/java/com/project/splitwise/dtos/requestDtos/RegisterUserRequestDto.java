package com.project.splitwise.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String password;
    private String phoneNo;
    private String userName;
}
