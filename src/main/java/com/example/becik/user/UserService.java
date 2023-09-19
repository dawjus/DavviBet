package com.example.becik.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userrepo) {
        this.userRepo = userrepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findByUsername(String userName){
        return userRepo.findUserByUsername(userName);
    }

    public void deleteUser(String userName){
        userRepo.deleteUserByUsername(userName);
    }
}
