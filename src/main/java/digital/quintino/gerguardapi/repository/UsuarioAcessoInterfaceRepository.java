package digital.quintino.gerguardapi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digital.quintino.gerguardapi.domain.UsuarioAcessoDomain;

@Repository
public interface UsuarioAcessoInterfaceRepository extends JpaRepository<UsuarioAcessoDomain, UUID> { 
	Optional<UsuarioAcessoDomain> findByIdentificador(String identificador);
}
