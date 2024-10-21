package com.wallet.controller;

import com.wallet.model.LoginResponse;
import com.wallet.model.User;
import com.wallet.model.UserLogin;
import com.wallet.model.userConvert;
import com.wallet.service.AuthenticationService;
import com.wallet.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private  JwtService jwtService;
    @Autowired
    private  AuthenticationService authenticationService;

    @PostMapping("/registeruser")
    public ResponseEntity<User> register(@RequestBody userConvert input) {
        User registeredUser = authenticationService.signup(input);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody UserLogin input) {
        User authenticatedUser = authenticationService.authenticate(input);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }
}
