package br.edu.ifba.principal;

import br.edu.ifba.basicas.Categoria;
import br.edu.ifba.dao.CategoriaDao;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Categoria c = new Categoria("Amigos","Categoria dos amigos");
		CategoriaDao cd = new CategoriaDao();
		
		cd.adiciona(c);

	}

}
