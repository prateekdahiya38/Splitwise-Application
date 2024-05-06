package com.project.splitwise.commands;

import com.project.splitwise.controllers.GroupController;
import com.project.splitwise.dtos.requestDtos.AddGroupRequestDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
@Component
public class AddGroupCommand implements Command{
    private GroupController groupController;


    public AddGroupCommand(GroupController groupController) {
        this.groupController = groupController;
    }

    @Override
    public boolean macthes(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        if (inpWords.size() == 3 && inpWords.get(1).equalsIgnoreCase(CommandKeywords.ADD_GROUP)){
            return true;
        }
        return false;
    }

    @Override
    public void execute(String input) {
        List<String> inpWords = Arrays.stream(input.split(" ")).toList();
        String userIdInp = inpWords.get(0);
        Long userId = Long.parseLong(userIdInp);
        String groupName = inpWords.get(2);
        AddGroupRequestDto request = new AddGroupRequestDto();
        request.setGroupName(groupName);
        request.setUserId(userId);
        groupController.addGroup(request);
    }
}
