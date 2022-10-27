package digital.quintino.gerguardapi.controller;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digital.quintino.gerguardapi.domain.AcessoDomain;
import digital.quintino.gerguardapi.dto.AcessoRequestDTO;
import digital.quintino.gerguardapi.exception.NotFoundImplementationException;
import digital.quintino.gerguardapi.service.AcessoService;

@RestController
@RequestMapping("/v1/acesso")
public class AcessoController {
	
	private static final Logger LOGGER = Logger.getLogger(AcessoController.class);
	
	@Autowired
	private AcessoService acessoService;
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Object> saveOne(@RequestBody AcessoRequestDTO acessoRequestDTO) {
		if(this.acessoService.isAcessoDuplicado(acessoRequestDTO)) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse Acesso já foi cadastrado!");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(this.acessoService.saveOne(acessoRequestDTO));
	}
	
	/**
	 * TODO -- Implementar Paginacao nesse metodo
	 * @return 
	 */
	@GetMapping
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<AcessoDomain>> findAll() {
		return ResponseEntity.ok(this.acessoService.findAll());
	}
	
	@GetMapping("/{codigoAcesso}")
	public ResponseEntity<Object> findOne(@PathVariable(value = "codigoAcesso") Long codigo) {
		LOGGER.info("ENDPOINT: <URL>/acesso/findOne");
		return ResponseEntity.ok(this.acessoService.findOne(codigo).orElseThrow(() -> new NotFoundImplementationException("Acesso não Encontrado!")));
	}
	
	@PutMapping("/{codigoAcesso}")
	public ResponseEntity<Object> updateOne(@PathVariable(value = "codigoAcesso") Long codigo, @RequestBody AcessoRequestDTO acessoRequestDTO) {
		Optional<AcessoDomain> acessoDomainOptional = this.acessoService.findOne(codigo);
		if(!acessoDomainOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acesso não Encontrado!");
		}
		return ResponseEntity.ok(this.acessoService.updateOne(codigo, acessoRequestDTO));
	}
	
	@DeleteMapping("/{codigoAcesso}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Object> deleteOne(@PathVariable(value = "codigoAcesso") Long codigo) {
		Optional<AcessoDomain> acessoDomainOptional = this.acessoService.findOne(codigo);
		if(!acessoDomainOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acesso não Encontrado!");
		}
		this.acessoService.deleteOne(codigo);
		return ResponseEntity.ok("Acesso Removido com Sucesso!");
	}
	
}
