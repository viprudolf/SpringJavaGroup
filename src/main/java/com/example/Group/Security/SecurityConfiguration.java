package com.example.Group.Security;

import com.example.Group.Models.UserModel;
import com.example.Group.Repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            UserModel user = userRepository.findByUsername(username);
            if(user != null) return user;
            throw new UsernameNotFoundException("Пользователь " + username + "не найден!");
        };
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
        return http.authorizeHttpRequests(auth-> auth
                        .requestMatchers("/faculty/**", "/chair/**", "/actuator/**").authenticated()
                        .requestMatchers("/login/**", "/registration/**").anonymous()
                        .requestMatchers("/**").permitAll())
                .formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer.loginPage("/login"))
                .build();
    }
}
