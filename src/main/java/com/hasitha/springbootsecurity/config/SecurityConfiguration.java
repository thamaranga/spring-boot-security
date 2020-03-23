package com.hasitha.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    UserDetailsService userDetailsService;

    //This method is related to authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


      auth.userDetailsService(userDetailsService);


    }

    /*This means we are not using any password encorder. Which means here we are using passwords as plain text.
    This is not a good practice. But since this is a sample project I have done soo.*/

    @Bean
    public PasswordEncoder getPasswordEncorder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //This method is related to authorization
    /*Here when comparing below given roles with  roles in our DB,spring boot will automatically add ROLE_ prefix for
    * for below given roles. */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").
                                 antMatchers("/user").hasAnyRole("USER", "ADMIN").
                                 antMatchers("/").permitAll()
                                .and().formLogin();

    }
}
