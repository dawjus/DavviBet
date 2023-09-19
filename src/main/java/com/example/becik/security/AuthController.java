package com.example.becik.security;

import com.example.becik.user.User;
import com.example.becik.user.UserRepo;
import com.example.becik.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Security;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepo userRepo,PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User signed in", HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        //user.setPassword(registerRequest.getPassword());
        user.setBalance(0.0f);
        System.out.println(user.getUsername() + "|" + user.getPassword() );
        System.out.println(registerRequest.getUsername() + "{}" + registerRequest.getPassword() );
        userRepo.save(user);
        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
/*
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByUsername(loginRequest.getUsername());

        // Sprawdź, czy użytkownik istnieje i hasło jest zgodne
        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            // Jeśli uwierzytelnienie powiedzie się, zapisz informację o zalogowanym użytkowniku w sesji
            session.setAttribute("loggedInUser", user);

            // Możesz również zwrócić odpowiedź HTTP o sukcesie
            return ResponseEntity.ok("Zalogowano pomyślnie.");
        } else {
            // Jeśli uwierzytelnienie nie powiedzie się, zwróć odpowiedź HTTP o błędzie
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Błąd uwierzytelniania.");
        }
    }
*/
}

