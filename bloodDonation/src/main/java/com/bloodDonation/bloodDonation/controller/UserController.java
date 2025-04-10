package com.bloodDonation.bloodDonation.controller;

import com.bloodDonation.bloodDonation.entity.User;
import com.bloodDonation.bloodDonation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        if (user.getUserType() == null) {
            throw new IllegalArgumentException("User type is required");
        }
      return userService.registerNewUser(user);
    }

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }
    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('ADMIN')")
    public String forAdmin(){
        return "This URL only accessible to Admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('USER')")
    public String forUser(){
        return "This URL only accessible to user";
    }

    @GetMapping({"/forOrganizer"})
    @PreAuthorize("hasRole('ORGANIZER')")
    public String forOrganizer(){
        return "This URL only accessible to Organizer";
    }

    @GetMapping({"/forBloodBank"})
    @PreAuthorize("hasRole('BLOOD_BANK')")
    public String forBloodBank(){
        return "This URL only accessible to BloodBank";
    }
}
