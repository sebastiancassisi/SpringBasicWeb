package ar.com.springbasicweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
        
        @Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		// Obtengo los datos del formulario de login
		String principal = authentication.getName();//nombre de usuario
		String credentials = (String) authentication.getCredentials();//contraseña
		
                //Consulto en la base de datos si extiste el susuario antes asignado a "principal".
		User user = (User) customUserDetailsService.loadUserByUsername(principal);
		
		if (user != null) {
			// Comprobar contraseña
			if (passwordEncoder.matches(credentials, user.getPassword())) {
				System.out.println("Login correcto");
				return new UsernamePasswordAuthenticationToken(principal, user.getPassword(), user.getAuthorities());
			}
			else{
				System.out.println("Error de login: " + principal);
				throw new BadCredentialsException("Error de login");
			}
		} 
		else {
			System.out.println("Error de login: " + principal);
			throw new BadCredentialsException("Error de login");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}

