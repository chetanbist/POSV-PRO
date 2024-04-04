package com.lcwd.electronic.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService serDetailsService()
    {
       UserDetails normal= User.builder()
                .username("Chetan")
               .password(passwordEncoder().encode("Intel"))
                .roles("NORMAL")
                .build();

        UserDetails admin= User.builder()
                .username("Durgesh")
                .password(passwordEncoder().encode("Intel1"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normal,admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
