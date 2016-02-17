package com.tothenew.intellimeet;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/app/**", "/json/**", "/css/**", "/js/**", "/images/**").permitAll()
                .antMatchers("/intellimeet/lastIntellimeet").permitAll()
                .antMatchers("/schedule/fullDaySchedule").permitAll();

        http
                .authorizeRequests().anyRequest().authenticated();
        http
                .formLogin()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/admin")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .csrf();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("mohd.amir@tothenew.com").password("igdefault").roles("USER");
        auth.jdbcAuthentication();
    }
}
