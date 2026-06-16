package org.askiesolutions.recipeui.security;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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
                        .requestMatchers(HttpMethod.GET, "/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/recipes/css/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/recipes/js/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/recipes/images/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/recipes/favicon.ico").permitAll()
                        .requestMatchers("/actuator/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .build();
    }
}
