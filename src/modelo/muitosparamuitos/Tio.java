package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Tio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany
	private List<Sobrinho> sobrinhos = new ArrayList<>();
	
	public List<Sobrinho> getSobrinhos() {
		return sobrinhos;
	}

	public void setSobrinhos(List<Sobrinho> sobrinhos) {
		this.sobrinhos = sobrinhos;
	}

	public Tio() {
		// TODO Auto-generated constructor stub
	}

	public Tio(String nome) {
		super();
		this.nome = nome;
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
	
	
}
