package com.jvdkolk.wickettest.config;

import com.jvdkolk.entities.User;
import com.jvdkolk.services.SimpleUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SimpleSecurityConfig extends WebSecurityConfigurerAdapter {

    private final SimpleUserService simpleUserService;

    @Autowired
    public SimpleSecurityConfig(final SimpleUserService simpleUserService) {
        this.simpleUserService = simpleUserService;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable(); //todo usage in combination with wicket
        http
                .headers()
                .httpStrictTransportSecurity()
                .includeSubDomains(true).and()
                .xssProtection()
                .block(false).and()
                .frameOptions().sameOrigin().and()
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll();
    }

    /**
     * Simple authentication manager
     * Should be changed for usage in production
     * @return AuthenticationManager
     */
    @Bean
    public AuthenticationManager authenticationManager() {
        return authentication -> {
            Authentication result = null;
            final String username = authentication.getName();
            final String password = authentication.getCredentials().toString();


            if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
                final User user = simpleUserService.findUser(username)
                        .filter(foundUser -> BCrypt.checkpw(password, foundUser.getPassword()))
                        .orElse(null);

                if (user != null) {
                    result = new UsernamePasswordAuthenticationToken(user, user.getUsername(), Collections.singletonList(() -> "USER"));
                }
            }
            return result;
        };
    }

}
