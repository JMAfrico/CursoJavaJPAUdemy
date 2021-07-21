package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Sobrinho;
import modelo.muitosparamuitos.Tio;

public class NovoTioSobrinho {

	public static void main(String[] args) {
		
		Tio tia1 = new Tio("Teca");
		Tio tio2 = new Tio("Tico");
		
		Sobrinho sobrinho1  = new Sobrinho("Sandy");
		Sobrinho sobrinho2  = new Sobrinho("Miriam");
		
		tia1.getSobrinhos().add(sobrinho1);
		tia1.getSobrinhos().add(sobrinho2);
		tio2.getSobrinhos().add(sobrinho1);
		tio2.getSobrinhos().add(sobrinho2);
		
		sobrinho1.getTios().add(tia1);
		sobrinho1.getTios().add(tio2);
		sobrinho2.getTios().add(tia1);
		sobrinho2.getTios().add(tio2);
		
		DAO<Object> dao = new DAO<>();
		dao.abrirTransacao()
			.incluirTransacao(tia1)
			.incluirTransacao(tio2)
			.incluirTransacao(sobrinho1)
			.incluirTransacao(sobrinho2)
			.fecharTransacao()
		.fecharEntityManager();
		
		
	}
}
