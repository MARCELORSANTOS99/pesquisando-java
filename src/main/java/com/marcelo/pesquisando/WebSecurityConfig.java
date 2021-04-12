package com.marcelo.pesquisando;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		.authorizeRequests()
        	.antMatchers(HttpMethod.GET, "/perguntas/")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/cidades/")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/respostas/")
        	.permitAll()
        	.antMatchers(HttpMethod.POST, "/pesquisas/")
        	.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin(form -> form
	            .loginPage("/login")
	            .permitAll()
	        );
	}
	
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


}
