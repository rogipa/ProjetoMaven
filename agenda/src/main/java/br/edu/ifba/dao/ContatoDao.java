package br.edu.ifba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.basicas.Contato;

public class ContatoDao {
	
	EntityManager em = GetEntityManager.getConnectionJpa();
	
	public void adicionaContato(Contato contato) {
		
		em.getTransaction().begin();
			em.persist(contato);
		em.getTransaction().commit();
		
	}
	
	public Contato procurarContatoId(int id) {
		
		return em.find(Contato.class, id);
		
	}
	
	public List<Contato> listarContato(){
		
		return em.createQuery("select c from Contato c", Contato.class).getResultList();
	}
	
	public void atualizarContato(Contato c) {
		
		em.getTransaction().begin();
			em.merge(c);
		em.getTransaction().commit();
		
	}
	
	public void removerContato(Contato c) {
		
		em.getTransaction().begin();
			em.remove(c);
		em.getTransaction().commit();
		
	}
	
	public List<Contato> procurarContatoNome(String nome) {
		
		TypedQuery<Contato> query = em.createQuery("select c from Contato c where c.nome like :n",Contato.class);
		query.setParameter("n", "%" + nome +"%");
		
		return query.getResultList();
		
	}
	
	
	
	

}
