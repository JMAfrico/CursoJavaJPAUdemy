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
	private Double pre�o;
	
	@ManyToOne // um ou mais itens para um pedido
	private Pedido pedido;
	
	@ManyToOne // a compra pode te v�rios produtos
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

	public Double getPre�o() {
		return pre�o;
	}

	public void setPre�o(Double pre�o) {
		this.pre�o = pre�o;
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
		
		//se o produto n�o for nulo e o pre�o for nulo, ent�o o pre�o do produto vem da classe Produto.pre�o
		if(produto != null && this.pre�o == null) {
			this.setPre�o(produto.getPreco());
		}
	}

}
