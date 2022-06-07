package ru.netology.b9l4t1;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class BaseSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Vasya").password("{noop}1234").roles("READ");
        auth.inMemoryAuthentication().withUser("Alexey").password("{noop}123").roles("READ", "WRITE");
        auth.inMemoryAuthentication().withUser("Ilya").password("{noop}234").roles("DELETE");
    }
}
