package com.project.splitwise.services;

import com.project.splitwise.exceptions.UserAlreadyExistException;
import com.project.splitwise.exceptions.WrongUserIdInputException;
import com.project.splitwise.models.User;
import com.project.splitwise.models.UserStatus;
import com.project.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User registerUser(String userName, String password, String phoneNo) throws UserAlreadyExistException {
        Optional<User> userOptional = userRepository.findByPhoneNo(phoneNo);
        if (userOptional.isPresent()){
            if (userOptional.get().getUserStatus().equals(UserStatus.ACTIVE)){
                throw new UserAlreadyExistException();
            }else {
                User user = userOptional.get();
                user.setUserStatus(UserStatus.ACTIVE);
                user.setName(userName);
                user.setPhoneNo(phoneNo);
                user.setPassword(password);
                return userRepository.save(user);
            }
        }
        User user = new User();
        user.setName(userName);
        user.setPhoneNo(phoneNo);
        user.setPassword(password);
        user.setUserStatus(UserStatus.ACTIVE);
        return userRepository.save(user);
    }

    public User updateUserProfile(Long userId,String password) throws WrongUserIdInputException {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()){
            throw new WrongUserIdInputException();
        }
            User user = userOptional.get();
            user.setPassword(password);
            userRepository.save(user);
            return user;
    }

}
