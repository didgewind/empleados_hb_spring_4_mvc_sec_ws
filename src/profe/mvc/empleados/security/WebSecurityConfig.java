package profe.mvc.empleados.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
			.withUser("profe").password("profe").roles("USER")
			.and()
			.withUser("admin").password("admin").roles("USER", "ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/gestEmpleados.do").authenticated()
				.antMatchers("/gestEmpleados/*.do").authenticated()
//				.anyRequest().authenticated()
				.and()
			.formLogin()
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