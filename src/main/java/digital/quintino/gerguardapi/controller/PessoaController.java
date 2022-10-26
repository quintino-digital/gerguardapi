package digital.quintino.gerguardapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digital.quintino.gerguardapi.dto.PessoaResponseDTO;
import digital.quintino.gerguardapi.service.PessoaService;

@RestController
@RequestMapping("/v1/pessoa-client")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public List<PessoaResponseDTO> findAll() {
		return this.pessoaService.findAll();
	}

}
