package org.valenti.authmanagement.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.valenti.authmanagement.dto.UserSignupDTO;

/*
    Il microservizio
 */

@Controller
@RequestMapping(path="/")
public class AuthController {

    RestTemplate restTemplate;

    public AuthController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //GET http:localhost:8080/auth/hello
    @GetMapping(path = "auth/hello")
    public @ResponseBody String hello() {
        return "Hello from the auth service!";
    }

    //POST http://localhost:8080/user/auth/signup
    @PostMapping(path="/auth/signup")
    public @ResponseBody String signup(@RequestBody UserSignupDTO newUser) {
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/user/auth/signup", HttpMethod.POST, new HttpEntity<>(newUser), String.class);
        return response.getBody();
    }

    
}
