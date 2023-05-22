package com.rentmyboat.rentmyboat.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // TODO тут основные настройки авторизации и аутентификации
    //  не забудь про SuccessUserHandler, PasswordEncoder и .csrf()

}