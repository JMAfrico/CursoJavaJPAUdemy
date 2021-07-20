package modelo.umpramuitos;

import javax.persistence.*;

import modelo.basico.Produto;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(nullable = false)
	private int quantidade;
	
	@Column(nullable = false)
	private Double preço;
	
	@ManyToOne // um ou mais itens para um pedido
	private Pedido pedido;
	
	@ManyToOne // a compra pode te vários produtos
	private Produto produto;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
		super();
		this.setQuantidade(quantidade);
		this.setPedido(pedido);
		this.setProduto(produto);
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	
	public void setProduto(Produto produto) {
		this.produto = produto;
		
		//se o produto não for nulo e o preço for nulo, então o preço do produto vem da classe Produto.preço
		if(produto != null && this.preço == null) {
			this.setPreço(produto.getPreco());
		}
	}

}
