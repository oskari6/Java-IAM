package com.example.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/index.html", "/login-no-oauth", "/static/**", "/css/**", "/js/**", "/images/**").permitAll() // Allow access to static resources
                .anyRequest().authenticated() // All other requests require authentication
            )
            .oauth2Login(oauth -> oauth
                .userInfoEndpoint(userInfo -> userInfo
                    .oidcUserService(this.oidcUserService())
                )
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/") // Redirect to home on logout
            );
        return http.build();
    }

    private OidcUserService oidcUserService() {
        return new OidcUserService();
    }
}
