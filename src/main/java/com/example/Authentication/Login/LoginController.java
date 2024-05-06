package com.example.Authentication.Login;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/login")
@CrossOrigin
@AllArgsConstructor
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginRequest request) { return loginService.login(request); }

}
