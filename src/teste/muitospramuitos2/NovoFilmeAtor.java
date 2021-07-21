package teste.muitospramuitos2;

import infra.DAO;
import modelo.muitospramuitos2.Ator;
import modelo.muitospramuitos2.Filme;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>();
		
		Ator ator1 = new Ator("John Wick");
		Ator ator2 = new Ator("Laurence Fishburn");
		Filme filme = new Filme("Matrix",9.5);
		
		filme.adicionarAtor(ator1);
		filme.adicionarAtor(ator2);
		
		dao.abrirTransacao()
			.incluirTransacao(filme)
			.fecharTransacao()
		.fecharEntityManager();

	}
}
