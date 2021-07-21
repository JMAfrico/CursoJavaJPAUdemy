package modelo.umpramuitos;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private Date data;
	
	//Mapeia de um para muitos. Com isso esse objeto se transforma em bidirecional, pois 
	//já tenho Relacionamento de @ManyToOne de ItemPedido para pedido, @OneToMany de pedido para ItemPedido
	//fetch = FetchType.EAGER-TRAS OS DADOS POR PADRÃO QUANDO O OBJETO RETORNA UM ÚNICO ID,QUANDO O RELACIONAMENTO É 1-1 
	//fetch = FetchType.LAZY- NÃO TRAS OS DADOS POR PADRÃO PARA NÃO SOBRECARREGAR O SISTEMA, ISSO QUANDO RELACIONAMENTO É 1-N
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itens;
	
	public Pedido() {
		this(new Date());
	}
	
	
	public Pedido(Date data) {
		super();
		this.data = data;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public List<ItemPedido> getItens() {
		return itens;
	}


	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	
}
