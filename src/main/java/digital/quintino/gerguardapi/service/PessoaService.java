package digital.quintino.gerguardapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.quintino.gerguardapi.dto.PessoaResponseDTO;
import digital.quintino.gerguardapi.repository.PessoaInterfaceRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaInterfaceRepository pessoaInterfaceRepository;
	
	public List<PessoaResponseDTO> findAll() {
		return pessoaInterfaceRepository.findAll();
	}

}
