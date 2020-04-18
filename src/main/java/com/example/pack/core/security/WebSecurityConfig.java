package com.example.pack.core.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Configuration
	@Order(1)
	public static class FormWebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/assets/**");
		}	
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			
			http.authorizeRequests()
				.antMatchers("/webjars/**", "/assets/**", "/enrollment/**", "/register/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
			.csrf()
				.disable();
		}
	}
}