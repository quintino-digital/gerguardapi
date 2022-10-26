package digital.quintino.gerguardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digital.quintino.gerguardapi.domain.AcessoDomain;

@Repository
public interface AcessoInterfaceRepository extends JpaRepository<AcessoDomain, Long> { }
