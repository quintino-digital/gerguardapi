package digital.quintino.gerguardapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_USUARIO_PERFIL")
public class UsuarioPerfilDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
    
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_SISTEMA")
    private UsuarioDomain usuarioDomain;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL_USUARIO")
	private PerfilDomain perfilDomain;
	
	public UsuarioPerfilDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public UsuarioDomain getUsuarioDomain() {
		return usuarioDomain;
	}

	public void setUsuarioDomain(UsuarioDomain usuarioDomain) {
		this.usuarioDomain = usuarioDomain;
	}

	public PerfilDomain getPerfilDomain() {
		return perfilDomain;
	}

	public void setPerfilDomain(PerfilDomain perfilDomain) {
		this.perfilDomain = perfilDomain;
	}

}
