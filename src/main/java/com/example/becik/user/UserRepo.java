package com.example.becik.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    void deleteUserByUserName(String username);
    User findUserByUserName(String username);
}
