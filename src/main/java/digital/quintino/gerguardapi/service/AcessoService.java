package digital.quintino.gerguardapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import digital.quintino.gerguardapi.domain.AcessoDomain;
import digital.quintino.gerguardapi.dto.AcessoRequestDTO;
import digital.quintino.gerguardapi.dto.AcessoResponseDTO;
import digital.quintino.gerguardapi.repository.AcessoInterfaceRepository;

@Service
public class AcessoService {
	
	@Autowired
	private AcessoInterfaceRepository acessoInterfaceRepository;
	
	/**
	 * TODO -- O sistema deve calcular a data de vencimento de um acesso em três meses contada a partir da data de Cadastro
	 * @param acessoRequestDTO
	 * @return
	 */
	@Transactional
	public AcessoResponseDTO saveOne(AcessoRequestDTO acessoRequestDTO) {
		AcessoDomain acessoDomain = new AcessoDomain();
		AcessoResponseDTO acessoResponseDTO = new AcessoResponseDTO();
		BeanUtils.copyProperties(acessoRequestDTO, acessoDomain);
			acessoDomain.setChave(encriptarChaveAcesso(acessoRequestDTO.getChave()));
			acessoDomain.setDataCadastro(new Date());
		if(!this.isAcessoDuplicado(acessoRequestDTO)) {
			acessoDomain = this.acessoInterfaceRepository.save(acessoDomain);
			BeanUtils.copyProperties(acessoDomain, acessoResponseDTO);
			return acessoResponseDTO;
		} else {
			// TODO -- Encaminhar Excecao de Objeto Duplicado
		}
		return null;
	}
	
	public void saveAll(List<AcessoRequestDTO> acessoRequestDTOList) {
		for(AcessoRequestDTO acessoRequestDTO : acessoRequestDTOList) {
			this.saveOne(acessoRequestDTO);
		}
	}

	public List<AcessoResponseDTO> findAll() {
		List<AcessoResponseDTO> acessoResponseDTOList = new ArrayList<>();
		for(AcessoDomain acessoDomain : this.acessoInterfaceRepository.findAll()) {
			AcessoResponseDTO acessoRequestDTO = new AcessoResponseDTO();
			BeanUtils.copyProperties(acessoDomain, acessoRequestDTO);
			acessoResponseDTOList.add(acessoRequestDTO);
		}
		return acessoResponseDTOList;
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
	
	/**
	 * TODO -- Criar consulta para realizar essa validação
	 * @param acessoRequestDTO
	 * @return
	 */
	public Boolean isAcessoDuplicado(AcessoRequestDTO acessoRequestDTO) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		for(AcessoResponseDTO acessoResponseDTO : this.findAll()) {
			if(bCryptPasswordEncoder.matches(acessoRequestDTO.getChave(), acessoResponseDTO.getChave()) &&
					acessoResponseDTO.getIdentificador().equals(acessoRequestDTO.getIdentificador()) &&
						acessoResponseDTO.getUrl().equals(acessoRequestDTO.getUrl()) &&
							acessoResponseDTO.getDataVencimento() == acessoRequestDTO.getDataVencimento()) {
				return true;
			}
		}
		return false;
	}
	
	private String encriptarChaveAcesso(String chave) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.encode(chave);
	}

}
