package digital.quintino.gerguardapi.dto;

import java.util.ArrayList;
import java.util.List;

public class PessoaResponseDTO {
	
	private Long codigo;
	
	private String nome;
	
	public PessoaResponseDTO() { }
	
	public static List<PessoaResponseDTO> semResultado() {
		List<PessoaResponseDTO> pessoaResponseDTOList = new ArrayList<>();
			return pessoaResponseDTOList;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
