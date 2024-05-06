package com.project.splitwise.commands;

import com.project.splitwise.controllers.UserController;
import com.project.splitwise.dtos.requestDtos.RegisterUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RegisterUserCommand implements Command{
    private UserController userController;


    @Autowired
    public RegisterUserCommand(UserController userController) {

        this.userController = userController;
    }

    @Override
    public boolean macthes(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();

        if (inpWords.size() == 4 && inpWords.get(0).equalsIgnoreCase(CommandKeywords.REGISTER_USER)){
            return true;
        }
        return false;
    }



    @Override
    public void execute(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();

        String password = inpWords.get(1);
        String phoneNo = inpWords.get(2);
        String userName = inpWords.get(3);
        RegisterUserRequestDto request = new RegisterUserRequestDto();
        request.setUserName(userName);
        request.setPhoneNo(phoneNo);
        request.setPassword(password);
        userController.registerUser(request);
    }
}
