package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import modelo.basico.Usuario;

public class DeletarUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Exercicios_JPA");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 3L);
		
		if(usuario != null) {
			
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Usuário "+ usuario.getNome()+" Excluído com sucesso");
		}
		else {
			JOptionPane.showMessageDialog(null,"Usuário não encontrado, não foi possível deletar");
		}
		
		em.close();
		fabrica.close();
	}
}
