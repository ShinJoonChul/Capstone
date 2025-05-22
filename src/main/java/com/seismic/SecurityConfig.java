package com.seismic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .requestMatchers("/", "/index.html", "/static/**", "/css/**", "/js/**", "/images/**", "/**.html", "/**.css", "/**.js").permitAll()
                .anyRequest().permitAll() // 모든 요청 허용 (로그인 없이)
            )
            .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (테스트용)
            .formLogin(form -> form.disable()); // 기본 로그인 폼 비활성화

        return http.build();
    }
} 