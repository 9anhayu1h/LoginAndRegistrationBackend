package com.example.Authentication.Login;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/login")
@CrossOrigin
public class LoginController {

    private LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginRequest request) { return loginService.login(request); }

}
