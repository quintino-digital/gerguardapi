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
@Table(name = "TB_USUARIO_SISTEMA_PERFIL_USUARIO_SISTEMA")
public class UsuarioSistemaPerfilUsuarioSisitemaDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long codigo;
    
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO_SISTEMA")
    private UsuarioSistemaDomain usuarioSistemaDomain;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL_USUARIO_SISTEMA")
	private PerfilUsuarioSistemaDomain perfilUsuarioSistemaDomain;
	
	public UsuarioSistemaPerfilUsuarioSisitemaDomain() { }

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public UsuarioSistemaDomain getUsuarioSistemaDomain() {
		return usuarioSistemaDomain;
	}

	public void setUsuarioSistemaDomain(UsuarioSistemaDomain usuarioSistemaDomain) {
		this.usuarioSistemaDomain = usuarioSistemaDomain;
	}

	public PerfilUsuarioSistemaDomain getPerfilUsuarioSistemaDomain() {
		return perfilUsuarioSistemaDomain;
	}

	public void setPerfilUsuarioSistemaDomain(PerfilUsuarioSistemaDomain perfilUsuarioSistemaDomain) {
		this.perfilUsuarioSistemaDomain = perfilUsuarioSistemaDomain;
	}

}