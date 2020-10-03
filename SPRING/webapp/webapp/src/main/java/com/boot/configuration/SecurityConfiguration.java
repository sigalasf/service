package com.boot.configuration;

import org.jasypt.springsecurity4.crypto.password.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@Order(3)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/product/show/*", "/products")
				.hasAnyAuthority("USER","ADMIN")
				.antMatchers("/product/edit/*", "/product/delete/*").hasAuthority("ADMIN").anyRequest()
				.permitAll().and().formLogin().loginPage("/login").permitAll().and().logout().permitAll().and().csrf()
				.disable().headers().frameOptions().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder(StrongPasswordEncryptor strongPasswordEncryptor) {
		PasswordEncoder passwordEncoder = new PasswordEncoder();
		passwordEncoder.setPasswordEncryptor(strongPasswordEncryptor);
		return passwordEncoder;
	}

	 @Autowired
	  public void configureAuthManager(final AuthenticationManagerBuilder authenticationManagerBuilder, @Qualifier("daoAuthenticationProvider") AuthenticationProvider provider) {
		 authenticationManagerBuilder.authenticationProvider(provider);
	  }
	 
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}
}
