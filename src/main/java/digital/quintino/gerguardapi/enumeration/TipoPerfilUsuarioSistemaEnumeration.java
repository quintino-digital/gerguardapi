package digital.quintino.gerguardapi.enumeration;

public enum TipoPerfilUsuarioSistemaEnumeration {
	
	ROLE_ADMIN(1, "ADMIN", "ROLE_ADMIN", "Administrador"), 
	ROLE_USER(2, "USER", "ROLE_USER", "Usuário Padrão do Sistema");
	
	private int codigo;
	private String perfilSimplificado;
	private String perfilSistema;
	private String descricaoPerfil;
	
	private TipoPerfilUsuarioSistemaEnumeration(int codigo, String perfilSimplificado, String perfilSistema, String descricaoPerfil) {
		this.codigo = codigo;
		this.perfilSimplificado = perfilSimplificado;
		this.perfilSistema = perfilSistema;
		this.descricaoPerfil = descricaoPerfil;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPerfilSimplificado() {
		return perfilSimplificado;
	}

	public void setPerfilSimplificado(String perfilSimplificado) {
		this.perfilSimplificado = perfilSimplificado;
	}

	public String getPerfilSistema() {
		return perfilSistema;
	}

	public void setPerfilSistema(String perfilSistema) {
		this.perfilSistema = perfilSistema;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}
	
}
