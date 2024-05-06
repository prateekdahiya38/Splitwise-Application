package com.project.splitwise.repositories;

import com.project.splitwise.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findById(Long id);
    Optional<User> findByPhoneNo(String phoneNo);
    User save(User user);

   // void update(User user);
}
