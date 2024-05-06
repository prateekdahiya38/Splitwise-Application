package com.project.splitwise.controllers;

import com.project.splitwise.dtos.requestDtos.AddGroupRequestDto;
import com.project.splitwise.dtos.responseDtos.AddGroupResponseDto;
import com.project.splitwise.exceptions.GroupAlreadyExistException;
import com.project.splitwise.exceptions.UserNotFoundException;
import com.project.splitwise.models.Group;
import com.project.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class GroupController {
    private GroupService groupService;


    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }




    public AddGroupResponseDto addGroup(AddGroupRequestDto request){
        Group group;
        AddGroupResponseDto response = new AddGroupResponseDto();
        try{
            group = groupService.addGroup(request.getGroupName(), request.getUserId());
            response.setGroupId(group.getId());
            response.setStatus("SUCCESS");
        }catch (Exception e){
            response.setStatus("FAILURE");
            response.setMessage("Something Went Wrong");
        }
        return response;
    }
}
