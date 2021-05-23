package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario03 {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Exercicios_JPA");
		EntityManager em = fabrica.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		em.detach(usuario);
		//detach torna o objeto em estado não gerenciado, ele não vai atualizar no bd
		//a não ser que tenha um merge que altoriza essa requisição
		
		usuario.setNome("Robert");
		usuario.setEmail("roberto@hotmail.com");
		
		em.merge(usuario);	
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
}
