package com.example.becik.user;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping("/find/{userName}")
    public ResponseEntity<User> getUserById(@PathVariable("userName") String userName){
        User user = userService.findByUsername(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/payment/{userName}")
    public ResponseEntity<String> rechargeAccount(@PathVariable("userName") String userName, @RequestParam double amount) {
        User user = userService.findByUsername(userName);
        user.setBalance(user.getBalance()+amount);
        userService.updateUser(user);
        return ResponseEntity.ok("Account recharged successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
