package com.example.becik.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    void deleteUserByUsername(String username);
    User findUserByUsername(String username);
}
