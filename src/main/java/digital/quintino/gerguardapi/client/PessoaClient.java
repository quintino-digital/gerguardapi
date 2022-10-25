package digital.quintino.gerguardapi.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import digital.quintino.gerguardapi.dto.PessoaResponseDTO;

@FeignClient(name = "pessoaClient", url = "${foreign.url}", contextId = "pessoaClientID")
public interface PessoaClient {
	
	@GetMapping
	List<PessoaResponseDTO> findAll();

}
