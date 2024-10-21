package com.wallet.service;


import com.wallet.model.User;
import com.wallet.model.UserLogin;
import com.wallet.repository.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepo userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepo userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(User input) {
        User user = new User();
        user.setPhoneNumber(input.getPhoneNumber());
        user.setEmailAddress(input.getEmailAddress());
        user.setBirthDate(input.getBirthDate());
        user.setGender(input.getGender());
        user.setMilitaryState(input.getMilitaryState());
        user.setPassword(input.getPassword());
        return userRepository.save(user);
    }

    public User authenticate(UserLogin input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmailAddress(input.getEmail());
    }

}
