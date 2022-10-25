package digital.quintino.gerguardapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.quintino.gerguardapi.client.PessoaClient;
import digital.quintino.gerguardapi.dto.PessoaResponseDTO;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaClient pessoaClient;
	
	public List<PessoaResponseDTO> findAll() {
		return pessoaClient.findAll();
	}

}
