package views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class Clientes extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField txtCep;
	private JTextField txtWhatsapp;
	private JTextField txtNomeContato;
	private JTextField txtContato;
	private JTextField txtIdCli;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/clientes.png")));
		setTitle("Clientes");
		setBounds(100, 100, 659, 485);
		getContentPane().setLayout(null);

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereo.setBounds(29, 278, 119, 14);
		getContentPane().add(lblEndereo);

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(99, 275, 198, 20);
		getContentPane().add(txtEndereco);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBairro.setBounds(39, 307, 119, 14);
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(99, 304, 198, 20);
		getContentPane().add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(44, 335, 45, 14);
		getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(99, 332, 198, 20);
		getContentPane().add(txtCidade);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(387, 338, 54, 22);
		getContentPane().add(cboUf);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUf.setBounds(350, 345, 53, 14);
		getContentPane().add(lblUf);

		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(539, 310, 54, 20);
		getContentPane().add(txtComplemento);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComplemento.setBounds(453, 313, 103, 14);
		getContentPane().add(lblComplemento);

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
		txtNumero.setBounds(372, 310, 54, 20);
		getContentPane().add(txtNumero);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumero.setBounds(318, 313, 45, 14);
		getContentPane().add(lblNumero);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCep.setBounds(318, 282, 45, 14);
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
		txtCep.setBounds(350, 279, 115, 20);
		getContentPane().add(txtCep);

		btnBuscar = new JButton("Buscar CEP");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnBuscar.setBounds(485, 278, 109, 23);
		getContentPane().add(btnBuscar);

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
		txtWhatsapp.setBounds(474, 224, 95, 20);
		getContentPane().add(txtWhatsapp);

		JLabel lblWhatsapp = new JLabel("Whatsapp");
		lblWhatsapp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWhatsapp.setBounds(407, 227, 57, 14);
		getContentPane().add(lblWhatsapp);

		txtNomeContato = new JTextField();
		txtNomeContato.setColumns(10);
		txtNomeContato.setBounds(138, 227, 115, 20);
		getContentPane().add(txtNomeContato);

		txtContato = new JTextField();
		txtContato.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtContato.setColumns(10);
		txtContato.setBounds(300, 227, 95, 20);
		getContentPane().add(txtContato);

		JLabel lblFone = new JLabel("Fone");
		lblFone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFone.setBounds(263, 228, 45, 14);
		getContentPane().add(lblFone);

		JLabel lblContato = new JLabel("Nome Contato");
		lblContato.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContato.setBounds(49, 227, 99, 14);
		getContentPane().add(lblContato);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(70, 137, 45, 14);
		getContentPane().add(lblId);

		txtIdCli = new JTextField();
		txtIdCli.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtIdCli.setColumns(10);
		txtIdCli.setBounds(99, 134, 126, 20);
		getContentPane().add(txtIdCli);

		btnRead = new JButton("");
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setIcon(new ImageIcon(Clientes.class.getResource("/img/3844432_magnifier_search_zoom_icon.png")));
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliente();
			}
		});
		btnRead.setBounds(235, 130, 32, 32);
		getContentPane().add(btnRead);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCpf.setBounds(276, 140, 45, 14);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCpf.setColumns(10);
		txtCpf.setBounds(315, 137, 150, 20);
		getContentPane().add(txtCpf);

		btnCreate = new JButton("");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarCliente();
			}
		});
		btnCreate.setIcon(new ImageIcon(Clientes.class.getResource("/img/211872_person_add_icon.png")));
		btnCreate.setBounds(201, 371, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarCliente();
			}
		});
		btnUpdate.setIcon(new ImageIcon(Clientes.class.getResource("/img/211882_refresh_icon.png")));
		btnUpdate.setBounds(297, 371, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirCliente();
			}
		});
		btnDelete.setIcon(new ImageIcon(Clientes.class.getResource("/img/3669360_delete_forever_ic_icon.png")));
		btnDelete.setBounds(380, 371, 64, 64);
		getContentPane().add(btnDelete);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setBounds(134, 168, 119, 14);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(186, 165, 225, 20);
		getContentPane().add(txtNome);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(134, 196, 119, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(186, 193, 225, 20);
		getContentPane().add(txtEmail);

		txtPesquisar2 = new JTextField();
		txtPesquisar2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarCli();
			}
		});
		txtPesquisar2.setColumns(10);
		txtPesquisar2.setBounds(81, 11, 171, 20);
		getContentPane().add(txtPesquisar2);

		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setBounds(29, 14, 45, 14);
		getContentPane().add(lblCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 38, 602, 86);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// validaï¿½ï¿½o somente nï¿½meros

		RestrictedTextField validarCpf = new RestrictedTextField(txtCpf);
		RestrictedTextField validarCep = new RestrictedTextField(txtCep);
		RestrictedTextField validarNumero = new RestrictedTextField(txtNumero);
		RestrictedTextField validarFone = new RestrictedTextField(txtContato);
		RestrictedTextField validarWhatsapp = new RestrictedTextField(txtWhatsapp);
		RestrictedTextField validarComplemento = new RestrictedTextField(txtComplemento);
		validarWhatsapp.setLimit(15);
		validarFone.setLimit(15);
		validarNumero.setLimit(6);
		validarCep.setLimit(10);
		validarCpf.setLimit(11);
		validarComplemento.setLimit(20);

		// validacao somente caracteres

		RestrictedTextField validarNome = new RestrictedTextField(txtNome);
		validarNome.setOnlyText(true);
		validarNome.setAcceptSpace(true);
		validarNome.setLimit(50);
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
		RestrictedTextField validarEmail = new RestrictedTextField(txtEmail);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(604, 275, 32, 32);
		getContentPane().add(lblStatus);
		validarEmail.setLimit(50);

	}// fim do construtor

	// conectar banco de dados
	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnBuscar;
	private JButton btnRead;
	private JComboBox<?> cboUf;
	private JTextField txtPesquisar2;
	private JLabel lblCliente;
	private JTable table;
	private JLabel lblStatus;

	private void pesquisarCli() {

		String read2 = "select idCli as ID, nome as Cliente,  email as Email, fone as Contato from clientes where nome like ?";

		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtPesquisar2.getText() + "%"); // %
			ResultSet rs = pst.executeQuery();
			// uso da biblioteca rs2xml para popular a tabela
			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// pesquisar cliente
	void pesquisarCliente() {

		// validacao
		if (txtIdCli.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o seu Id");
			txtIdCli.requestFocus();
		} else {

			// Iniciar com a instruÃ§Ã£o sql
			// ? ï¿½ um parï¿½metro a ser substituï¿½do
			String read = "select * from clientes where idCli = ?";
			try {
				// Estabelecer a conexï¿½o ("abrir a porta da geladeira")
				Connection con = dao.conectar();
				// Preparar o cï¿½digo sql para execuï¿½ï¿½o
				PreparedStatement pst = con.prepareStatement(read);
				// a linha abaixo substitui o ? pelo conteï¿½do da caixa de texto txtNome, o 1 faz
				// referï¿½ncia a interrogaï¿½ï¿½o
				pst.setString(1, txtIdCli.getText());
				// Obter os dados dos fornecedores ( id resultado)
				ResultSet rs = pst.executeQuery();
				// verificar se existe um contato cadastrado
				// rs.next() significa ter um contato correspondente ao nome pesquisado
				if (rs.next()) {

					// setar as caixas de texto com o resultado da pesquisa

					txtIdCli.setText(rs.getString(1));
					txtNome.setText(rs.getString(2));
					txtCpf.setText(rs.getString(3));
					txtEmail.setText(rs.getString(4));
					txtCep.setText(rs.getString(5));
					txtEndereco.setText(rs.getString(6));					
					txtNumero.setText(rs.getString(7));
					txtComplemento.setText(rs.getString(8));
					txtBairro.setText(rs.getString(9));
					txtCidade.setText(rs.getString(10));
					cboUf.setSelectedItem(rs.getString(11));
					txtNomeContato.setText(rs.getString(12));
					txtContato.setText(rs.getString(13));
					txtWhatsapp.setText(rs.getString(14));

					// habilitar botÃµes (alterar ou excluir)
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnRead.setEnabled(true);
					btnBuscar.setEnabled(true);
					txtIdCli.setEnabled(true);
					txtNome.setEnabled(true);
					txtCpf.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtNumero.setEnabled(true);
					txtComplemento.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setSelectedItem(rs.getString(11));
					txtNomeContato.setEnabled(true);
					txtContato.setEnabled(true);
					txtWhatsapp.setEnabled(true);
					txtEmail.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Cliente inexistente");

					btnCreate.setEnabled(true);
					limpar();
					txtIdCli.requestFocus();	
					}
			
				// fechar a conexï¿½o
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // fim do pesquisar idCli

	
	// adicionar cliente
	
	private void adicionarCliente() {

		// validaï¿½ï¿½o de campos obrigatï¿½rios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira seu Nome");
			txtNome.requestFocus();

		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CPF ");
			txtCpf.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP ");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Endereço");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o = Número");
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
		} else if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Telefone ");
			txtContato.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o E-mail ");
			txtEmail.requestFocus();

		} else {
			String create = "insert into clientes (nome, cpf, email, cep, endereco, numero, complemento, bairro, cidade, uf, nomeContato, fone, whatsapp) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				// Abrir a conexï¿½o
				Connection con = dao.conectar();
				// Preparar a query (substituiï¿½ï¿½o de parï¿½metros)
				PreparedStatement pst = con.prepareStatement(create);

				// setar as caixas de texto com o resultado da pesquisa

				pst.setString(1, txtNome.getText());
				pst.setString(2, txtCpf.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtCep.getText());
				pst.setString(5, txtEndereco.getText());
				pst.setString(6, txtNumero.getText());
				pst.setString(7, txtComplemento.getText());
				pst.setString(8, txtBairro.getText());
				pst.setString(9, txtCidade.getText());
				pst.setString(10, cboUf.getSelectedItem().toString());
				pst.setString(11, txtNomeContato.getText());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtWhatsapp.getText());

				// Executar a query e confirmar a inserção no banco

				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso");
					limpar();
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnRead.setEnabled(true);
				
				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Cliente não adicionado");
				}

				// Encerrar a conexï¿½o
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇAO! CPF DUPLICADO");
				

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	// atualizar cliente

	private void atualizarCliente() {

		// validaï¿½ï¿½o de campos obrigatï¿½rios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome");
			txtNome.requestFocus();

		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CPF ");
			txtCpf.requestFocus();

		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP ");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Endereco ");
			txtEndereco.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Numero");
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
		} else if (txtContato.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Telefone ");
			txtContato.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o E-mail ");
			txtEmail.requestFocus();

		} else {
			String update = "update clientes set nome = ?, cpf = ?, email = ?, cep = ?,endereco = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,uf = ?, nomeContato = ?, fone = ?, whatsapp = ? where IdCli = ?";
			try {
				// Abrir a conexï¿½o
				Connection con = dao.conectar();
				// Preparar a query (substituiï¿½ï¿½o de parï¿½metros)
				PreparedStatement pst = con.prepareStatement(update);

				// setar as caixas de texto com o resultado da pesquisa

				pst.setString(1, txtNome.getText());
				pst.setString(2, txtCpf.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtCep.getText());
				pst.setString(5, txtEndereco.getText());
				pst.setString(6, txtNumero.getText());
				pst.setString(7, txtComplemento.getText());
				pst.setString(8, txtBairro.getText());
				pst.setString(9, txtCidade.getText());
				pst.setString(10, cboUf.getSelectedItem().toString());
				pst.setString(11, txtNomeContato.getText());
				pst.setString(12, txtContato.getText());
				pst.setString(13, txtWhatsapp.getText());
				pst.setString(14, txtIdCli.getText());

				// Executar a query e confirmar a inserï¿½ï¿½o no banco

				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso");
				
					limpar();
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					btnRead.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "ERRO - Cliente não atualizado");
					
				}
		
				// Encerrar a conexï¿½o
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇÃO! CPF Duplicado");
				txtCpf.setText(null);
				txtCpf.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
	
	// excluir cliente

	private void excluirCliente() {

		// validaï¿½ï¿½o (confirmaï¿½ï¿½o)
		int confirma = JOptionPane.showConfirmDialog(null,  "Confirma a exclusão deste usuario?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);

		if (confirma == JOptionPane.YES_OPTION) {
			// logica principal
			String delete = "delete from clientes where idCli = ?";
			try {
				// abrir conexï¿½o
				Connection con = dao.conectar();

				// preparar a query
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtIdCli.getText());

				// executar o comando sql e confirmar a exclusï¿½o
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					btnRead.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "ERRO na exclusão do usuario");
					;
				}
			
				btnCreate.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				btnRead.setEnabled(true);
				
				// encerrar a conexão
				con.close();

			} catch (Exception e) {
				System.out.println(e);
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
			
			txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void limpar() {
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		txtIdCli.setText(null);
		txtNome.setText(null);
		txtCpf.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		txtNomeContato.setText(null);
		txtContato.setText(null);
		txtWhatsapp.setText(null);
		txtEmail.setText(null);
		lblStatus.setIcon(null);
		((DefaultTableModel) table.getModel()).setRowCount(0);
	}
}// fim do codigo
