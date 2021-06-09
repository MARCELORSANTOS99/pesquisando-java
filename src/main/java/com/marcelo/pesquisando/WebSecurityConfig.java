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
        	.antMatchers(HttpMethod.GET, "/perguntas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/cidades/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/perguntas/apuracao/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/perguntas/apuracao/*/*/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/perguntas/apuracao/tipo/*/*/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/perguntas/apuracao/bairro/*/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/gerente/firebase/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/gerente/firebase/totalPesquisas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, "/perguntas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, "/pesquisas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, "/pesquisas/bairro/*")
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, "/pesquisas/dissertativa/*")
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, "/respostas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.PUT, "/cidades/*")
        	.permitAll()
        	.antMatchers(HttpMethod.POST, "/respostas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.DELETE, "/respostas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.DELETE, "/cidades/*")
        	.permitAll()
        	.antMatchers(HttpMethod.DELETE, "/perguntas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.POST, "/perguntas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.POST, "/cidades/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/cidades/")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/pesquisas/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/pesquisas/*/*")
        	.permitAll()
        	.antMatchers(HttpMethod.GET, "/pesquisas/cidade/*")
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
