package modelo.muitospramuitos2;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String nome;
	
	private Double nota;
	
	@ManyToMany(cascade = CascadeType.PERSIST) // cascade = inclui tudo que é relacionado ao Filme,ou seja,os atores
	@JoinTable(
			name = "atores_filmes",//cria o nome da tabela intermediária
			joinColumns = @JoinColumn(name= "filme_id", referencedColumnName = "Id"),//nome da coluna filmes referencia Id
			inverseJoinColumns = @JoinColumn(name="ator_id",referencedColumnName = "Id")//nome da coluna atores referencia Id	
	)
	private List<Ator> atores = new ArrayList<Ator>();
	
	public Filme() {
		
	}

	public Filme(String nome, Double nota) {
		super();
		this.nota = nota;
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

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public void adicionarAtor(Ator ator) {
		if(ator !=null && !getAtores().contains(this)) { // Se ator for diferente de nulo e ator não existe(no filme), adicionar
			getAtores().add(ator);
			
			if(!ator.getFilmes().contains(this)) { // se Filme não contém esse ator, adicionar
				ator.getFilmes().add(this);
			}
		}
		
		
		
	}
	

}
