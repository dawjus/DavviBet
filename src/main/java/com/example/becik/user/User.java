package com.example.becik.user;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @NonNull
    private String username;
    @NonNull
    private String password;
    private String address;
    private String phone;
    private double balance=0;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
    public User() {}

    public User(String username, String password, String address, String phone, Float balance){
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }

}
