package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.Pedido;
import modelo.umpramuitos.ItemPedido;

public class ObterPedidos {

	public static void main(String[] args) {
		
		//crio classe DAO, passando com objeto a classe Pedido
		DAO<Pedido> dao = new DAO<>(Pedido.class);
		
		//passo para o objeto criado, o método obter por id
		Pedido pedido = dao.obterPorID(1L);
		
		//retorna a lista de itens do determinado pedido
		for(ItemPedido item: pedido.getItens()) {
			System.out.print("Quantidade:"+item.getQuantidade()+" - Produto:");
			System.out.print(item.getProduto().getNome()+" - Preço:");
			System.out.println(item.getProduto().getPreco());
		}
		
		dao.fecharEntityManager();
		
	}
}
