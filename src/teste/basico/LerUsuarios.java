package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class LerUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence
				.createEntityManagerFactory("Exercicios_JPA");
		
		EntityManager em = fabrica.createEntityManager();
		
		/*	o mesmo que	select * from Usuario(Entidade)
		String jpql = "select u from Usuario u";		
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		
		Número de resultados que vai ser buscado da tabela
		query.setMaxResults(10);
						
		List<Usuario> usuarios = query.getResultList();
		
		*/
		
		//lista de usuario da entidade Usuarios, passa uma query e retorna 10 resultados
		List<Usuario> usuarios = em.createQuery("select u from Usuario u", Usuario.class).setMaxResults(10).getResultList();
		
		//apresenta num foreach os resultados da pesquisa
		for(Usuario usuario: usuarios) {
			System.out.println(usuario.getNome() + " - " + usuario.getEmail());
		}
		

		em.close();
		fabrica.close();
	}
}
