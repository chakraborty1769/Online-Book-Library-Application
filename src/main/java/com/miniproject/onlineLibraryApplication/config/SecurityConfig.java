package com.miniproject.onlineLibraryApplication.config;

import com.miniproject.onlineLibraryApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserRepository userRepository;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/register")
                .permitAll()
                .requestMatchers("/user/login")
                .permitAll()
//                .requestMatchers("/books/**")
//                .permitAll()
                .requestMatchers("/books/create").hasAuthority("ADMIN")
                .requestMatchers("/books/update/{bookID}").hasAuthority("ADMIN")
                .requestMatchers("/books/delete/{bookID}").hasAuthority("ADMIN")
                .requestMatchers("/books/all").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers("/books/id/{bookID}").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers("/books/author/{authorName}").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers("/books/author/{authorName}/{bookName}").hasAnyAuthority("ADMIN", "USER")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return http.build();
    }
}
