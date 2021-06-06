package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

//classe gen�rica,nome para chamar ela mesma
public class DAO <Tipo>{

	private static EntityManagerFactory fabrica;
	private static EntityManager em;
	private Class<Tipo> classe;
	
	//BLOCO STATIC INICIALIZA ASSIM QUE INICIA O SISTEMA
	static {
		try {
			
			fabrica = Persistence.createEntityManagerFactory("Exercicios_JPA");
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: "+e);
		}
	}
	
	public DAO() {
		this(null);
	}
	
	
	public DAO(Class<Tipo> classe) {
		this.classe = classe;
		em = fabrica.createEntityManager();
	}
	
	public DAO<Tipo> abrirTransacao() {
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<Tipo> fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<Tipo> buscarID(Long id) {
		em.find(classe, id);
		return this;
	}
	
	public DAO<Tipo> autenticacao(Tipo classe) {
		em.detach(classe);
		em.merge(classe);
		return this;
	}
	
	public DAO<Tipo> incluirTransacao(Tipo entidade) {
		em.persist(entidade);
		return this;
	}
	
	public DAO<Tipo> incluirCompleto(Tipo entidade) {
		return this.abrirTransacao().incluirTransacao(entidade).fecharTransacao();
	}
	
	public List<Tipo> obterTodos (int quantidade, int deslocamento) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		
		String jpql = "select e from "+ classe.getName() +" e";
		TypedQuery<Tipo> query = em.createQuery(jpql, classe);
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		return query.getResultList();
		
	}
	

	public DAO<Tipo> deletarCompleto() {
		em.getTransaction().commit();
		return this;
	}
	
	public void fechar() {
		em.close();
	}
	
	
}
