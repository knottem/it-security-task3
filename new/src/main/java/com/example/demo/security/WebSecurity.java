package com.example.demo.security;

import com.example.demo.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Value("${spring.security.admin.name}")
    private String username;

    @Value("${spring.security.admin.password}")
    private String password;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    //Setting up security for the endpoints.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        //Setting roles for endpoints, nothing should be accessible without a role.
        //Order matters, the first match will be used.
        http.authorizeHttpRequests(r -> r
                .requestMatchers("/error").permitAll()
                .requestMatchers("/api/search/pii").hasRole("ADMIN")
                .requestMatchers("/api/courses").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/search/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/student/fullinfo").hasAnyRole("USER", "ADMIN")
                .requestMatchers("/api/**").hasRole("ADMIN"));

        //Setting up logger for unauthorized access attempts.
        http.exceptionHandling(e -> e
                .accessDeniedHandler(customAccessDeniedHandler())
        );

        //Using basic auth just for simplicity for the demo.
        http.httpBasic(withDefaults());

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);

        UserDetails admin = User.withUsername(username)
                .password(passwordEncoder.encode(password))
                .roles("ADMIN")
                .build();

        auth.inMemoryAuthentication().withUser(admin);
    }
}