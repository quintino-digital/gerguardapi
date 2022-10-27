package digital.quintino.gerguardapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digital.quintino.gerguardapi.domain.UsuarioSistemaDomain;

@Repository
public interface UsuarioAcessoInterfaceRepository extends JpaRepository<UsuarioSistemaDomain, UUID> { 
	Optional<UsuarioSistemaDomain> findByIdentificador(String identificador);
}
