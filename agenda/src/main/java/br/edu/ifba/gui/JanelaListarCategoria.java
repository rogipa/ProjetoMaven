package br.edu.ifba.gui;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.edu.ifba.basicas.Categoria;
import br.edu.ifba.regranegocios.CategoriaRn;
import br.edu.ifba.tableModel.CategoriaTableModel;

public class JanelaListarCategoria extends JInternalFrame {

	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JTable tabelaCategorias = null;
	
	private CategoriaTableModel modeloTabela = null;
	private JButton botaoRemover = null;

	CategoriaRn categoria = new CategoriaRn();
	
	
	public JanelaListarCategoria() {
		super();
		initialize();
		preencherTabelaCategorias();
	}
	private void preencherTabelaCategorias() {
		List<Categoria> categoriasCadastradas = categoria.listarCategorias();
		for(Categoria temp: categoriasCadastradas) {
			modeloTabela.addCategoria(temp);
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 308);
		this.setTitle("Lista de Categorias");
		this.setContentPane(getJContentPane());
		this.setClosable(true);

	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getBotaoRemover(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(30, 15, 240, 138));
			jScrollPane.setViewportView(getTabelaCategorias());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tabelaCategorias	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTabelaCategorias() {
		if (tabelaCategorias == null) {
			modeloTabela = new CategoriaTableModel();
			tabelaCategorias = new JTable(modeloTabela);
		}
		return tabelaCategorias;
	}
	
	private void removeTabela() {
		modeloTabela.removeAllElements();
	}
	
	/**
	 * This method initializes botaoRemover	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoRemover() {
		if (botaoRemover == null) {
			botaoRemover = new JButton();
			botaoRemover.setBounds(new Rectangle(102, 177, 164, 20));
			botaoRemover.setText("Remover Categoria");
			botaoRemover.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(tabelaCategorias.getSelectedRowCount() != 1) {
						JOptionPane.showMessageDialog(null, "Selecione exatamente uma categoria para remover");
						return;
					}
					int linhaSelecionada = tabelaCategorias.getSelectedRow();
					int id = (Integer) tabelaCategorias.getValueAt(linhaSelecionada, 0);
					Categoria cat = categoria.procurarCategoriaId(id);
					
						categoria.removerCategoria(cat);

					
					removeTabela();
	                 preencherTabelaCategorias();
				}
			});
		}
		return botaoRemover;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
