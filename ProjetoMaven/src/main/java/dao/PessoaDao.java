package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import basica.Endereco;
import basica.Pessoa;
import basica.Veiculo;

public class PessoaDao {
	
	EntityManager em = GetEntityManager.getConnectionJpa();
	
	public void adiciona(Pessoa p) {
		
		
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		
		
	}
	
	public Pessoa buscarPessoaId(int id) {
		
		return em.find(Pessoa.class, id);
		
	}
	
	public void atualizar(Pessoa p) {
		
		em.getTransaction().begin();
		
		em.merge(p);
		
		em.getTransaction().commit();
		
	}
	
	public void atualizarPessoaVeiculo(Pessoa p, Veiculo v) {
		
		p.adicionaVeiculo(v);
		
		em.getTransaction().begin();
		
		em.merge(p);
		
		em.getTransaction().commit();
		
		
	}
	
	public void removerId(Pessoa p) {
		
		em.getTransaction().begin();
		
		em.remove(p);
		
		em.getTransaction().commit();
		
	}
	
	public List<Pessoa> listarPessoas(){
		
		return em.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
		
	}
	
	public List<Pessoa> listarPessoaQtd(int qtd){
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p", Pessoa.class);
		query.setMaxResults(qtd);
		return query.getResultList();
	}
	
	public Pessoa procurarPorNome(String nome) {
		
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p where p.nome = :n", Pessoa.class);
		query.setParameter("n", nome);
		
		return query.getSingleResult();
		
		
		
	}
	
	public List<Pessoa> listarPessoasVeiculos(){
		
		return em.createQuery("select DISTINCT p from Pessoa p join p.veiculo", Pessoa.class).getResultList();
		
	}
	
	public List<Pessoa> listarPessoasVeiculosModelo(String modelo){
		
		TypedQuery<Pessoa> query = em.createQuery("select p from Pessoa p where p.veiculo.modelo= :model", Pessoa.class);
		query.setParameter("model", modelo);
		
		return query.getResultList();
		
	}
	
	public long somaQtdCarros(Pessoa p) {
		
		TypedQuery<Long> query = em.createQuery("select COUNT(p) from Pessoa p join p.veiculo on p.id = :idpessoa",Long.class);
		query.setParameter("idpessoa", p.getId());
		
		return query.getSingleResult();
		
		
		
	}
	


}
