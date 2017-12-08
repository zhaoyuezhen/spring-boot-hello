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
		httpSecurity
		   .authorizeRequests()
           .anyRequest().authenticated()
           .and()
     .formLogin()
           .loginPage( "/login")// 1
           .permitAll();      //  2
		/*httpSecurity.authorizeRequests()
				.antMatchers("/login","/webjars/**","/css/**", "/js/**", "/images/**").permitAll()
				.antMatchers("/", "/login", "/pwd_change", "/login/getUsrName","/session_expired").permitAll()
				.anyRequest().authenticated();
	
		httpSecurity.formLogin()
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
		httpSecurity.logout().permitAll();*/

	}
	
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
	    @Autowired
	    AuthUserService authUserService;
	
	    @Override
	    public void init(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(authUserService);
	    }
	}

}
