package digital.quintino.gerguardapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Responsável por gerenciar os Usuários Logados e Autorizados da GERGUARDAPI
 */
@Entity
@Table(name = "TB_USUARIO")
public class UsuarioDomain implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODIGO")
	private UUID codigo;
	
	@Column(name = "IDENTIFICADOR", nullable = false)
	private String identificador;
	
	@Column(name = "CHAVE", nullable = false)
	private String chave;
	
	@Column(name = "RESPONSAVEL_ATUALIZACAO", nullable = false)
	private String responsavelAtualizacao;
	
	@Column(name = "DATA_ATUALIZACAO", nullable = false)
	private Date dataAtualizacao;
	
	@Column(name = "IS_ATIVO", nullable = false)
	private Boolean isAtivo;

	@ManyToMany
	@JoinTable(name = "TB_USUARIO_PERFIL",
		joinColumns = @JoinColumn(name = "ID_USUARIO"),
		inverseJoinColumns = @JoinColumn(name = "ID_PERFIL"))
	private List<PerfilDomain> perfilDomainList = new ArrayList<>();
	
	public UsuarioDomain() { }
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfilDomainList;
	}

	@Override
	public String getPassword() {
		return this.chave;
	}

	@Override
	public String getUsername() {
		return this.identificador;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.isAtivo;
	}

	public UUID getCodigo() {
		return codigo;
	}

	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}

	public Boolean getAtivo() {
		return isAtivo;
	}

	public void setAtivo(Boolean ativo) {
		isAtivo = ativo;
	}

	public List<PerfilDomain> getPerfilDomainList() {
		return perfilDomainList;
	}

	public void setPerfilDomainList(List<PerfilDomain> perfilDomainList) {
		this.perfilDomainList = perfilDomainList;
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

	public String getResponsavelAtualizacao() {
		return responsavelAtualizacao;
	}

	public void setResponsavelAtualizacao(String responsavelAtualizacao) {
		this.responsavelAtualizacao = responsavelAtualizacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

}
