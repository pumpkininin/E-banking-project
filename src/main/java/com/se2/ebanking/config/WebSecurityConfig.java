package com.se2.ebanking.config;

import com.se2.ebanking.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
//    @Autowired
//    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/", "/login","/index").permitAll();


        http.authorizeRequests().antMatchers("/customer/*").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");


        http.authorizeRequests().antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')");


        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/login-finish") // Submit URL
                .loginPage("/login-form")//
                .defaultSuccessUrl("/")//
                .failureUrl("/login-form")//
                .usernameParameter("phoneNumber")//
                .passwordParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");



        http.sessionManagement().maximumSessions(100000).expiredUrl("/login?expired=true");
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);


    }


}