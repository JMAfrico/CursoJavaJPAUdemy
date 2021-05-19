package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String [] args) {
		
		//ABRE UMA NOVA CONEXAO COM PARAMETRO DO NOME DO PROJETO, 
		//QUE ESTA NA CLASSE PERSISTENCE.XML ONDE ESTA OS DADOS DE CONEXAO
		EntityManagerFactory fabrica = Persistence
				.createEntityManagerFactory("Exercicios_JPA");
		
		//OBJETO QUE MANIPULAR ESSA NOVA CONEXAO, QUE FAZ O CRUD
		EntityManager em = fabrica.createEntityManager();
		
		//INSTANCIA DE NOVO USUARIO DA ENTIDADE USUARIO
		Usuario novoUsuario = new Usuario ("Joazerass","joao.silva351@fatec.sp.gov.br");
		
		//INICIA TRANSAÇÃO, PREENCHE OS DADOS, FINALIZA A INCLUSÃO
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		System.out.println(novoUsuario.getId());
		
		//FECHA O MANIPULADOR DA CONEXAO E A CONEXÃO
		em.close();
		fabrica.close();
		
	}

}
