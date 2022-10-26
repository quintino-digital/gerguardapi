package digital.quintino.gerguardapi.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import digital.quintino.gerguardapi.dto.PessoaResponseDTO;

@FeignClient(name = "pessoaClient", url = "${foreign.url}", contextId = "pessoaClientID")
public interface PessoaInterfaceRepository {
	
	@GetMapping
	List<PessoaResponseDTO> findAll();
	
}
