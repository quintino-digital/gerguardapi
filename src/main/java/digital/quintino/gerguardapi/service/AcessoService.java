package digital.quintino.gerguardapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digital.quintino.gerguardapi.domain.AcessoDomain;
import digital.quintino.gerguardapi.repository.AcessoInterfaceRepository;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoInterfaceRepository acessoInterfaceRepository;
	
	@Transactional
	public AcessoDomain saveOne(AcessoDomain acessoDomain) {
			acessoDomain.setChave(encriptarChaveAcesso(acessoDomain));
		return this.acessoInterfaceRepository.save(acessoDomain);
	}
	
	public void saveAll(List<AcessoDomain> acessoDomainList) {
		for(AcessoDomain acessoDomain : acessoDomainList) {
			this.saveOne(acessoDomain);
		}
	}

	public List<AcessoDomain> findAll() {
		return this.acessoInterfaceRepository.findAll();
	}
	
	@Transactional
	public AcessoDomain updateOne(Long codigo, AcessoDomain acessoDomain) {
		AcessoDomain acessoDomainPersistencia = this.findOne(codigo).get();
			acessoDomainPersistencia.setChave(acessoDomain.getChave());
			acessoDomainPersistencia.setDataCadastro(acessoDomain.getDataCadastro());
			acessoDomainPersistencia.setDataVencimento(acessoDomain.getDataVencimento());
			acessoDomainPersistencia.setIdentificador(acessoDomain.getIdentificador());
			acessoDomainPersistencia.setIdPessoa(acessoDomain.getIdPessoa());
			acessoDomainPersistencia.setIsAtivo(acessoDomain.getIsAtivo());
			acessoDomainPersistencia.setObservacao(acessoDomain.getObservacao());
			acessoDomainPersistencia.setUrl(acessoDomain.getUrl());
		return this.saveOne(acessoDomainPersistencia);
	}
	
	public Optional<AcessoDomain> findOne(Long codigo) {
		return this.acessoInterfaceRepository.findById(codigo);
	}
	
	@Transactional
	public void deleteOne(Long codigo) {
		this.acessoInterfaceRepository.deleteById(codigo);
	}
	
	private String encriptarChaveAcesso(AcessoDomain acessoDomain) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(acessoDomain.getChave());
	}

}
