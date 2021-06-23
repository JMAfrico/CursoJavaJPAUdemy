package teste.basico;

import java.util.List;
import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto{

	public static void main(String[] args) {
		
		//Cria um DAO do tipo Produto(Já que a classe é genérica!)
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = new Produto("Camiseta", 79.90);		
		dao.incluirCompleto(produto).fecharEntityManager();
		System.out.println("Id do produto criado: "+ produto.getId());
		System.out.println("Nome do produto criado: "+ produto.getNome());
		System.out.println("Preço do produto criado: "+ produto.getPreco());
		
		
	}
}
