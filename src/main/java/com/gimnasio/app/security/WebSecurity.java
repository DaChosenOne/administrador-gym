package com.gimnasio.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorizeRequests()
		http.authorizeRequests().antMatchers("/login").permitAll().antMatchers("/**")
				.hasAnyAuthority("ADMIN_ROLE", "USER_ROLE")
				// .hasAnyRole("ADMIN_ROLE", "USER_ROLE")
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
				.invalidateHttpSession(true).permitAll()
				/*
				 * .and() .formLogin() .loginPage("/login") .defaultSuccessUrl("/home")
				 * .failureUrl("/login?error=true") .permitAll() .and() .logout()
				 * .logoutSuccessUrl("/login?logout=true") .invalidateHttpSession(true)
				 * .permitAll()
				 */
				.and().csrf().disable();
	}

	@Override
	public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)
			throws Exception {
		web.ignoring().antMatchers("/plugins/**", "/css/**", "/js/**", "/bootstrap/**"); // #3
	}

}
