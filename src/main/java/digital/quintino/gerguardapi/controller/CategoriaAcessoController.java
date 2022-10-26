package digital.quintino.gerguardapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import digital.quintino.gerguardapi.domain.CategoriaAcessoDomain;
import digital.quintino.gerguardapi.service.CategoriaAcessoService;

@RestController
@RequestMapping("categoria-acesso")
public class CategoriaAcessoController {
	
	@Autowired
	private CategoriaAcessoService categoriaAcessoService;
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.ok(this.categoriaAcessoService.findAll());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Object> findOne(@PathVariable(value = "codigo") Long codigo) {
		Optional<CategoriaAcessoDomain> categoriaAcessoDomainOptional = this.categoriaAcessoService.findOne(codigo);
		if(!categoriaAcessoDomainOptional.isPresent()) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Registro Encontrado!");
		}
		return ResponseEntity.ok(categoriaAcessoDomainOptional.get());
	}

}
