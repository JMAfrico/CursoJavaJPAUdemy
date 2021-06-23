package teste.basico;

import java.util.List;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		//Cria um DAO do tipo Produto(Já que a classe é genérica!)
		DAO<Produto> dao = new DAO<>(Produto.class);

		//NOVO PRODUTO
		Produto produto = new Produto("Bicicleta Caloi", 150.15);		
		//dao.incluirCompleto(produto).fechar();
		
		//SELECT PRODUTOS
		//List<Produto> produtos = dao.obterTodos(10, 0);
		//
		//for(Produto p: produtos ) {
		//	System.out.println(p.getNome());
		//}
		
		//ALTERAR PRODUTOS
		
		//DELETAR PRODUTOS
		
		
	}
}
