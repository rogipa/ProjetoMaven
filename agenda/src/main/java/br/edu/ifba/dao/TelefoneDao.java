package br.edu.ifba.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifba.basicas.Telefone;

public class TelefoneDao {
	
	EntityManager em = GetEntityManager.getConnectionJpa();

	public void adicionaTelefone(Telefone telefone) {
		
		em.getTransaction().begin();
			em.persist(telefone);
		em.getTransaction().commit();
		
	}
	
	public Telefone procurarTelefoneId(int id) {
		
		return em.find(Telefone.class, id);
		
	}
	
	public List<Telefone> listarTelefone(){
		
		return em.createQuery("select t from Telefone t",Telefone.class).getResultList();
		
	}
	
	public void atualizarTelefone(Telefone telefone) {
		
		em.getTransaction().begin();
			em.merge(telefone);
		em.getTransaction().commit();
		
	}
	
	public void removerTelefone(Telefone telefone) {
		
		em.getTransaction().begin();
			em.remove(telefone);
		em.getTransaction().commit();
		
	}
	
	public List<Telefone> procurarTelefoneNumero(String telefone){
		
		TypedQuery<Telefone> query = em.createQuery("select t from Telefone t where t.numero like :tel", Telefone.class);
		query.setParameter("tel", "%" + telefone + "%");
		
		return query.getResultList();
		
	}

}
