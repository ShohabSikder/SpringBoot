package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.repository.IUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    //ইউজার সার্ভিসকে ইমপ্লিমেন্ট করলাম ইউজার ডিটেইলস এ। কারন সিকিউরিটি পারপাস। সরাসরি যাতে ইউজার সার্ভিসে যেতে না পারে
    private IUserRepository userRepo;

    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    //এইটা সাধারনত ইমেইল ইউনিক চেক করার জন্য এই মেথড। তবে মডেল ক্লাসে আমি যদি ইউনিক করে দেই তাহলে এইটা আর লাগবে না।
    public boolean isEmailUnique(String email) {
        com.shohab.SpringBootProject.model.User userEmail = userRepo.findByEmail(email);
        return userEmail == null;
    }



    @Override
    // আমার সিস্টেমে এই ইউসার আছে কিনা সেটা চেক করবে। তার জন্য এই মেথড।
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.shohab.SpringBootProject.model.User user=userRepo.findByEmail(username);

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(role -> role.getName()).toArray(String[]::new))
                .build();
    }
}
