package com.example.Authentication.Login;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    public String email;
    public String password;
}