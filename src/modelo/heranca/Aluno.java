package modelo.heranca;

import javax.persistence.*;

@Entity

// ------------------ TABLE PER CLASS -------------- //
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
//---- anotação herança estratégia "TABLE PER CLASS"
//---- cria tabela Aluno e Aluno Bolsista	

//------------------ SINGLE TABLE -------------- //
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "tipo_aluno", length = 2, discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue("AL")

//---- anotação herança estratégia "SINGLE_TABLE"
//---- cria única tabela Aluno e junta todas colunas, aquela coluna que não obter atributo entra como null na tabela
		//mas é necessário descriminar qual o tipo da classe que a informação é gerada	
//---- @DiscriminatorColumn = nome da coluna,tamanho de caracteres,o tipo de dado que vai diferenciar
//---- @DiscriminatorValue = qual é o valor nessa classe que vai ser preenchido na coluna tipo


//------------------ JOINED -------------- //
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_aluno", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("AL")

//---- anotação herança estratégia "JOINED"
//---- cria duas tabelas Aluno e Aluno Bolsista, Aluno bolsista só armazena aquilo que é particular seu e chave estrangeira
		//da que vem da chave primaria da tabela Aluno
//---- @DiscriminatorColumn = nome da coluna,tamanho de caracteres,o tipo de dado que vai diferenciar
//---- @DiscriminatorValue = qual é o valor nessa classe que vai ser preenchido na coluna tipo


public class Aluno {
	
	@Id
	private Long matricula;
	
	private String nome;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

	public Aluno(Long matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
