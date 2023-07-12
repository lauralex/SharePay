package org.valenti.authmanagement.services;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.reactive.function.client.WebClient;
import org.valenti.authmanagement.dto.LoginDTO;
import reactor.core.publisher.Mono;

import java.util.Map;

public class CustomUserDetailsService implements ReactiveUserDetailsService {

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return WebClient.create().get().uri("http://localhost:8080/user/credentials/{username}", Map.of("username", username)).retrieve().toEntity(LoginDTO.class).flatMap(responseEntityLoginDTO -> {
            if (!responseEntityLoginDTO.getStatusCode().is2xxSuccessful()) {
                return Mono.empty();
            }
            return Mono.just(User.withUsername(username).password("{noop}" + responseEntityLoginDTO.getBody().getPassword()).roles("USER").build());
        });
    }
}