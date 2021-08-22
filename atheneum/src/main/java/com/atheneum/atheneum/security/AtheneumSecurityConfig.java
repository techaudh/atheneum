package com.atheneum.atheneum.security;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class AtheneumSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
                .antMatchers("/registerReader");
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
        	.passwordEncoder(new BCryptPasswordEncoder())
        	.dataSource(dataSource);
        	//.usersByUsernameQuery("SELECT email, password, enabled FROM users WHERE email = ?")
        	//.authoritiesByUsernameQuery("SELECT email, role FROM users WHERE email = ?");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.httpBasic()
		.and()
        .authorizeRequests()
        	.antMatchers("/books/searchBooks").permitAll()
        	.antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
        	.antMatchers(HttpMethod.POST, "/books/issue").hasRole("READER")
        	.antMatchers(HttpMethod.GET, "/books/mergeBookAuthor").hasRole("ADMIN")
        	//.antMatchers("/reader/**").hasRole("READER")
          	//.antMatchers("/authors").hasRole("USER")
            .anyRequest().authenticated()
            .and()
            .logout(logout -> logout
            		.logoutSuccessHandler((request, response, authentication) -> {
            			response.setStatus(HttpServletResponse.SC_OK);
            		}))
            .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	}
}