package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Produto produto = new Produto("TV LG", 1399.90);
		Pedido pedido = new Pedido();
		ItemPedido item = new ItemPedido(1,pedido,produto); 
		
		dao
			.abrirTransacao()
				.incluirTransacao(produto)
				.incluirTransacao(pedido)
				.incluirTransacao(item)
			.fecharTransacao()
		.fecharEntityManager();
	}

}
