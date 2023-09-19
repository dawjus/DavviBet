package com.example.becik.security;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequest {

    private String username;
    private String password;
}
