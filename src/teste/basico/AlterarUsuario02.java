package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario02 {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Exercicios_JPA");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		usuario.setNome("Roberto");
		usuario.setEmail("roberto@hotmail.com");
		
		
		
		//em.merge(usuario);	
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
