package com.boot.ui.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfigureImpl  {
		
	@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("user")
	      .password(bCryptPasswordEncoder.encode("1234"))
	      .roles("USER")
	      .build());
	    manager.createUser(User.withUsername("admin")
	      .password(bCryptPasswordEncoder.encode("1234"))
	      .roles("USER", "ADMIN")
	      .build());
	    return manager;
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService(bCryptPasswordEncoder))
	      .passwordEncoder(bCryptPasswordEncoder)
	      .and()
	      .build();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf()
	      .disable()	      	      	     	      	      
	      .httpBasic()
	      .disable()
	      .formLogin()
	      .disable()
	      ;
	    http.authorizeHttpRequests()
	    .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico").permitAll();

	    return http.build();
	}	
}
