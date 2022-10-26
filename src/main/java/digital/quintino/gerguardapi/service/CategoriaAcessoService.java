package digital.quintino.gerguardapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digital.quintino.gerguardapi.domain.CategoriaAcessoDomain;
import digital.quintino.gerguardapi.dto.CategoriaAcessoRequestDTO;
import digital.quintino.gerguardapi.repository.CategoriaAcessoInterfaceRepository;

@Service
public class CategoriaAcessoService {
	
	@Autowired
	private CategoriaAcessoInterfaceRepository categoriaAcessoInterfaceRepository;
	
	@Transactional
	public CategoriaAcessoDomain saveOne(CategoriaAcessoRequestDTO categoriaAcessoRequestDTO) {
		CategoriaAcessoDomain categoriaAcessoDomain = new CategoriaAcessoDomain();
		BeanUtils.copyProperties(categoriaAcessoRequestDTO, categoriaAcessoDomain);
		return this.categoriaAcessoInterfaceRepository.save(categoriaAcessoDomain);
	}

	public List<CategoriaAcessoDomain> findAll() {
		return this.categoriaAcessoInterfaceRepository.findAll();
	}
	
	public Optional<CategoriaAcessoDomain> findOne(Long codigo) {
		return this.categoriaAcessoInterfaceRepository.findById(codigo);
	}

}
