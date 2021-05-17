package modelo.basico;

import javax.persistence.Entity;
import javax.persistence.Id;

//ESSA ANOTAÇÃO PRECISA SER FEITA,PARA DIZER QUE A CLASSE VAI SER UMA ENTIDADE
//QUE VAI SE COMUNICAR COM O BANCO.
//LÁ NA CLASSE "persistence.xml" COLOCAR A CLASSE QUE VAI PERSISTIR(SE COMUNICAR COM O BANCO)
//<class>modelo.basico.tb_bebida</class>
@Entity 

//A CLASSE SEMPRE CONTER OS MESMOS ATRIBUTOS DA TABELA DO BANCO DE DADOS
//A CLASSE TER UM CONSTRUTOR VAZIO, E UM CONSTRUTOR COM PARAMETROS
//A CLASSE DEVE TER OS ATRIBUTOS PRIVATES, E OS MÉTODOS GET E SET
public class Usuario {
	
	//ESSA ANOTAÇÃO DIZ QUE QUAL É A CHAVE PRIMARIA 
	@Id
	private Long id;
	
	private String nome;
	
	private String email;
	
	public Usuario() {
		
	}


	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

	
	

}
