package org.valenti.authmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.valenti.authmanagement.services.CustomUserDetailsService;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfiguration {
    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    // Authenticate all requests except those to /signup
    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges.pathMatchers("/user/signup").permitAll().anyExchange().authenticated())
                .httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());
        return http.build();
    }

}
