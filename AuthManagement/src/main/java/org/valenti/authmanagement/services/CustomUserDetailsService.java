package org.valenti.authmanagement.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;
import org.valenti.authmanagement.dto.LoginDTO;

import java.util.Map;

public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<LoginDTO> userToLogCredentials = restTemplate.exchange("http://localhost:8080/user/credentials/{username}", HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), LoginDTO.class, Map.of("username", username));

        if(!userToLogCredentials.getStatusCode().is2xxSuccessful()) {
            throw new UsernameNotFoundException("Wrong credentials. Retry");
        }

        return User.withUsername(username).password(userToLogCredentials.getBody().getPassword()).roles("USER").build();
    }
}