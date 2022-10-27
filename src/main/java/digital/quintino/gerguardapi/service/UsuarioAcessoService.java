package digital.quintino.gerguardapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import digital.quintino.gerguardapi.repository.UsuarioAcessoInterfaceRepository;

public class UsuarioAcessoService implements UserDetailsService {
	
	@Autowired
	private UsuarioAcessoInterfaceRepository usuarioAcessoInterfaceRepository;

	@Override
	public UserDetails loadUserByUsername(String identificador) throws UsernameNotFoundException {
		return this.usuarioAcessoInterfaceRepository
				.findByIdentificador(identificador).orElseThrow(() -> new UsernameNotFoundException("Usuário Não Encontrado!"));
	}

}
