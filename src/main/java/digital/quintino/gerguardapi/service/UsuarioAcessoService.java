package digital.quintino.gerguardapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import digital.quintino.gerguardapi.domain.UsuarioSistemaDomain;
import digital.quintino.gerguardapi.repository.UsuarioAcessoInterfaceRepository;

@Service
public class UsuarioAcessoService implements UserDetailsService {
	
	@Autowired
	private UsuarioAcessoInterfaceRepository usuarioAcessoInterfaceRepository;

	@Override
	public UserDetails loadUserByUsername(String identificador) throws UsernameNotFoundException {
		UsuarioSistemaDomain usuarioSistemaDomain = this.usuarioAcessoInterfaceRepository.findByIdentificador(identificador).orElseThrow(() -> new UsernameNotFoundException("Usuário Não Encontrado!"));
		return new User(usuarioSistemaDomain.getIdentificador(), usuarioSistemaDomain.getChave(), true, true, true, true, usuarioSistemaDomain.getAuthorities()); 
	}

}
