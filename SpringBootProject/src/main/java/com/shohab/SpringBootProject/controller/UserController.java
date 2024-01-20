package com.shohab.SpringBootProject.controller;

import com.shohab.SpringBootProject.model.Role;
import com.shohab.SpringBootProject.model.User;
import com.shohab.SpringBootProject.repository.IRoleRepo;
import com.shohab.SpringBootProject.repository.IUserRepository;
import com.shohab.SpringBootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserRepository userRepo;
    @Autowired
    IRoleRepo roleRepo;

    @Autowired
    private UserService userService;
    @GetMapping("")
    public String viewAllUser(Model m){
        List<User> userList= userRepo.findAll();
        m.addAttribute("userList", userList);

        return "alluser";
    }
    @RequestMapping("/saveform")
    public String userSaveForm(Model m){
        m.addAttribute("user", new User());
        return  "saveuserform";
    }

    @PostMapping(value = "/save")
    public  String userSave(@ModelAttribute User user){

        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole=new Role(1);
        user.addRole(userRole);
        userRepo.save(user);
        return "redirect:/user";
    }
}
