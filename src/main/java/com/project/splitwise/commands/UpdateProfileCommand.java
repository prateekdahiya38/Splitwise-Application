package com.project.splitwise.commands;

import com.project.splitwise.controllers.UserController;
import com.project.splitwise.dtos.requestDtos.UpdateProfileRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UpdateProfileCommand implements Command{
    private UserController userController;


    @Autowired
    public UpdateProfileCommand(UserController userController) {
        this.userController = userController;
    }

    @Override
    public boolean macthes(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        if (inpWords.size() == 3 && inpWords.get(1).equalsIgnoreCase(CommandKeywords.UPDATE_PROFILE)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        String userIdInp = inpWords.get(0);
        Long userId = Long.parseLong(userIdInp);
        String password = inpWords.get(2);
        UpdateProfileRequestDto request = new UpdateProfileRequestDto();
        request.setPassword(password);
        request.setUserId(userId);
        userController.updateUserProfile(request);
    }
}
