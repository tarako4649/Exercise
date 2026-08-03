// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
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
// public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//     UserDetails user = User.withUsername("admin")
//             .password(passwordEncoder.encode("password"))
//             .roles("USER")
//             .build();
//     return new InMemoryUserDetailsManager(user);
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }
// }

package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                http
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/admin/login").permitAll() // GET /admin/login
                                                .requestMatchers("/admin/login/**").permitAll() // POST /admin/login
                                                .requestMatchers("/admin/**").authenticated())
                                .formLogin(form -> form
                                                .loginPage("/admin/login")
                                                .loginProcessingUrl("/admin/login")
                                                .defaultSuccessUrl("/admin", true)
                                                .permitAll())

                                .logout(logout -> logout
                                                .logoutUrl("/admin/logout")
                                                .logoutSuccessUrl("/admin/login?logout")
                                                .permitAll())
                                .csrf(csrf -> csrf.disable());

                return http.build();
        }

        @Bean
        public UserDetailsService userDetailsService(DataSource dataSource) {
                JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

                manager.setUsersByUsernameQuery(
                                "SELECT name, password, TRUE as enabled FROM employee_account WHERE name = ?");

                manager.setAuthoritiesByUsernameQuery(
                                "SELECT name, 'ROLE_USER' as authority FROM employee_account WHERE name = ?");

                return manager;
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
// Exception {
// http
// .authorizeHttpRequests(auth -> auth
// .requestMatchers("/", "/register", "/login", "/css/**", "/js/**")
// .permitAll()
// .requestMatchers("/admin/**").authenticated() // ← admin 配下は全部認証必須
// .anyRequest().authenticated())
// .formLogin(form -> form
// .loginPage("/login") // ← ログインページは /login に固定
// .defaultSuccessUrl("/admin") // ← ログイン後は /admin に戻る
// .permitAll())
// .logout(logout -> logout
// .logoutUrl("/logout")
// .logoutSuccessUrl("/login?logout")
// .permitAll())
// .csrf(csrf -> csrf.disable());

// return http.build();
// }

// @Bean
// public UserDetailsService userDetailsService(DataSource dataSource) {
// JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);

// manager.setUsersByUsernameQuery(
// "SELECT name, password, TRUE as enabled FROM employee_account WHERE name =
// ?");

// manager.setAuthoritiesByUsernameQuery(
// "SELECT name, 'ROLE_USER' as authority FROM employee_account WHERE name =
// ?");

// return manager;
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }
// }