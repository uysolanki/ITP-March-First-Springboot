package com.itp.ITPMarchFirstSpringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyWebSecurity extends WebSecurityConfigurerAdapter
{

	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication()
			.withUser("rohit")
			.password("rohit123")		// cleartext
	  		.authorities("ADMIN")
	  		.and()
	  		.withUser("virat")
	  		.password("virat123")		// cleartext
	  		.authorities("USER");

	}
	
	//Authorisation
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//        .anyRequest().authenticated()
//        .and()        
//        .formLogin().loginProcessingUrl("/login").successForwardUrl("/allProducts").permitAll()
//        .and()
//        .cors().and().csrf().disable();
		
		
        http.authorizeRequests()
        .antMatchers("/","/allProducts","/addProductForm","/403").hasAnyAuthority("USER","ADMIN")
        .antMatchers("/updateProductForm/**","/deleteProduct/**").hasAuthority("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login").successForwardUrl("/allProducts").permitAll()
        .and()
        .logout().logoutSuccessUrl("/login").permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/403")
        .and()
        .cors().and().csrf().disable();

	}
	
	@Bean
 	public PasswordEncoder getPasswordEncoder()
 	{
 		return NoOpPasswordEncoder.getInstance();
 	}

}
