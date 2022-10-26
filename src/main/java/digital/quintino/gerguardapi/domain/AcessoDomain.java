package digital.quintino.gerguardapi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ACESSO")
public class AcessoDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA_ACESSO")
	private CategoriaAcessoDomain categoriaAcessoDomain;
	
	@Column(name = "ID_PESSOA")
	private Long idPessoa;
	
	@Column(name = "URL", nullable = false)
	private String url;
	
	@Column(name = "IDENTIFICADOR", nullable = false)
	private String identificador;
	
	@Column(name = "CHAVE", nullable = false)
	private String chave;
	
	@Column(name = "DATA_CADASTRO", nullable = false)
	private Date dataCadastro;
	
	@Column(name = "DATA_VENCIMENTO", nullable = false)
	private Date dataVencimento;
	
	@Column(name = "OBSERVACAO")
	private String observacao;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;
	
	public AcessoDomain() { }

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
