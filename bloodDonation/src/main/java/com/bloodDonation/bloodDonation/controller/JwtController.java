package com.bloodDonation.bloodDonation.controller;

import com.bloodDonation.bloodDonation.entity.JwtRequest;
import com.bloodDonation.bloodDonation.entity.JwtResponse;
import com.bloodDonation.bloodDonation.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200",
        allowedHeaders = {"Authorization", "Content-Type"},
        exposedHeaders = "Authorization",
        methods = {RequestMethod.POST})
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
       return jwtService.createJwtToken(jwtRequest);
    }
}
