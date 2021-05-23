package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario01 {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Exercicios_JPA");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		
		//Encontra o usu�rio da posi��o 2 e altera nome e email
		Usuario usuario = em.find(Usuario.class,2L);
		usuario.setNome("Jo�ozinho");
		usuario.setEmail("joao_marcossilva@hotmail.com");
		
		//m�todo update do jpa
		em.merge(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
