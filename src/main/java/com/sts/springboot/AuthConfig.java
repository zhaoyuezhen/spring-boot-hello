package com.sts.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sts.springboot.service.AuthUserService;

@Configuration
@EnableWebSecurity
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		.antMatchers("/css/**","/staic/**", "/js/**","/images/**").permitAll()
		.antMatchers("/", "/login","/session_expired").permitAll()
           .and()
     .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/main_menu")
        .failureUrl("/loginError")
		.usernameParameter("txtUserCd")
		.passwordParameter("txtUserPwd")
        .permitAll()
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)
		.permitAll()
		.and()
		.sessionManagement()
		.invalidSessionUrl("/session_expired")
		.maximumSessions(1)
		.maxSessionsPreventsLogin(true)
		.expiredUrl("/session_expired");
		httpSecurity.logout().permitAll();

	}
	
	 @Autowired
	 AuthUserService authUserService;
	public void globalAuthConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authUserService);
      //auth.inMemoryAuthentication().withUser("user").password("password");
	}
	/*@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
	    @Autowired
	    AuthUserService authUserService;
	
	    @Override
	    public void init(AuthenticationManagerBuilder auth) throws Exception {
	    	//auth.inMemoryAuthentication().withUser("user").password("password");
	        auth.userDetailsService(authUserService);
	    }
	}*/
}
