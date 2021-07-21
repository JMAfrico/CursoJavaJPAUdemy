package modelo.muitospramuitos2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Ator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String nome;

	@ManyToMany(mappedBy = "atores" , cascade = CascadeType.PERSIST)
	private List<Filme> filmes = new ArrayList<Filme>();
	
	public Ator() {
		
	}

	public Ator(String nome) {
		super();
		this.nome = nome;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	
	public Long getId() {
		return Id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	
}
