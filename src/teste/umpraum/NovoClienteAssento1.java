package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("10-Corredor");
		Cliente cliente = new Cliente("Tiago", assento);
		
		DAO<Object> dao = new DAO<>();
		dao.abrirTransacao()
			.incluirTransacao(assento)
			.incluirTransacao(cliente)
		.fecharTransacao()
		.fecharEntityManager();
		
		
	}
}
