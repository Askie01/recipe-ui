package org.askiesolutions.recipeui.security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityFilterChainConfiguration {

    @Bean
    @SneakyThrows
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
        return http
                .formLogin(configuration -> configuration
                        .defaultSuccessUrl("/", true))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/recipes/css/**").permitAll()
                        .requestMatchers("/recipes/js/**").permitAll()
                        .requestMatchers("/recipes/images/**").permitAll()
                        .requestMatchers("/recipes/favicon.ico").permitAll()
                        .requestMatchers("/recipes/actuator/**").permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }
}
