package com.project.splitwise.services;

import com.project.splitwise.exceptions.GroupAlreadyExistException;
import com.project.splitwise.exceptions.UserNotFoundException;
import com.project.splitwise.models.Group;
import com.project.splitwise.models.User;
import com.project.splitwise.repositories.GroupRepository;
import com.project.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository,
                        UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;

    }



    public Group addGroup(String groupName, Long userId) throws GroupAlreadyExistException, UserNotFoundException {
        Optional<Group> groupOptional = groupRepository.findByName(groupName);
        if (groupOptional.isPresent()){
            throw new GroupAlreadyExistException();
        }
        Group group = new Group();
        group.setName(groupName);
        group.setDescription(groupName + " group is created");

        User user;
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new UserNotFoundException();
        }
        user = userOptional.get();
        group.setMembers(new ArrayList<>(List.of(user)));
        group.setCreatedBy(user);
        return groupRepository.save(group);
    }
}
