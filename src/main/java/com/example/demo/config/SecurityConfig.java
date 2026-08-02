// package com.example.demo.config;

// import javax.sql.DataSource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http
// .authorizeHttpRequests(auth -> auth
// .requestMatchers("/public/**").permitAll()
// .requestMatchers("/", "/login").permitAll()
// .requestMatchers("/menu", "/logout").authenticated()
// .anyRequest().authenticated())
// .formLogin(login -> login
// .loginProcessingUrl("/authenticate")
// .loginPage("/login")
// .defaultSuccessUrl("/menu")
// .failureUrl("/login")
// .permitAll())
// .logout(logout -> logout
// .logoutUrl("/logout")
// .logoutSuccessUrl("/login")
// .invalidateHttpSession(true)
// .clearAuthentication(true)
// .deleteCookies("JSESSIONID"));

// return http.build();
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }
// }
