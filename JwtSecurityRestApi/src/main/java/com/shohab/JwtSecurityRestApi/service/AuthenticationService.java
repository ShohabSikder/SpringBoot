package com.shohab.JwtSecurityRestApi.service;

import com.shohab.JwtSecurityRestApi.jwt.JwtService;
import com.shohab.JwtSecurityRestApi.model.AuthenticationResponse;
import com.shohab.JwtSecurityRestApi.model.Token;
import com.shohab.JwtSecurityRestApi.model.User;
import com.shohab.JwtSecurityRestApi.respository.TokenRepository;
import com.shohab.JwtSecurityRestApi.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenRepository tokenRepository,
                                 AuthenticationManager authenticationManager){
       this.userRepository=userRepository;
       this.passwordEncoder=passwordEncoder;
       this.jwtService=jwtService;
       this.tokenRepository=tokenRepository;
       this.authenticationManager=authenticationManager;
    }

    public AuthenticationResponse register(User request){
        if(userRepository.findByEmail(request.getUsername()).isPresent()){
            return new AuthenticationResponse(null,"user already exists");
        }
        User user=new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user=userRepository.save(user);

        String jwt= jwtService.generateToken(user);
        saveUserToken(jwt,user);
        return new AuthenticationResponse(jwt,"user log was successful");

    }
// Method to revoke all existing tokens for a user
    private void revokeAllTokenByUser(User user){
        List<Token>validTokens=tokenRepository.findAllTokensByUser(user.getId());
        if(validTokens.isEmpty()){
            return;
        }
        validTokens.forEach(t->{t.setLoggedOut(true);});
        tokenRepository.saveAll(validTokens);
    }


    private void saveUserToken(String jwt, User user){
        Token token=new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);

    }
}
