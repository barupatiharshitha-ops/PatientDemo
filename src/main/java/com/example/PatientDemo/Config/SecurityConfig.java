//package com.example.PatientDemo.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain defaultsecurityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/patients/getdata", "/patients/byid/**", "/patients/name/**").authenticated()
//                        .requestMatchers("/patients/postdata").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .oauth2Login(Customizer.withDefaults())  // Enables Google OAuth2 login
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                        .permitAll()
//                );
//
//
//
//
//        return http.build();
//    }
//}


//
//
//
//package com.example.PatientDemo.Config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable) // disable CSRF for Postman testing
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll()  // allow all endpoints
//                );
//
//        return http.build();
//    }
//}

