package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//API - import javax.validation para validações de campos

@Entity
@Table(name = "tb_produtos")//nome da tabela que vai ser criada
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_produto")
	private Long id;
	
	@Column(name = "nome_produto", length = 100, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "preco_produto", nullable = false, precision = 11, scale = 2)
	private double preco;
	
	
	public Produto() {
		
	}
	
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
	
}
