package com.project.splitwise.controllers;

import com.project.splitwise.dtos.requestDtos.RegisterUserRequestDto;
import com.project.splitwise.dtos.requestDtos.UpdateProfileRequestDto;
import com.project.splitwise.dtos.responseDtos.RegisterUserResponseDto;
import com.project.splitwise.dtos.responseDtos.UpdateProfileResponseDto;
import com.project.splitwise.exceptions.UserAlreadyExistException;
import com.project.splitwise.exceptions.WrongUserIdInputException;
import com.project.splitwise.models.User;
import com.project.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }




    public RegisterUserResponseDto registerUser(RegisterUserRequestDto request){
        User user;
        RegisterUserResponseDto response = new RegisterUserResponseDto();
        try {
            user = userService.registerUser(
                    request.getUserName(),
                    request.getPassword(),
                    request.getPhoneNo());
            response.setUserId(user.getId());
            response.setUserStatus("SUCCESS");
        }catch (UserAlreadyExistException userAlreadyExistException){
            response.setUserStatus("FAILURE");
            response.setMessage(userAlreadyExistException.getMessage());
        }

        return response;
    }


    public UpdateProfileResponseDto updateUserProfile(UpdateProfileRequestDto request){
        UpdateProfileResponseDto response = new UpdateProfileResponseDto();
        try {
            userService.updateUserProfile(request.getUserId(),request.getPassword());
            response.setUserStatus("SUCCESS");
        }catch (WrongUserIdInputException wrongUserIdInputException){
            response.setUserStatus("FAILURE");
            response.setMessage(wrongUserIdInputException.getMessage());
        }

        return response;
    }

}
