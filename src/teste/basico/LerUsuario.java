package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class LerUsuario {

	public static void main(String args[]) {
		
		EntityManagerFactory fabrica = Persistence
				.createEntityManagerFactory("Exercicios_JPA");
		
		EntityManager em = fabrica.createEntityManager();
		
		//BUSCA O USUARIO, classe e ID
		Usuario usuario = em.find(Usuario.class, 7L);
		System.out.println(usuario.getNome());
		
		
		em.close();
		fabrica.close();
	}
}
