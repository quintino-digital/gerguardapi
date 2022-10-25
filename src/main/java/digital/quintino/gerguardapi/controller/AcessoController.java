package digital.quintino.gerguardapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import digital.quintino.gerguardapi.service.AcessoService;

@RestController
@RequestMapping("acesso")
public class AcessoController {
	
	@Autowired
	private AcessoService acessoService;
	
	@PostMapping
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
	public List<AcessoDomain> findAll() {
		return this.acessoService.findAll();
	}
	
	@GetMapping("/{codigoAcesso}")
	public ResponseEntity<Object> findOne(@PathVariable(value = "codigoAcesso") Long codigo) {
		Optional<AcessoDomain> acessoDomain = this.acessoService.findOne(codigo);
		if(!acessoDomain.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acesso não Encontrado!");
		}
		return ResponseEntity.ok(acessoDomain);
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
	public ResponseEntity<Object> deleteOne(@PathVariable(value = "codigoAcesso") Long codigo) {
		Optional<AcessoDomain> acessoDomainOptional = this.acessoService.findOne(codigo);
		if(!acessoDomainOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Acesso não Encontrado!");
		}
		this.acessoService.deleteOne(codigo);
		return ResponseEntity.ok("Acesso Removido com Sucesso!");
	}
	
}
