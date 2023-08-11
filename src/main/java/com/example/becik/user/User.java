package com.example.becik.user;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private String address;
    private String phone;
    private double balance=0;



//    public User(Builder builder){
//        name = builder.name;
//        surname = builder.surname;
//        address = builder.address;
//        phone = builder.phone;
//        balance = builder.balance;
//    }

    public User() {}

    public User(String userName, String password, String surname, String address, String phone, Float balance){
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }

}
