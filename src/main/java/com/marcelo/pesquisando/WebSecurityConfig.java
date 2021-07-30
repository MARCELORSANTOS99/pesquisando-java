package com.marcelo.pesquisando;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	
		http.authorizeRequests()
		//.antMatchers(HttpMethod.POST, "/users").permitAll()
			.anyRequest().authenticated()
		.and().
			httpBasic()
		.and()
			.csrf().disable();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
		
	    auth.userDetailsService(userDetailsService()).passwordEncoder(encoder);
		
		
	    UserDetails user =
				 User.builder()
					.username("marcelo")
					.password(encoder.encode("987654"))
					.roles("ADM")
					.build();
		
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder)
		.withUser(user);
		

	}
	
	/*
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("ADM")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	*/


}
