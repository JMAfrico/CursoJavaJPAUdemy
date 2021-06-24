package teste.basico;

import java.util.List;
import infra.ProdutoDAO;
import modelo.basico.Produto;

public class LerProdutos {

	public static void main(String[] args) {
		
		//utilizando o ProdutoDAO
		 ProdutoDAO dao = new ProdutoDAO();
		 List<Produto> produtos = dao.obterTodos(10,0);
		 
		 	//classe   var     instancia
		 for(Produto produto : produtos) {
			 System.out.println("Produto: "+produto.getNome()+" - Preço: "+produto.getPreco());
		 }
		 
		 dao.fecharEntityManager();
	}
}
