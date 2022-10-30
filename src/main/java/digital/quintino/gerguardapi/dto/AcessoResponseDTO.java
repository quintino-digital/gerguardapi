package digital.quintino.gerguardapi.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import digital.quintino.gerguardapi.domain.CategoriaAcessoDomain;

public class AcessoResponseDTO {
	
	@JsonIgnore
	private Long codigo;
	
	@JsonIgnore
	private CategoriaAcessoDomain categoriaAcessoDomain;
	
	@JsonIgnore
	private Long idPessoa;
	
	private String url;
	
	private String identificador;
	
	@JsonIgnore
	private String chave;
	
	@JsonIgnore
	private Date dataCadastro;
	
	@JsonIgnore
	private Date dataVencimento;
	
	@JsonIgnore
	private String observacao;
	
	@JsonIgnore
	private Boolean isAtivo;
	
	public AcessoResponseDTO() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CategoriaAcessoDomain getCategoriaAcessoDomain() {
		return categoriaAcessoDomain;
	}

	public void setCategoriaAcessoDomain(CategoriaAcessoDomain categoriaAcessoDomain) {
		this.categoriaAcessoDomain = categoriaAcessoDomain;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

}