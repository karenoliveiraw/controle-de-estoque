package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Produtos extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBarcode;
	private JTextField txtCodigo;
	private JTextField txtProduto;
	private JTextField txtFabricante;
	private JTextField txtEstoquemin;
	private JTextField txtLocal;
	private JTextField txtFornecedor;
	private JTextField txtId;
	private JTextField txtCusto;
	private JTextField txtLucro;
	private JTable table;
	private JTextField txtEstoque;
	private JTextArea txtaDescricao;
	@SuppressWarnings("rawtypes")
	private JComboBox cboUnidade;
	private JDateChooser dateEntrada;
	private JDateChooser dateValidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos dialog = new Produtos();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Produtos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtBarcode.requestFocus();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produtos.class.getResource("/img/products.png")));
		setTitle("Produtos");
		setModal(true);
		setBounds(100, 100, 807, 468);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Produtos.class.getResource("/img/barcode.png")));
		lblNewLabel.setBounds(10, 23, 64, 45);
		getContentPane().add(lblNewLabel);

		txtBarcode = new JTextField();
		txtBarcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// leitor de codigo de barras
				// evento ao pressionar uma tecla específica (ENTER)
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					pesquisarProdutoBarcode();
				}
			}
		});
		txtBarcode.setBounds(85, 37, 231, 20);
		getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(24, 95, 46, 14);
		getContentPane().add(lblNewLabel_1);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProduto();

			}
		});
		btnPesquisar.setToolTipText("Pesquisar C\u00F3digo");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBounds(217, 91, 99, 23);
		getContentPane().add(btnPesquisar);

		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(85, 92, 122, 20);
		getContentPane().add(txtCodigo);

		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		txtProduto.setBounds(85, 138, 231, 20);
		getContentPane().add(txtProduto);

		JLabel lblNewLabel_1_1 = new JLabel("Produto");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(24, 141, 46, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(10, 212, 64, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Fabricante");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2.setBounds(10, 298, 76, 14);
		getContentPane().add(lblNewLabel_1_1_2);

		txtFabricante = new JTextField();
		txtFabricante.setColumns(10);
		txtFabricante.setBounds(85, 295, 231, 20);
		getContentPane().add(txtFabricante);

		JLabel lblNewLabel_1_2 = new JLabel("Estoque");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(28, 340, 46, 14);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Estoque m\u00EDnimo");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2_1.setBounds(161, 340, 97, 14);
		getContentPane().add(lblNewLabel_1_2_1);

		txtEstoquemin = new JTextField();
		txtEstoquemin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEstoquemin.setColumns(10);
		txtEstoquemin.setBounds(256, 337, 60, 20);
		getContentPane().add(txtEstoquemin);

		JLabel lblNewLabel_1_2_2 = new JLabel("Unidade");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2_2.setBounds(24, 385, 46, 14);
		getContentPane().add(lblNewLabel_1_2_2);

		cboUnidade = new JComboBox();
		cboUnidade.setModel(new DefaultComboBoxModel(new String[] { "", "UN", "PC", "CX", "KG", "g", "M", "CM" }));
		cboUnidade.setBounds(85, 381, 57, 22);
		getContentPane().add(cboUnidade);

		JLabel lblNewLabel_1_1_3 = new JLabel("Local");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_3.setBounds(151, 385, 46, 14);
		getContentPane().add(lblNewLabel_1_1_3);

		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		txtLocal.setBounds(184, 382, 132, 20);
		getContentPane().add(txtLocal);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Fornecedor", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(385, 24, 381, 182);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtFornecedor = new JTextField();
		txtFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarProd();
			}
		});
		txtFornecedor.setText("");
		txtFornecedor.setBounds(10, 30, 146, 20);
		panel.add(txtFornecedor);
		txtFornecedor.setColumns(10);

		JLabel txt = new JLabel("");
		txt.setIcon(new ImageIcon(Produtos.class.getResource("/img/search.png")));
		txt.setBounds(166, 24, 32, 32);
		panel.add(txt);

		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		txtId.setText("");
		txtId.setColumns(10);
		txtId.setBounds(232, 30, 122, 20);
		panel.add(txtId);

		JLabel lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(211, 33, 46, 14);
		panel.add(lblNewLabel_1_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 361, 110);
		panel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null }, { null, null }, { null, null }, { null, null }, { null, null }, },
				new String[] { "ID", "Fornecedor" }));
		scrollPane.setViewportView(table);

		dateEntrada = new JDateChooser();
		dateEntrada.setEnabled(false);
		dateEntrada.getCalendarButton().setEnabled(false);
		dateEntrada.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateEntrada.setEnabled(false);
			}
		});
		dateEntrada.setForeground(Color.RED);
		dateEntrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
					dateEntrada.setEnabled(false);
				}
			}
		});
		dateEntrada.setBounds(442, 222, 126, 20);
		getContentPane().add(dateEntrada);

		JLabel lblNewLabel_1_1_4 = new JLabel("Entrada");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_4.setBounds(385, 222, 46, 14);
		getContentPane().add(lblNewLabel_1_1_4);

		JLabel lblNewLabel_1_1_4_1 = new JLabel("Validade");
		lblNewLabel_1_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_4_1.setBounds(578, 222, 64, 14);
		getContentPane().add(lblNewLabel_1_1_4_1);

		dateValidade = new JDateChooser();
		dateValidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		dateValidade.setBounds(635, 222, 131, 20);
		getContentPane().add(dateValidade);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Custo");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2_1.setBounds(396, 273, 46, 14);
		getContentPane().add(lblNewLabel_1_1_2_1);

		txtCusto = new JTextField();
		txtCusto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCusto.setColumns(10);
		txtCusto.setBounds(442, 270, 126, 20);
		getContentPane().add(txtCusto);

		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Lucro");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2_1_1.setBounds(590, 273, 46, 14);
		getContentPane().add(lblNewLabel_1_1_2_1_1);

		txtLucro = new JTextField();
		txtLucro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtLucro.setColumns(10);
		txtLucro.setBounds(635, 270, 118, 20);
		getContentPane().add(txtLucro);

		btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarProduto();
			}
		});
		btnCreate.setToolTipText("Criar um Produto");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxadd.png")));
		btnCreate.setBounds(461, 325, 64, 64);
		getContentPane().add(btnCreate);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarProduto();
			}
		});
		btnUpdate.setToolTipText("Atualizar um Produto");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxupdate.png")));
		btnUpdate.setBounds(546, 325, 64, 64);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
			}
		});
		btnDelete.setToolTipText("Deletar um produto");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxdel.png")));
		btnDelete.setBounds(631, 325, 64, 64);
		getContentPane().add(btnDelete);

		txtEstoque = new JTextField();
		txtEstoque.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(85, 337, 56, 20);
		getContentPane().add(txtEstoque);

		txtaDescricao = new JTextArea();
		txtaDescricao.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtaDescricao.setBounds(85, 186, 231, 86);
		getContentPane().add(txtaDescricao);

		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("%");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2_1_1_1.setBounds(755, 273, 64, 17);
		getContentPane().add(lblNewLabel_1_1_2_1_1_1);

		// validar setlimit

		RestrictedTextField validarBarcode = new RestrictedTextField(txtBarcode);
		RestrictedTextField validarProduto = new RestrictedTextField(txtProduto);
		RestrictedTextField validarFabricante = new RestrictedTextField(txtFabricante);
		RestrictedTextField validarLocal = new RestrictedTextField(txtLocal);
		RestrictedTextField validarLucro = new RestrictedTextField(txtLucro);
		RestrictedTextField validarCusto = new RestrictedTextField(txtCusto);
		// RestrictedTextField validarDescricao = new
		// RestrictedTextField(txtaDescricao);
		// validarDescricao.setLimit(255);
		validarCusto.setLimit(10);
		validarLucro.setLimit(10);
		validarBarcode.setLimit(255);
		validarProduto.setLimit(50);
		validarFabricante.setLimit(50);
		validarLocal.setLimit(50);

	}// fim do construtor

	// conectar banco de dados

	DAO dao = new DAO();
	private JButton btnCreate;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnPesquisar;

	private void pesquisarProd() {

		String read3 = "select idFor as ID, fantasia as Fornecedor from fornecedores where fantasia like ?";

		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			pst.setString(1, txtFornecedor.getText() + "%"); // %
			ResultSet rs = pst.executeQuery();

			// uso da biblioteca rs2xml para popular a tabela
			table.setModel(DbUtils.resultSetToTableModel(rs));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void pesquisarProduto() {
		// validação
		if (txtCodigo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o código");
			txtCodigo.requestFocus();
		} else {

			// Iniciar com a instruï¿½ï¿½o sql
			// ? um parametro a ser substituido
			String read = "select * from produtos where codigo = ?";
			try {
				// Estabelecer a conexão ("abrir a porta da geladeira")
				Connection con = dao.conectar();
				// Preparar o código sql para execução
				PreparedStatement pst = con.prepareStatement(read);
				// a linha abaixo substitui o ? pelo conteudo da caixa de texto txtNome, o 1
				// referencia interrogação
				pst.setString(1, txtCodigo.getText());
				// Obter os dados dos produtos
				ResultSet rs = pst.executeQuery();
				// verificar se existe um produto cadastrado
				// rs.next() significa ter um contato correspondente ao produto pesquisado
				if (rs.next()) {

					// setar as caixas de texto com o resultado da pesquisa

					txtBarcode.setText(rs.getString(2));
					txtProduto.setText(rs.getString(3));
					txtaDescricao.setText(rs.getString(4));
					txtFabricante.setText(rs.getString(5));
					// formatacao da data recebida pelo mysql
					// jcalendar - formatação para exibição
					// setar data de entrada
					String setarData = rs.getString(6);
					Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
					dateEntrada.setDate(dataFormatada);

					// setar data de validade
					String setarData2 = rs.getString(7);
					Date dataFormatada2 = new SimpleDateFormat("yyyy-MM-dd").parse(setarData2);
					dateValidade.setDate(dataFormatada2);
					// fim da formatação recebida pelo mysql
					txtEstoque.setText(rs.getString(8));
					txtEstoquemin.setText(rs.getString(9));
					cboUnidade.setSelectedItem(rs.getString(10));
					txtLocal.setText(rs.getString(11));
					txtCusto.setText(rs.getString(12));
					txtLucro.setText(rs.getString(13));
					txtId.setText(rs.getString(14));
					btnCreate.setEnabled(false);
					btnDelete.setEnabled(true);
					btnUpdate.setEnabled(true);
					dateValidade.setEnabled(false);
					txtCodigo.setEnabled(false);
					btnPesquisar.setEnabled(false);
					txtBarcode.setEnabled(false);
					txtId.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "ATENÇÃO: Produto não existente");
					limpar();
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					dateValidade.setEnabled(true);
					btnPesquisar.setEnabled(false);
					txtCodigo.setEditable(false);
					txtBarcode.requestFocus();
					txtId.setEnabled(true);

				}
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // fim do pesquisar produto

	private void pesquisarProdutoBarcode() {
		// validação
		if (txtBarcode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Bar code");
			txtBarcode.requestFocus();
		} else {

			// Iniciar com a instruï¿½ï¿½o sql
			// ? um parametro a ser substituido
			String read = "select * from produtos where barcode = ?";
			try {
				// Estabelecer a conexão ("abrir a porta da geladeira")
				Connection con = dao.conectar();
				// Preparar o código sql para execução
				PreparedStatement pst = con.prepareStatement(read);
				// a linha abaixo substitui o ? pelo conteudo da caixa de texto txtNome, o 1
				// referencia interrogação
				pst.setString(1, txtBarcode.getText());
				// Obter os dados dos produtos
				ResultSet rs = pst.executeQuery();
				// verificar se existe um produto cadastrado
				// rs.next() significa ter um contato correspondente ao produto pesquisado
				if (rs.next()) {

					// setar as caixas de texto com o resultado da pesquisa

					txtCodigo.setText(rs.getString(1));
					txtProduto.setText(rs.getString(3));
					txtaDescricao.setText(rs.getString(4));
					txtFabricante.setText(rs.getString(5));
					// formatacao da data recebida pelo mysql
					// jcalendar - formatação para exibição
					// setar data de entrada
					String setarData = rs.getString(6);
					Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
					dateEntrada.setDate(dataFormatada);

					// setar data de validade
					String setarData2 = rs.getString(7);
					Date dataFormatada2 = new SimpleDateFormat("yyyy-MM-dd").parse(setarData2);
					dateValidade.setDate(dataFormatada2);
					// fim da formatação recebida pelo mysql

					txtEstoque.setText(rs.getString(8));
					txtEstoquemin.setText(rs.getString(9));
					cboUnidade.setSelectedItem(rs.getString(10));
					txtLocal.setText(rs.getString(11));
					txtCusto.setText(rs.getString(12));
					txtLucro.setText(rs.getString(13));
					txtId.setText(rs.getString(14));
					btnCreate.setEnabled(false);
					btnDelete.setEnabled(true);
					btnUpdate.setEnabled(true);
					dateValidade.setEnabled(false);
					txtCodigo.setEnabled(false);
					btnPesquisar.setEnabled(false);
					txtBarcode.setEnabled(false);
					txtId.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "ATENÇÃO: Produto não cadastrado");

					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					btnPesquisar.setEnabled(false);
					txtCodigo.setEditable(false);
					txtBarcode.setEnabled(true);
					txtId.setEnabled(true);
					dateValidade.setEnabled(true);

				}
				// fechar a conexão
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	} // fim do pesquisar produto

	// adicionar produto

	private void adicionarProduto() {

		// valdação de campos obrigatorios
		if (txtBarcode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o barcode ");
			txtBarcode.requestFocus();

		} else if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID do Fornecedor");
			txtProduto.requestFocus();

		} else if (txtProduto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Produto");
			txtProduto.requestFocus();
		} else if (txtFabricante.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Fabricante");
			txtFabricante.requestFocus();
		} else if (dateValidade.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Insira a data de validade");
			dateValidade.requestFocus();

		} else if (txtEstoque.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o estoque ");
			txtEstoque.requestFocus();
		} else if (txtEstoquemin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o estoque mínimo");
			txtEstoquemin.requestFocus();
		} else if (cboUnidade.getSelectedItem().equals(null)) {
			JOptionPane.showMessageDialog(null, "Insira a quantidade de Unidades");
			cboUnidade.requestFocus();
		} else if (txtLucro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o lucro ");
			txtLucro.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o custo ");
			txtCusto.requestFocus();

		} else if (txtaDescricao.getText().length() > 255) {
			JOptionPane.showMessageDialog(null, "Limite máximo de 255 caracteres ultrapassado");
			txtaDescricao.requestFocus();

		} else {
			String insert = "insert into produtos (barcode, produto, descricao, fabricante, dataval,estoque, estoquemin,unidade,localizacao, custo, lucro, idFor) values  (?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				// Abrir a conexão
				Connection con = dao.conectar();
				// Preparar a query (substituição de parâmetros)
				PreparedStatement pst = con.prepareStatement(insert);
				// setar as caixas de texto com o resultado da pesquisa

				pst.setString(1, txtBarcode.getText());
				pst.setString(2, txtProduto.getText());
				pst.setString(3, txtaDescricao.getText());
				pst.setString(4, txtFabricante.getText());
				// formatar o valor do jcalendar para inserção correta no banco de dados
				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				String dataFormatada = formatador.format(dateValidade.getDate());
				pst.setString(5, dataFormatada);
				pst.setString(6, txtEstoque.getText());
				pst.setString(7, txtEstoquemin.getText());
				pst.setString(8, cboUnidade.getSelectedItem().toString());
				pst.setString(9, txtLocal.getText());
				pst.setString(10, txtCusto.getText());
				pst.setString(11, txtLucro.getText());
				pst.setString(12, txtId.getText());

				dateValidade.setEnabled(true);

				// executar a query e confirmar a inserção no banco

				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");				
					limpar();
					txtCodigo.setEnabled(true);
					btnPesquisar.setEnabled(true);
					txtId.setEnabled(true);
					txtCodigo.setEditable(true);
					dateValidade.setEnabled(true);
					btnCreate.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "ERRO ao cadastrar o produto");
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					txtCodigo.setEnabled(false);
					btnPesquisar.setEnabled(false);
					txtId.setEnabled(true);

				}

				// encerrar a conexão
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇAO! BAR CODE DUPLICADO");
				txtCodigo.setEnabled(false);
				btnPesquisar.setEnabled(false);
				btnCreate.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	private void atualizarProduto() {

		// valdação de campos obrigatorios

		if (txtBarcode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o barcode ");
			txtBarcode.requestFocus();

		} else if (txtProduto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Produto ");
			txtProduto.requestFocus();

		} else if (txtFabricante.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Fabricante");
			txtFabricante.requestFocus();
		} else if (dateValidade.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Insira a data de validade");
			dateValidade.requestFocus();

		} else if (txtEstoque.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o estoque ");
			txtEstoque.requestFocus();
		} else if (txtEstoquemin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o estoque mínimo");
			txtEstoquemin.requestFocus();
		} else if (txtLocal.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a Localização");
			txtEstoquemin.requestFocus();
		} else if (cboUnidade.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira a unidade");
			cboUnidade.requestFocus();
		} else if (txtLucro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o lucro ");
			txtLucro.requestFocus();
		} else if (txtCusto.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o custo ");
			txtCusto.requestFocus();

		} else {
			String update = "update produtos set barcode = ?, produto = ?,  descricao = ?, fabricante = ?, dataval = ?,estoque = ?,estoquemin = ?,unidade = ?,localizacao = ?, custo = ?, lucro = ?, idFor = ? where codigo = ?";
			try {
				// Abrir a conexão
				Connection con = dao.conectar();
				// Preparar a query (substituição de parâmetros)
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtBarcode.getText());
				pst.setString(2, txtProduto.getText());
				pst.setString(3, txtaDescricao.getText());
				pst.setString(4, txtFabricante.getText());
				// formatar o valor do jcalendar para inserção correta no banco de dados
				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				String dataFormatada = formatador.format(dateValidade.getDate());
				pst.setString(5, dataFormatada);
				pst.setString(6, txtEstoque.getText());
				pst.setString(7, txtEstoquemin.getText());
				pst.setString(8, cboUnidade.getSelectedItem().toString());
				pst.setString(9, txtLocal.getText());
				pst.setString(10, txtCusto.getText());
				pst.setString(11, txtLucro.getText());
				pst.setString(12, txtId.getText());
				pst.setString(13, txtCodigo.getText());
				dateValidade.setEnabled(false);
				txtCodigo.setEnabled(false);
				

				// Executar a query e confirmar a inserção no banco

				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
					limpar();
					txtId.setEnabled(true);
					txtCodigo.setEnabled(false);
					txtCodigo.setEnabled(true);
					txtBarcode.setEnabled(true);
					btnPesquisar.setEnabled(true);
					btnCreate.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "ERRO - produto já existente");
					limpar();
					txtId.setEnabled(true);
					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					limpar();

				}

				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇÃO! BARCODE: Duplicado");

			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	private void excluirProduto() {

		// validação (confirmação)
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste produto?", "ATENÇÃO!",
				JOptionPane.YES_NO_OPTION);

		if (confirma == JOptionPane.YES_OPTION) {
			// logica principal
			String delete = "delete from produtos where codigo = ?";
			try {
				// abrir conexï¿½o
				Connection con = dao.conectar();

				// preparar a query
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtCodigo.getText());

				// executar o comando sql e confirmar a exclusão
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {

					JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
					limpar();
			
					txtBarcode.setEnabled(true);
					btnPesquisar.setEnabled(true);
					txtCodigo.setEnabled(true);
					btnCreate.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "ERRO: na exclusão do produto");

				}
				// encerrar a conexï¿½o
				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "ATENÇÃO! Produto relacionado a outra tabela");
				txtBarcode.setText(null);
				txtBarcode.requestFocus();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	

	private void limpar() {
		txtFornecedor.setText(null);
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		txtCodigo.setText(null);
		txtBarcode.setText(null);
		txtProduto.setText(null);
		txtaDescricao.setText(null);
		txtFabricante.setText(null);
		txtEstoque.setText(null);
		txtEstoquemin.setText(null);
		cboUnidade.setSelectedItem(null);
		txtLocal.setText(null);
		txtCusto.setText(null);
		txtLucro.setText(null);
		txtId.setText(null);
		dateValidade.setDate(null);
		dateEntrada.setDate(null);
		txtCodigo.setEnabled(true);

		((DefaultTableModel) table.getModel()).setRowCount(0);
	}
}// fim do codigo
