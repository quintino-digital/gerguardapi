package digital.quintino.gerguardapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponseDTO {
	
	@JsonProperty("Erro HTTP")
	private int erro;
	
	@JsonProperty("Mensagem")
	private String mensagem;
	
	@JsonProperty("Data")
	private String data;
	
	public ExceptionResponseDTO() { }

	public int getErro() {
		return erro;
	}

	public void setErro(int erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
