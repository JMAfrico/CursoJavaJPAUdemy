package modelo.composicao;

import javax.persistence.*;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name="nome_fornecedor")
	private String nome;
	
	//Instância de classe Composição(@Embeddable) Endereço, todos os atributos dela serão criados nessa tabela
	private Endereco endereco;
	
	public Fornecedor() {
		
	}

	public Fornecedor(String nome, Endereco endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
