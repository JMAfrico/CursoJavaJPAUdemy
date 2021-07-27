package teste.heranca;

import infra.DAO;
import modelo.heranca.Aluno;
import modelo.heranca.AlunoBolsista;

public class NovoAluno {

	public static void main(String[] args) {
		
		DAO<Aluno> Alunodao = new DAO<>();
		
		Aluno aluno1 = new Aluno(1550781821028L,"João Marcos");
		AlunoBolsista aluno2= new AlunoBolsista(1554777L, "Maria", 500.00);
		
		Alunodao.incluirCompleto(aluno1);
		Alunodao.incluirCompleto(aluno2);
		
	}
}
