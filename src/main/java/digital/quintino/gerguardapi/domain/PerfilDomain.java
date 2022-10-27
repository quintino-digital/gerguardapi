package digital.quintino.gerguardapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import digital.quintino.gerguardapi.enumeration.TipoPerfilUsuarioSistemaEnumeration;

@Entity
@Table(name = "TB_PERFIL")
public class PerfilDomain implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "DESCRICAO_PAPEL_USUARIO_ACESSO", nullable = false)
	private TipoPerfilUsuarioSistemaEnumeration papelUsuarioAcessoEnumeration;
	
	@OneToMany(mappedBy = "perfilDomain")
	private List<UsuarioPerfilDomain> usuarioPerfilDomainList = new ArrayList<>();
	
	public PerfilDomain() { }
	
	@Override
	public String getAuthority() {
		return this.papelUsuarioAcessoEnumeration.toString();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<UsuarioPerfilDomain> getUsuarioPerfilDomainList() {
		return usuarioPerfilDomainList;
	}

	public void setUsuarioPerfilDomainList(List<UsuarioPerfilDomain> usuarioPerfilDomainList) {
		this.usuarioPerfilDomainList = usuarioPerfilDomainList;
	}

	public TipoPerfilUsuarioSistemaEnumeration getPapelUsuarioAcessoEnumeration() {
		return papelUsuarioAcessoEnumeration;
	}

	public void setPapelUsuarioAcessoEnumeration(TipoPerfilUsuarioSistemaEnumeration papelUsuarioAcessoEnumeration) {
		this.papelUsuarioAcessoEnumeration = papelUsuarioAcessoEnumeration;
	}

}
