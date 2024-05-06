package com.example.Authentication.Login;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;


    public String login(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "User " + request.getEmail() + " logged in";
        } catch (BadCredentialsException e) {
            return "Invalid email or password";
        } catch (DisabledException e) {
            return "User account is disabled";
        } catch (AuthenticationException e) {
            return "Authentication failed: " + e.getMessage();
        }
    }
}
