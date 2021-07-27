package modelo.composicao;

import javax.persistence.Embeddable;

//Todos os 3 atributos dessa classe endereco v�o entrar nas tabelas que chamar ela(Campos que s�o comuns em v�rios lugares)
//Esse classe n�o � criada no banco de dados
@Embeddable
public class Endereco {

	private String estado;
	private String logradouro;
	private String complemento;
	
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
