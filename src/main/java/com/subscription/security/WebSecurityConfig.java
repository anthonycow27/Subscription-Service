package com.subscription.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.subscription.service.UserService;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@EnableWebSecurity
//@EnableWebMvc
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

//	@Autowired
//	private UserService userService;
	
//	  @Override
//	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry
//	          .addResourceHandler("/webjars/**")
//	          .addResourceLocations("/webjars/");
//	    }
	
	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username as principal, password as credentials, true from users where username=?")
		.authoritiesByUsernameQuery(" SELECT users.username as principal, roles.name as role FROM users INNER JOIN users_and_roles ON users.user_id = users_and_roles.users_id INNER JOIN roles ON users_and_roles.roles_id = roles.role_id WHERE users.username = ?")
		.passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");  

	}

	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/register","/", "/login", "/css/**", "/webjars/**").permitAll()
		.antMatchers("/familyMembers/","/premium").hasAnyRole("USER, ADMIN")
		.antMatchers("/users").hasRole("ADMIN")
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/familyMembers").and().logout().logoutSuccessUrl("/login");

	}

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	

//	  @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.authenticationProvider(authenticationProvider());
//	    }
//
//	    @Bean
//	    public DaoAuthenticationProvider authenticationProvider(){
//	        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//	        auth.setUserDetailsService(userService);
//	        auth.setPasswordEncoder(passwordEncoder());
//	        return auth;
//	    }
}