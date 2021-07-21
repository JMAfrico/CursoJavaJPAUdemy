package modelo.muitosparamuitos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Sobrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "sobrinhos")// JPA vai criar a tabela intermediária Tio_Sobrinho (Essa classe_Classe mapeada)
	private List<Tio> tios = new ArrayList<>();
	
	public List<Tio> getTios() {
		return tios;
	}

	public void setTios(List<Tio> tios) {
		this.tios = tios;
	}

	public Sobrinho() {
		
	}

	public Sobrinho(String nome) {
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
