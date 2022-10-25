package digital.quintino.gerguardapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digital.quintino.gerguardapi.domain.AcessoDomain;
import digital.quintino.gerguardapi.dto.AcessoRequestDTO;
import digital.quintino.gerguardapi.repository.AcessoInterfaceRepository;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoInterfaceRepository acessoInterfaceRepository;
	
	@Transactional
	public AcessoDomain saveOne(AcessoRequestDTO acessoRequestDTO) {
		AcessoDomain acessoDomain = new AcessoDomain();
		BeanUtils.copyProperties(acessoRequestDTO, acessoDomain);
			acessoDomain.setChave(encriptarChaveAcesso(acessoRequestDTO.getChave()));
		return this.acessoInterfaceRepository.save(acessoDomain);
	}
	
	public void saveAll(List<AcessoRequestDTO> acessoRequestDTOList) {
		for(AcessoRequestDTO acessoRequestDTO : acessoRequestDTOList) {
			this.saveOne(acessoRequestDTO);
		}
	}

	public List<AcessoDomain> findAll() {
		return this.acessoInterfaceRepository.findAll();
	}
	
	@Transactional
	public AcessoDomain updateOne(Long codigo, AcessoRequestDTO acessoRequestDTO) {
		AcessoDomain acessoDomainCadastrada = this.findOne(codigo).get();
			BeanUtils.copyProperties(acessoRequestDTO, acessoDomainCadastrada);
			acessoDomainCadastrada.setCodigo(codigo);
		return this.acessoInterfaceRepository.save(acessoDomainCadastrada);
	}
	
	public Optional<AcessoDomain> findOne(Long codigo) {
		return this.acessoInterfaceRepository.findById(codigo);
	}
	
	@Transactional
	public void deleteOne(Long codigo) {
		this.acessoInterfaceRepository.deleteById(codigo);
	}
	
	private String encriptarChaveAcesso(String chave) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(chave);
	}

}
