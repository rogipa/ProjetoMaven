package br.edu.ifba.gui;

import java.awt.Rectangle;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.edu.ifba.basicas.Categoria;
import br.edu.ifba.basicas.Contato;
import br.edu.ifba.basicas.Endereco;
import br.edu.ifba.basicas.Telefone;
import br.edu.ifba.dao.CategoriaDao;
import br.edu.ifba.regranegocios.CategoriaRn;

public class JanelaCadastrarContato extends JInternalFrame {

	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JComboBox campoCategoria = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JTextField campoNome = null;
	private JTextField campoObs = null;
	private JTextField campoRua = null;
	private JTextField campoNumero = null;
	private JButton botaoCadastrar = null;

	/**
	 * This is the xxx default constructor
	 */
	public JanelaCadastrarContato() {
		super();
		initialize();
		carregarListaCategoria();
		
	}
	
	CategoriaDao cat = new CategoriaDao();
	private JTextField campoBairro;
	private JLabel lblNewLabel_2;
	private JTextField campoCidade;
	private JLabel lblNewLabel_3;
	private JTextField campoTelefone;
	
	private void carregarListaCategoria() {
		List<Categoria> categoriasCadastradas = cat.listarCategorias();
		//campoCategoria.addItem("Selecione a Categoria:");
		for(Categoria temp: categoriasCadastradas) {
			campoCategoria.addItem(temp);
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(392, 331);
		this.setTitle("Cadastrar Contato");
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
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(46, 134, 38, 16));
			jLabel4.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel4.setText("Número:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(28, 111, 56, 16));
			jLabel3.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel3.setText("Rua:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(52, 40, 38, 16));
			jLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel2.setText("Nome:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(52, 63, 38, 16));
			jLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel1.setText("Obs.:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(28, 17, 62, 16));
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel.setText("Categoria:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getCampoCategoria(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getCampoNome(), null);
			jContentPane.add(getCampoObs(), null);
			jContentPane.add(getCampoRua(), null);
			jContentPane.add(getCampoNumero(), null);
			jContentPane.add(getBotaoCadastrar(), null);
			
			JLabel lblNewLabel = new JLabel("Endereço");
			lblNewLabel.setBounds(152, 91, 61, 16);
			jContentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Bairro:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(28, 161, 61, 16);
			jContentPane.add(lblNewLabel_1);
			
			campoBairro = new JTextField();
			campoBairro.setBounds(115, 156, 166, 26);
			jContentPane.add(campoBairro);
			campoBairro.setColumns(10);
			jContentPane.add(getLblNewLabel_2());
			jContentPane.add(getCampoCidade());
			jContentPane.add(getLblNewLabel_3());
			jContentPane.add(getCampoTelefone());
		}
		return jContentPane;
	}

	/**
	 * This method initializes campoCategoria	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCampoCategoria() {
		if (campoCategoria == null) {
			campoCategoria = new JComboBox();
			campoCategoria.setBounds(new Rectangle(162, 11, 125, 23));
		}
		return campoCategoria;
	}

	/**
	 * This method initializes campoNome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoNome() {
		if (campoNome == null) {
			campoNome = new JTextField();
			campoNome.setBounds(new Rectangle(121, 36, 166, 20));
		}
		return campoNome;
	}

	/**
	 * This method initializes campoEmail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoObs() {
		if (campoObs == null) {
			campoObs = new JTextField();
			campoObs.setBounds(new Rectangle(121, 59, 166, 20));
		}
		return campoObs;
	}

	/**
	 * This method initializes campoCelular	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoRua() {
		if (campoRua == null) {
			campoRua = new JTextField();
			campoRua.setBounds(new Rectangle(115, 107, 166, 20));
		}
		return campoRua;
	}

	/**
	 * This method initializes campoFone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCampoNumero() {
		if (campoNumero == null) {
			campoNumero = new JTextField();
			campoNumero.setBounds(new Rectangle(115, 132, 160, 20));
		}
		return campoNumero;
	}

	/**
	 * This method initializes botaoCadastrar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBotaoCadastrar() {
		if (botaoCadastrar == null) {
			botaoCadastrar = new JButton();
			botaoCadastrar.setBounds(new Rectangle(264, 257, 98, 22));
			botaoCadastrar.setText("Cadastrar");
			botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Categoria categoria = (Categoria) campoCategoria.getSelectedItem();
					String nome = campoNome.getText();
					String obs = campoObs.getText();
					
					
					String rua = campoRua.getText();
					String numero = campoNumero.getText();
					String bairro = campoRua.getText();
					String cidade = campoCidade.getText();
					
					Endereco end = new Endereco(rua, numero, bairro, cidade);
					
					String telefone = campoTelefone.getText();
					
					Telefone tel = new Telefone();
					
					tel.setNumero(telefone);
					
					Contato c = new Contato();
					
					c.setNome(nome);
					c.setEndereco(end);
					c.setObservacao(obs);
					c.adicionaTelefone(tel);
					
					categoria.adiciona(c);
					
					CategoriaRn cat = new CategoriaRn();
					
					cat.atualizarCategoria(categoria);
					
					campoNome.setText("");
					campoObs.setText("");
					campoRua.setText("");
					campoBairro.setText("");
					campoCidade.setText("");
					campoTelefone.setText("");
					
					JOptionPane.showMessageDialog(null, "Contato cadastrado!");
						
				}
			});
		}
		return botaoCadastrar;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Cidade:");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(29, 189, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTextField getCampoCidade() {
		if (campoCidade == null) {
			campoCidade = new JTextField();
			campoCidade.setBounds(115, 184, 166, 26);
			campoCidade.setColumns(10);
		}
		return campoCidade;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Telefone:");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(29, 227, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getCampoTelefone() {
		if (campoTelefone == null) {
			campoTelefone = new JTextField();
			campoTelefone.setBounds(115, 222, 166, 26);
			campoTelefone.setColumns(10);
		}
		return campoTelefone;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
