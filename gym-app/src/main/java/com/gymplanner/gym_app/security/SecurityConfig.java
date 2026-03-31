package com.gymplanner.gym_app.security;

import com.gymplanner.gym_app.security.jwt.JwtAuthenticationFilter;
import com.gymplanner.gym_app.security.jwt.JwtProperties;
import com.gymplanner.gym_app.security.jwt.JwtService;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class SecurityConfig {

    @Bean
    public JwtService jwtService(JwtProperties props) {
        return new JwtService(props);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtService jwtService) {
        return new JwtAuthenticationFilter(jwtService);
    }

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            JwtAuthenticationFilter jwtFilter
    ) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/users/register",
                    "/users/login",
                    "/users/confirm",
                    "/h2-console/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(
                jwtFilter,
                org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class
            )
            .headers(headers -> headers.frameOptions(frame -> frame.disable())); // H2

        return http.build();
    }
}