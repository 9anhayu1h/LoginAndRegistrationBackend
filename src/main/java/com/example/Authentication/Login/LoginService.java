package com.example.Authentication.Login;

import com.example.Authentication.Registration.EmailValidator;
import com.example.Authentication.User.User;
import com.example.Authentication.User.UserRepository;
import com.example.Authentication.User.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@AllArgsConstructor
public class LoginService {

    private final UserService userService;
    private LoginRequest request;
    private final EmailValidator emailValidator;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String login(LoginRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        String encodedPassword =bCryptPasswordEncoder.encode(request.getPassword());
        request.setPassword(encodedPassword);

        userService.loginUser(request);

        return "login_success";
    }
}
