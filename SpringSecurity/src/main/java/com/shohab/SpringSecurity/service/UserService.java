package com.shohab.SpringSecurity.service;

import com.shohab.SpringSecurity.model.User;
import com.shohab.SpringSecurity.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //This has came from repository
    @Autowired
     private IUser iUser;
    public boolean isEmailUnique(String email){
        User userEmail= iUser.getUserByEmail(email);
        return  userEmail==null;
    }

}
