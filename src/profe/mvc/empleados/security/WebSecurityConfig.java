package profe.mvc.empleados.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user").password("user").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("paso por websecurityconfig configure");
		http
			.authorizeRequests()
				.antMatchers("/gestEmpleados.do").authenticated()
				.antMatchers("/gestEmpleados/*.do").authenticated()
//				.anyRequest().authenticated()
				.and()
			.formLogin()
				.and()
			.httpBasic()
				.and()
			.logout().logoutSuccessUrl("/index.html")
			/* Este código está para poder hacer logout sin necesidad de
			 * deshabilitar csrf con .csrf().disable()
			 */
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true);
    }
}