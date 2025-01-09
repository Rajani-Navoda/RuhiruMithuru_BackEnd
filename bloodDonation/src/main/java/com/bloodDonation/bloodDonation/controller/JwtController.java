package com.bloodDonation.bloodDonation.controller;

import com.bloodDonation.bloodDonation.entity.JwtRequest;
import com.bloodDonation.bloodDonation.entity.JwtResponse;
import com.bloodDonation.bloodDonation.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
       return jwtService.createJwtToken(jwtRequest);
    }
}
