package com.shohab.SpringBootProject.service;

import com.shohab.SpringBootProject.model.Attendance;
import com.shohab.SpringBootProject.model.User;
import com.shohab.SpringBootProject.repository.AttendanceRepo;
import com.shohab.SpringBootProject.repository.IUserRepository;
import com.shohab.SpringBootProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
//    @Autowired
//    private UserRepo userRepo1;

    @Autowired
    private AttendanceRepo attendanceRepo;

    private IUserRepository userRepo;

    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean isEmailUnique(String email){
        com.shohab.SpringBootProject.model.User userEmail= userRepo.findByEmail(email);
        return  userEmail==null;
    }


    public void saveUserAndAttendance() {
        // create or retrieve the user
        User user = new User();
        userRepo.save(user);

        // create or retrieve the attendance
        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendanceRepo.save(attendance);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.shohab.SpringBootProject.model.User user= userRepo.findByEmail(username);

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles().stream().map(role->role.getName()).toArray(String[]::new))
                .build();

    }
}
