package digital.quintino.gerguardapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import digital.quintino.gerguardapi.enumeration.TipoPerfilUsuarioSistemaEnumeration;
import digital.quintino.gerguardapi.service.UsuarioService;

@SuppressWarnings("deprecation")
//@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsuarioService usuarioAcessoService;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.httpBasic().and().authorizeHttpRequests()
//			.antMatchers(HttpMethod.GET, "/v1/acesso/**").permitAll()
			.antMatchers(HttpMethod.GET, "/v1/acesso/").hasRole(TipoPerfilUsuarioSistemaEnumeration.ROLE_USER.getPerfilSimplificado())
			.antMatchers(HttpMethod.POST, "/v1/acesso/").hasRole(TipoPerfilUsuarioSistemaEnumeration.ROLE_USER.getPerfilSimplificado())
			.antMatchers(HttpMethod.DELETE, "/v1/acesso/").hasRole(TipoPerfilUsuarioSistemaEnumeration.ROLE_ADMIN.getPerfilSimplificado())
			.anyRequest().authenticated().and().csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(this.usuarioAcessoService).passwordEncoder(this.passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
