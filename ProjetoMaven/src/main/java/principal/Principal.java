package principal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import basica.Endereco;
import basica.Funcionario;
import basica.Pessoa;
import basica.Veiculo;
import dao.PessoaDao;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Pessoa p = new Pessoa("Maria Celine","mceline@gmail.com");
	
		
	/*	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager(); */
		
//		Veiculo v = new Veiculo("TIGGO","CHERY");
//		Funcionario f = new Funcionario("João","Mecânico");
//		
//		Pessoa pessoa = em.find(Pessoa.class, 2);
		
//		Endereco end = new Endereco("BNH", "Rua Sem Fim", "233");
		
		PessoaDao pessoa = new PessoaDao();
		
		System.out.println(pessoa.somaQtdCarros(2));
		
		
		Pessoa p = new Pessoa();
		
//		p = pessoa.somaVeiculoNome(2);
		
//		System.out.println("nome = "+ p.getNome() + " email = " + p.getEmail() + " quantidade veiculo = "+p.getQtdVeiculo());
		
		
		
		
		
//		p.adicionaVeiculo(v);
//		p.adicionaEnd(end);
//		pessoa.adiciona(p);
//		pessoa.adiciona(p, end);
		
		
//		Pessoa p = pessoa.procurarPorNome("Maria Helena Costa");
		
	//	System.out.println(p.getNome());
		
		//pessoa.atualizarPessoaVeiculo(p, v);
		
		
//		pessoa.listarPessoasVeiculos().forEach(System.out::println);
		
		
		
		
		
		/*Pessoa pupdate = pessoa.buscarPessoaId(2);
		
		pupdate.setNome("Maria Helena Costa");
		
		pessoa.atualizar(pupdate);*/
		
	
	
		
		/*	p3.setVeiculo(veiculos);
		p3.setEndereco(end);*/
		
		//p.adicionaEnd(end);
		
	/*	Funcionario f2 = em.find(Funcionario.class, 1);
		Veiculo v2 = em.find(Veiculo.class,2); */
		
		
		
		//Pessoa pessoa = em.find(Pessoa.class, 1);
		
		
		//Endereco endereco;
		
		//em.getTransaction().begin();
	
		//	p3.getVeiculo().add(v);
		
		//em.persist(f);
		
		//v2.adiciona(f2);
		
		//endereco = em.find(Endereco.class, 1);
		
	//	pessoa.adicionaVeiculo(v);
	
		//	em.persist(f);
		//em.merge(pessoa);
	//	f2 = em.find(Funcionario.class, 1);
	//	v2 = em.find(Veiculo.class, 1);
	//	v2.adiciona(f2);
		
	//	em.getTransaction().commit();
		
		//pessoa.getVeiculo().forEach(System.out::println);
		
	//	System.out.println(endereco.toString());

		System.out.println("Foi");
	}

}
