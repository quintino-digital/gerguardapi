package digital.quintino.gerguardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digital.quintino.gerguardapi.domain.CategoriaAcessoDomain;

@Repository
public interface CategoriaAcessoInterfaceRepository extends JpaRepository<CategoriaAcessoDomain, Long> { }
