package digital.quintino.gerguardapi.dto;

public class CategoriaAcessoRequestDTO {
	
	private Long codigo;
	
	private String descricao;
	
	public CategoriaAcessoRequestDTO() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
