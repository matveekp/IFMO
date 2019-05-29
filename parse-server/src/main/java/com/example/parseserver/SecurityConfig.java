package com.example.parseserver;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}12345678").roles("ADMIN")
                .and()
                .withUser("user").password("12345678").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // настраиваем каким ролям какие запросы могут быть доступны
        http.httpBasic()//ждем базовую авторизацию, что клинет пришлет логин и пароль
                .and()
                .authorizeRequests() // данные будут доступны только авторизованным пользователям
                .antMatchers(HttpMethod.GET, "/courses") //тип запроса и адрес
                .hasRole("ADMIN") //ответ на этот запрос будет доступен только пользователям с ролью АДМИН
//                .antMatchers(HttpMethod.POST, ...)
//                .hasRole...
                .and()
                .csrf().disable() // токены не будут использоваться
                .formLogin().disable();


    }
}
