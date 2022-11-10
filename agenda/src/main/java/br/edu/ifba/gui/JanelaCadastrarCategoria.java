package br.edu.ifba.gui;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.edu.ifba.basicas.Categoria;
import br.edu.ifba.regranegocios.CategoriaJaCadastradaException;
import br.edu.ifba.regranegocios.CategoriaRn;

public class JanelaCadastrarCategoria extends JInternalFrame {

	private JPanel jContentPane = null;
	private JLabel jLabelNome = null;
	private JTextField campoNome = null;
	private JButton botaoCadastrar = null;
	private JButton botaoCancelar = null;
	private JLabel lblNewLabel;
	private JTextField campoDescricao;

	/**
	 * This is the xxx default constructor
	 */
	public JanelaCadastrarCategoria() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(353, 208);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setTitle("Cadastrar Categoria");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelNome = new JLabel();
			jLabelNome.setBounds(new Rectangle(31, 18, 44, 16));
			jLabelNome.setText("Nome:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelNome, null);
			jContentPane.add(getCampoNome(), null);
			jContentPane.add(getBotaoCadastrar(), null);
			jContentPane.add(getBotaoCancelar(), null);
			jContentPane.add(getLblNewLabel());
			jContentPane.add(getCampoDescricao());
		}
		return jContentPane;
	}

	/**
	 * This method initializes campoNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoNome() {
		if (campoNome == null) {
			campoNome = new JTextField();
			campoNome.setBounds(new Rectangle(103, 18, 155, 20));
		}
		return campoNome;
	}

	/**
	 * This method initializes botaoCadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoCadastrar() {
		if (botaoCadastrar == null) {
			botaoCadastrar = new JButton();
			botaoCadastrar.setBounds(new Rectangle(160, 95, 98, 22));
			botaoCadastrar.setText("Cadastrar");
			botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String nome = campoNome.getText();
					String descricao = campoDescricao.getText();
					
					if(nome.length() <= 0) {
						JOptionPane.showMessageDialog(null, "Nome inválido");
						return;
					}
					
					//Constuir o objeto com os dados digitados
					Categoria c = new Categoria(nome, descricao);
					
					CategoriaRn cat = new CategoriaRn();

					//Chamar a fachada para cadastrar o objeto
					try {
						
						cat.adicionarCategoria(c);
						JOptionPane.showMessageDialog(null, "Categoria cadastrada");

					}catch(CategoriaJaCadastradaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());

					}
				
					
					//Limpa os campos do formulário
					campoNome.setText("");
					campoDescricao.setText("");
				}
			});
		}
		return botaoCadastrar;
	}

	/**
	 * This method initializes botaoCancelar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoCancelar() {
		if (botaoCancelar == null) {
			botaoCancelar = new JButton();
			botaoCancelar.setBounds(new Rectangle(31, 95, 98, 22));
			botaoCancelar.setText("Cancelar");
		}
		return botaoCancelar;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Descrição:");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setBounds(14, 56, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getCampoDescricao() {
		if (campoDescricao == null) {
			campoDescricao = new JTextField();
			campoDescricao.setBounds(103, 51, 155, 26);
			campoDescricao.setColumns(10);
		}
		return campoDescricao;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
