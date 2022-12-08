package views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;

public class Fornecedores extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisar;
	private JLabel lblCnpj;
	private JTextField txtCnpj;
	private JLabel lblId;
	private JLabel lblIe;
	private JLabel lblRazoSocial;
	private JTextField txtNomeFantasia;
	private JLabel lblNomeFantasia;
	private JLabel lblSite;
	private JTextField txtSite;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JTextField txtEndereco;
	private JLabel lblEndereo;
	private JTextField txtBairro;
	private JLabel lblBairro;
	private JTextField txtObs;
	private JLabel lblObs;
	private JLabel lblFone;
	private JLabel lblContato;
	private JLabel lblCep;
	private JTextField txtCep;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtIe;
	private JTextField txtIdFor;
	private JTextField txtNomeContato;
	private JTextField txtFone;
	private JLabel lblWhatsapp;
	private JTextField txtWhatsapp;
	private JTextField txtRazaoSocial;
	private JTextField txtCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedores dialog = new Fornecedores();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Fornecedores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/supliers.png")));
		setTitle("Fornecedores");
		setBounds(100, 100, 682, 506);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(194, 13, 158, 20);
		getContentPane().add(lblNewLabel);

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarFornecedor();
			}
		});
		txtPesquisar.setBounds(263, 13, 158, 20);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);

		lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCnpj.setBounds(251, 163, 45, 14);
		getContentPane().add(lblCnpj);

		txtCnpj = new JTextField();
		txtCnpj.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(290, 160, 150, 20);
		getContentPane().add(txtCnpj);

		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(60, 163, 45, 14);
		getContentPane().add(lblId);

		lblIe = new JLabel("IE");
		lblIe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIe.setBounds(450, 163, 45, 14);
		getContentPane().add(lblIe);

		txtRazaoSocial = new JTextField();
		txtRazaoSocial.setColumns(10);
		txtRazaoSocial.setBounds(89, 195, 198, 20);
		getContentPane().add(txtRazaoSocial);

		lblRazoSocial = new JLabel("Raz\u00E3o Social");
		lblRazoSocial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRazoSocial.setBounds(10, 198, 119, 14);
		getContentPane().add(lblRazoSocial);

		txtNomeFantasia = new JTextField();
		txtNomeFantasia.setColumns(10);
		txtNomeFantasia.setBounds(400, 195, 234, 20);
		getContentPane().add(txtNomeFantasia);

		lblNomeFantasia = new JLabel("Nome Fantasia");
		lblNomeFantasia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNomeFantasia.setBounds(302, 198, 119, 14);
		getContentPane().add(lblNomeFantasia);

		lblSite = new JLabel("Site");
		lblSite.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSite.setBounds(20, 226, 119, 14);
		getContentPane().add(lblSite);

		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(89, 224, 198, 20);
		getContentPane().add(txtSite);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(89, 252, 198, 20);
		getContentPane().add(txtEmail);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(22, 255, 119, 14);
		getContentPane().add(lblEmail);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(89, 301, 198, 20);
		getContentPane().add(txtEndereco);

		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereo.setBounds(10, 304, 119, 14);
		getContentPane().add(lblEndereo);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(89, 330, 198, 20);
		getContentPane().add(txtBairro);

		lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setBounds(10, 333, 119, 14);
		getContentPane().add(lblBairro);

		txtObs = new JTextField();
		txtObs.setColumns(10);
		txtObs.setBounds(89, 361, 198, 39);
		getContentPane().add(txtObs);

		lblObs = new JLabel("Observa\u00E7\u00E3o");
		lblObs.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblObs.setBounds(10, 373, 119, 14);
		getContentPane().add(lblObs);

		lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFone.setBounds(502, 227, 45, 14);
		getContentPane().add(lblFone);

		lblContato = new JLabel("Nome Contato");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContato.setBounds(302, 229, 99, 14);
		getContentPane().add(lblContato);

		lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setBounds(335, 284, 45, 14);
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCep.setColumns(10);
		txtCep.setBounds(367, 281, 115, 20);
		getContentPane().add(txtCep);

		btnBuscar = new JButton("Buscar CEP");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscar.setBounds(502, 280, 109, 23);
		getContentPane().add(btnBuscar);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(335, 315, 45, 14);
		getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtNumero.setColumns(10);
		txtNumero.setBounds(389, 312, 54, 20);
		getContentPane().add(txtNumero);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(556, 312, 54, 20);
		getContentPane().add(txtComplemento);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComplemento.setBounds(470, 315, 103, 14);
		getContentPane().add(lblComplemento);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(389, 349, 121, 20);
		getContentPane().add(txtCidade);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(335, 355, 45, 14);
		getContentPane().add(lblCidade);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUf.setBounds(520, 350, 53, 14);
		getContentPane().add(lblUf);

		cboUf = new JComboBox<Object>();
		cboUf.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(557, 343, 54, 22);
		getContentPane().add(cboUf);

		txtIe = new JTextField();
		txtIe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtIe.setColumns(10);
		txtIe.setBounds(479, 160, 158, 20);
		getContentPane().add(txtIe);

		txtIdFor = new JTextField();
		txtIdFor.setColumns(10);
		txtIdFor.setBounds(89, 160, 126, 20);
		getContentPane().add(txtIdFor);

		txtNomeContato = new JTextField();
		txtNomeContato.setColumns(10);
		txtNomeContato.setBounds(397, 226, 95, 20);
		getContentPane().add(txtNomeContato);

		txtFone = new JTextField();
		txtFone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtFone.setColumns(10);
		txtFone.setBounds(539, 226, 95, 20);
		getContentPane().add(txtFone);

		lblWhatsapp = new JLabel("Whatsapp");
		lblWhatsapp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWhatsapp.setBounds(418, 255, 57, 14);
		getContentPane().add(lblWhatsapp);

		txtWhatsapp = new JTextField();
		txtWhatsapp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtWhatsapp.setColumns(10);
		txtWhatsapp.setBounds(485, 252, 95, 20);
		getContentPane().add(txtWhatsapp);

		btnCreate = new JButton("");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarFornecedor();
			}
		});
		btnCreate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/211872_person_add_icon.png")));
		btnCreate.setBounds(367, 392, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarFornecedor();
			}
		});
		btnUpdate.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/211882_refresh_icon.png")));
		btnUpdate.setBounds(463, 392, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnDelete.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/3669360_delete_forever_ic_icon.png")));
		btnDelete.setBounds(546, 392, 64, 64);
		getContentPane().add(btnDelete);

		btnRead = new JButton("");
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarIdFor();
			}
		});
		btnRead.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/search.png")));
		btnRead.setBounds(223, 160, 24, 21);
		getContentPane().add(btnRead);

		lblStatus = new JLabel("");
		lblStatus.setBounds(590, 373, 16, 16);
		getContentPane().add(lblStatus);

		// validaï¿½ï¿½o somente nï¿½meros
		RestrictedTextField validarIdFor = new RestrictedTextField(txtIdFor);
		RestrictedTextField validarCnpj = new RestrictedTextField(txtCnpj);
		RestrictedTextField validarIe = new RestrictedTextField(txtIe);
		RestrictedTextField validarCep = new RestrictedTextField(txtCep);
		RestrictedTextField validarNumero = new RestrictedTextField(txtNumero);
		RestrictedTextField validarFone = new RestrictedTextField(txtFone);
		// RestrictedTextField validarWhatsapp = new RestrictedTextField(txtWhatsapp);
		RestrictedTextField validarComplemento = new RestrictedTextField(txtComplemento);
		// validarWhatsapp.setLimit(15);
		validarFone.setLimit(15);
		validarNumero.setLimit(6);
		validarCep.setLimit(10);
		validarIdFor.setLimit(15);
		validarCnpj.setLimit(20);
		validarIe.setLimit(20);
		validarComplemento.setLimit(20);

		// validaï¿½ï¿½o somente caracteres
		RestrictedTextField validarrazaoSocial = new RestrictedTextField(txtRazaoSocial);
		validarrazaoSocial.setOnlyText(true);
		validarrazaoSocial.setAcceptSpace(true);
		validarrazaoSocial.setLimit(50);
		RestrictedTextField validarFantasia = new RestrictedTextField(txtNomeFantasia);
		validarFantasia.setOnlyText(true);
		validarFantasia.setAcceptSpace(true);
		validarFantasia.setLimit(50);
		RestrictedTextField validarEndereco = new RestrictedTextField(txtEndereco);
		validarEndereco.setAcceptSpace(true);
		validarEndereco.setLimit(50);
		RestrictedTextField validarBairro = new RestrictedTextField(txtBairro);
		validarBairro.setOnlyText(true);
		validarBairro.setAcceptSpace(true);
		validarBairro.setLimit(50);
		RestrictedTextField validarCidade = new RestrictedTextField(txtCidade);
		validarCidade.setOnlyText(true);
		validarCidade.setAcceptSpace(true);
		validarCidade.setLimit(50);
		RestrictedTextField validarContato = new RestrictedTextField(txtNomeContato);
		validarContato.setOnlyText(true);
		validarContato.setAcceptSpace(true);
		validarContato.setLimit(50);
		// RestrictedTextField validarEmail = new RestrictedTextField(txtEmail);
		// validarEmail.setLimit(50);

		RestrictedTextField validarSite = new RestrictedTextField(txtSite);
		validarSite.setLimit(50);
		RestrictedTextField validarObs = new RestrictedTextField(txtObs);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 646, 107);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		validarObs.setLimit(250);

	}// fim do construtor

	/**
	 * criar um objeto para acessar o metodo conectar () da classe DAO
	 */

	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnRead;
	private JComboBox<Object> cboUf;
	private JLabel lblStatus;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnBuscar;

	private void pesquisarFornecedor() {

		/**
		 * Mï¿½todo responsavel pela pesquisa avanï¿½ada usandro filtro
		 */

		String read2 = "select idFor as ID, fantasia as Fornecedor , fone, nomeContato as contato from fornecedores where fantasia like ?";

		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtPesquisar.getText() + "%"); // %
			ResultSet rs = pst.executeQuery();
			// uso da biblioteca rs2xml para popular a tabela
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	void pesquisarIdFor() {
		// validaï¿½ï¿½o
		if (txtIdFor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o seu Id");
			txtIdFor.requestFocus();
		} else {

			// Iniciar com a instruï¿½ï¿½o sql
			// ? ï¿½ um parï¿½metro a ser substituï¿½do
			String read = "select * from fornecedores where idFor = ?";
			try {
				// Estabelecer a conexï¿½o ("abrir a porta da geladeira")
				Connection con = dao.conectar();
				// Preparar o cï¿½digo sql para execuï¿½ï¿½o
				PreparedStatement pst = con.prepareStatement(read);
				// a linha abaixo substitui o ? pelo conteï¿½do da caixa de texto txtNome, o 1 faz
				// referï¿½ncia a interrogaï¿½ï¿½o
				pst.setString(1, txtIdFor.getText());
				// Obter os dados dos fornecedores ( id resultado)
				ResultSet rs = pst.executeQuery();
				// verificar se existe um contato cadastrado
				// rs.next() significa ter um contato correspondente ao nome pesquisado
				if (rs.next()) {

					// setar as caixas de texto com o resultado da pesquisa

					txtIdFor.setText(rs.getString(1));
					txtRazaoSocial.setText(rs.getString(2));
					txtNomeFantasia.setText(rs.getString(3));
					txtCnpj.setText(rs.getString(4));
					txtIe.setText(rs.getString(5));
					txtCep.setText(rs.getString(6));
					txtEndereco.setText(rs.getString(7));
					txtNumero.setText(rs.getString(9));
					txtComplemento.setText(rs.getString(8));
					txtBairro.setText(rs.getString(10));
					txtCidade.setText(rs.getString(11));
					cboUf.setSelectedItem(rs.getString(12));
					txtNomeContato.setText(rs.getString(13));
					txtFone.setText(rs.getString(14));
					txtWhatsapp.setText(rs.getString(15));
					txtEmail.setText(rs.getString(16));
					txtSite.setText(rs.getString(17));
					txtObs.setText(rs.getString(18));
					
					//habilitar botÃµes (alterar ou excluir)
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnRead.setEnabled(true);
					btnBuscar.setEnabled(true);
					txtIdFor.setEnabled(true);
					txtRazaoSocial.setEnabled(true);
					txtNomeFantasia.setEnabled(true);
					txtCnpj.setEnabled(true);
					txtIe.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtNumero.setEnabled(true);
					txtComplemento.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setSelectedItem(rs.getString(12));
					txtNomeContato.setEnabled(true);
					txtFone.setEnabled(true);
					txtWhatsapp.setEnabled(true);
					txtEmail.setEnabled(true);
					txtSite.setEnabled(true);
					txtObs.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");
					
					//habilitar botÃµes (alterar ou excluir)
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnRead.setEnabled(true);
					btnBuscar.setEnabled(true);
					txtIdFor.setEnabled(true);
					txtRazaoSocial.setEnabled(true);
					txtNomeFantasia.setEnabled(true);
					txtCnpj.setEnabled(true);
					txtIe.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtNumero.setEnabled(true);
					txtComplemento.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setSelectedItem(rs.getString(12));
					txtNomeContato.setEnabled(true);
					txtFone.setEnabled(true);
					txtWhatsapp.setEnabled(true);
					txtEmail.setEnabled(true);
					txtSite.setEnabled(true);
					txtObs.setEnabled(true);
				}
				// fechar a conexï¿½o
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // fim do pesquisar idfor

	/**
	 * Mï¿½todo responsï¿½vel pelo cadastro de um novo usuario
	 */
	private void adicionarFornecedor() {

		// validaï¿½ï¿½o de campos obrigatï¿½rios
		if (txtRazaoSocial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Razão Social");
			txtRazaoSocial.requestFocus();

		} else if (txtNomeFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome Fantasia ");
			txtNomeFantasia.requestFocus();

		} else if (txtCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CNPJ ");
			txtCnpj.requestFocus();
		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Inscrição Estadual");
			txtIe.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP ");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Endereço ");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Número");
			txtNumero.requestFocus();
		
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Bairro ");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Cidade ");
			txtCidade.requestFocus();
		} else if (cboUf.getSelectedItem().equals(null)) {
			JOptionPane.showMessageDialog(null, "Insira a UF ");
			cboUf.requestFocus();
		} else if (txtNomeContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome para Contato ");
			txtNomeContato.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Telefone ");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o E-mail ");
			txtEmail.requestFocus();

		} else {
			String create = "insert into fornecedores (razaoSocial,fantasia,cnpj, ie, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone, email, whatsapp, obs, site) values  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				// Abrir a conexï¿½o
				Connection con = dao.conectar();
				// Preparar a query (substituiï¿½ï¿½o de parï¿½metros)
				PreparedStatement pst = con.prepareStatement(create);

				// setar as caixas de texto com o resultado da pesquisa

				pst.setString(1, txtRazaoSocial.getText());
				pst.setString(2, txtNomeFantasia.getText());
				pst.setString(3, txtCnpj.getText());
				pst.setString(4, txtIe.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtNomeContato.getText());
				pst.setString(13, txtFone.getText());
				pst.setString(14, txtEmail.getText());
				pst.setString(15, txtWhatsapp.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObs.getText());

	
				// Executar a query e confirmar a inserção no banco

				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso");
					limpar();
				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Fornecedor não adicionado");
				}

				// Encerrar a conexï¿½o
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "CNPJ: Duplicado");

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	private void atualizarFornecedor() {

		// validaï¿½ï¿½o de campos obrigatï¿½rios
		if (txtRazaoSocial.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Razão Social");
			txtRazaoSocial.requestFocus();

		} else if (txtNomeFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome Fantasia ");
			txtNomeFantasia.requestFocus();

		} else if (txtCnpj.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CNPJ ");
			txtCnpj.requestFocus();
		} else if (txtIe.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Inscrição Estadual");
			txtIe.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP ");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Endereço ");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Número");
			txtNumero.requestFocus();
		
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Bairro ");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Cidade ");
			txtCidade.requestFocus();
		} else if (cboUf.getSelectedItem().equals(null)) {
			JOptionPane.showMessageDialog(null, "Insira a UF ");
			cboUf.requestFocus();
		} else if (txtNomeContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome para Contato ");
			txtNomeContato.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Telefone ");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o E-mail ");
			txtEmail.requestFocus();

		} else {
			String update = "update fornecedores set razaoSocial = ?, fantasia = ?, cnpj = ?, ie = ?, cep = ?,endereco = ?,complemento = ?,numero = ?,bairro = ?,cidade = ?,uf = ?, nomeContato = ?, fone = ?, whatsapp = ?, email = ?, site = ?, obs  = ? where IdFor = ?";
			try {
				// Abrir a conexï¿½o
				Connection con = dao.conectar();
				// Preparar a query (substituiï¿½ï¿½o de parï¿½metros)
				PreparedStatement pst = con.prepareStatement(update);

				// setar as caixas de texto com o resultado da pesquisa

				pst.setString(1, txtRazaoSocial.getText());
				pst.setString(2, txtNomeFantasia.getText());
				pst.setString(3, txtCnpj.getText());
				pst.setString(4, txtIe.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNumero.getText());
				pst.setString(8, txtComplemento.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtCidade.getText());
				pst.setString(11, cboUf.getSelectedItem().toString());
				pst.setString(12, txtNomeContato.getText());
				pst.setString(13, txtFone.getText());
				pst.setString(14, txtWhatsapp.getText());
				pst.setString(15, txtEmail.getText());
				pst.setString(16, txtSite.getText());
				pst.setString(17, txtObs.getText());
				pst.setString(18, txtIdFor.getText());

				// Executar a query e confirmar a inserï¿½ï¿½o no banco

				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");
					limpar();
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Fornecedor já existente");
				}
				limpar();
				// Encerrar a conexï¿½o
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇÃO! CPNJ: Duplicado");
				
				txtCnpj.setText(null);
				txtCnpj.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	private void excluirFornecedor() {

		// validaï¿½ï¿½o (confirmaï¿½ï¿½o)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste usuario?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);

		if (confirma == JOptionPane.YES_OPTION) {
			// logica principal
			String delete = "delete from fornecedores where idFor = ?";
			try {
				// abrir conexï¿½o
				Connection con = dao.conectar();

				// preparar a query
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtIdFor.getText());

				// executar o comando sql e confirmar a exclusï¿½o
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso!");
					btnRead.setEnabled(true);
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "ERRO: na exclusão do usuario");
				}
				// encerrar a conexï¿½o
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR: ATENÇÃO! Fornecedor relacioanado a outra tabela");

			
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	// cep

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			org.dom4j.Document documento = xml.read(url);
			Element root = ((org.dom4j.Document) documento).getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}

				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
				}
				if (resultado.equals("1")) {
					lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
				} else {
					JOptionPane.showMessageDialog(null, "CEP não encontrado");
				}
			}
// setar o campo endereco
			txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// limpar campos

	private void limpar() {

		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		txtIdFor.setText(null);
		txtRazaoSocial.setText(null);
		txtNomeFantasia.setText(null);
		txtCnpj.setText(null);
		txtIe.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		txtNomeContato.setText(null);
		txtFone.setText(null);
		txtWhatsapp.setText(null);
		txtEmail.setText(null);
		txtSite.setText(null);
		txtObs.setText(null);
		lblStatus.setIcon(null);
		//((DefaultTableModel) table.getModel()).setRowCount(0);
	}
}// fim do codigo
