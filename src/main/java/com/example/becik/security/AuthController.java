package com.example.becik.security;

import com.example.becik.user.User;
import com.example.becik.user.UserRepo;
import com.example.becik.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepo userRepo,PasswordEncoder passwordEncoder) {
        //this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
//        if (userRepo.findUserByUserName(registerDto.getUsername())) {
//            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
//        }

        User user = new User();
        user.setUserName(registerDto.getUserName());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));
        user.setBalance(0.0f);
        //Role roles = roleRepository.findByName("USER").get();
        //user.setRoles(Collections.singletonList(roles));
        System.out.println(user.getUserName() + "|" + user.getPassword() );
        System.out.println(registerDto.getUserName() + "{}" + registerDto.getPassword() );
        //userService.addUser(user);
        userRepo.save(user);
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }

}

