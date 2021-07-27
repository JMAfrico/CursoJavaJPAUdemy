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
	
	//BLOCO STATIC INICIALIZA ASSIM QUE INICIA O SISTEMA, � BOM COLOCAR TRY CATCH POIS SE O SISTEMA DER ERRO NA INICIALIZA��O � TRATADO
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
	
	//---------------------------------//
	
	public DAO<Tipo> abrirTransacao() {
		em.getTransaction().begin();
		return this;//faz com que a classe seja recursiva,posso chamar novamente
	}
	
	public DAO<Tipo> fecharTransacao() {
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<Tipo> incluirTransacao(Tipo entidade) {
		em.persist(entidade);
		return this;
	}
	
	public DAO<Tipo> incluirCompleto(Tipo entidade) {
		return this.abrirTransacao().incluirTransacao(entidade).fecharTransacao();
	}
	
	//----------------------------------//
	//LISTA ITENS DO BD
	
	public Tipo obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public List<Tipo> obterTodos(){
		return this.obterTodos(10,0);
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
	
	//-----------------------------------//
	
	public void fecharEntityManager() {
		em.close();
	}
	
	
	//M�todo de Consulta JPQL
	
	public List<Tipo> consultar(String nomeConsulta, Object... params){
		TypedQuery<Tipo> query = em.createNamedQuery(nomeConsulta, classe);
		
		for(int i = 0;i < params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}
		return query.getResultList();
	}
	
	//M�todo de consulta SQL(NATIVE QUERY)
	
	//Lista de um tipo(classe) onde pesquisa numa lista
	public Tipo consultarUm(String nomeConsulta, Object... params){
		List<Tipo> lista = consultar(nomeConsulta, params);
		
		//se retorno � vazio,retorna null, senao mostra a lista
		return lista.isEmpty() ? null: lista.get(0);
			
		
		
	}

}
