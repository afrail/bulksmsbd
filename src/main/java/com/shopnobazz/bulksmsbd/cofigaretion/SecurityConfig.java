package com.shopnobazz.bulksmsbd.cofigaretion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.shopnobazz.bulksmsbd.serviceImplement.UserSecurityService;
//import com.shopnobazz.bulksmsbd.utility.SecurityUtility;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
@Autowired
UserSecurityService userSecurityService;

//private BCryptPasswordEncoder passwordEncoder() {
//    return SecurityUtility.passwordEncoder();
//}


	 private static final String[] PUBLIC_MATCHERS = {
	            "/css/**",
	            "/js/**",
	            "/images/**",
	            "/dist/**",
	            "/pages/**",
	            "/plugins/**",
	            "/home/**",
	            "/newUser",
	            "/forgetPassword",
	            "/login",
	            "/hours",
	            "/faq",
	            "/register",
	            "/confirm-account",
	            "/registration",
	            "/main"
	            
	            
	            
	            
	    };
	@Override
    protected void configure(HttpSecurity http) throws Exception {
       
		  http
          .authorizeRequests()
          .antMatchers(PUBLIC_MATCHERS)
          .permitAll()
          .antMatchers("/newUser","/user/**").permitAll()
          .antMatchers("/forgetPassword").permitAll()
          
          .antMatchers("/home/**","/package/**").hasAuthority("ROLE_ADMIN")
          .antMatchers("/parches/**","/api/**").hasAuthority("ROLE_USER")
          .anyRequest()
          .authenticated();

  http
          .csrf().disable().cors().disable()
          
          .formLogin().failureUrl("/login?error")
          .loginPage("/login").permitAll()
          .defaultSuccessUrl("/")
          .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .logoutSuccessUrl("/login?logout").deleteCookies("remember-me").permitAll()
          .and()
          .rememberMe();
                
    }
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService);
    }
}
