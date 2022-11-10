package br.edu.ifba.regranegocios;

import java.util.List;

import br.edu.ifba.basicas.Telefone;
import br.edu.ifba.dao.TelefoneDao;

public class TelefoneRn {
	
	TelefoneDao tel = new TelefoneDao();
	
	public void adicionaTelefone(Telefone telefone) {
	
		tel.adicionaTelefone(telefone);
		
	}
	
	public List<Telefone> listarTelefone(){
		
		return tel.listarTelefone();
		
	}
	
	public void atualizarTelefone(Telefone telefone) {
		
		tel.atualizarTelefone(telefone);
		
	}
	
	public void removerTelefone(Telefone telefone) {
		
		tel.removerTelefone(telefone);
		
	}
	
	public List<Telefone> procurarTelefoneNumero(String numero){
		
		return tel.procurarTelefoneNumero(numero);
		
		
	}

}
