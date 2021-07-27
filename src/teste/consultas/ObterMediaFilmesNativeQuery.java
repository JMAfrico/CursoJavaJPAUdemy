package teste.consultas;

import infra.DAO;
import modelo.consulta.NotaFilme;
import modelo.muitospramuitos2.Filme;

public class ObterMediaFilmesNativeQuery {

	public static void main(String[] args) {
		
		DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
		
		NotaFilme nota = dao.consultarUm("MediaGeralFilmes");
		
		System.out.println(nota.getMedia());
		
		dao.fecharEntityManager();
	}
}
