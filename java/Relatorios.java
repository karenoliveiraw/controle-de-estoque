package views;

import java.awt.EventQueue;

import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import models.DAO;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Relatorios extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
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
	public Relatorios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorios.class.getResource("/img/report.png")));
		setResizable(false);
		setModal(true);
		setTitle("Relat\u00F3rios");
		setBounds(100, 100, 537, 433);
		getContentPane().setLayout(null);

		JButton btnReposicao = new JButton("");
		btnReposicao.setIcon(new ImageIcon(
				Relatorios.class.getResource("/img/3709746_customer_evaluation_review_satisfaction_system_icon.png")));
		btnReposicao.setToolTipText("Relatorio de Estoque");
		btnReposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reposicaoEstoque();
			}
		});
		btnReposicao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReposicao.setBounds(40, 44, 128, 128);
		getContentPane().add(btnReposicao);

		JButton btnClientes = new JButton("");
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setToolTipText("Relat\u00F3rios de Clientes");
		btnClientes.setIcon(new ImageIcon(Relatorios.class
				.getResource("/img/3709751_complaint_dissatisfaction_expression_feedback_report_icon.png")));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnClientes.setBounds(188, 44, 128, 128);
		getContentPane().add(btnClientes);

		JButton btnFornecedores = new JButton("");
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioFornecedores();
			}
		});
		btnFornecedores.setIcon(new ImageIcon(
				Relatorios.class.getResource("/img/3709732_call_performance_report_service_statistics_icon.png")));
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setToolTipText("Relat\u00F3rios de Fornecedores");
		btnFornecedores.setBounds(342, 44, 128, 128);
		getContentPane().add(btnFornecedores);

		JButton btnProdutosVencidos = new JButton("");
		btnProdutosVencidos.setIcon(new ImageIcon(Relatorios.class.getResource("/img/8140802_approval_approve_reject_rejection_confirm_icon.png")));
		btnProdutosVencidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutosVencidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosVencidos();
			}
		});
		btnProdutosVencidos.setToolTipText("Relat\u00F3rios de produtos vencidos");
		btnProdutosVencidos.setBounds(40, 203, 128, 128);
		getContentPane().add(btnProdutosVencidos);

		JButton btnLucro = new JButton("");
		btnLucro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLucro.setIcon(new ImageIcon(Relatorios.class.getResource("/img/7217211_trade_chart_stock_diagram_graph_icon.png")));
		btnLucro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularVenda();
			}
		});
		btnLucro.setToolTipText("Relat\u00F3rios de Vendas");
		btnLucro.setBounds(188, 203, 128, 128);
		getContentPane().add(btnLucro);

		JButton btnfornecedorRelacionadoAo = new JButton("");
		btnfornecedorRelacionadoAo.setIcon(new ImageIcon(Relatorios.class.getResource("/img/7215647_presentation_business_infographic_report_corporate_icon.png")));
		btnfornecedorRelacionadoAo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnfornecedorRelacionadoAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtoFornecedor();
			}
		});
		btnfornecedorRelacionadoAo.setToolTipText("Relat\u00F3rios de fornecedores relacionado ao produto");
		btnfornecedorRelacionadoAo.setBounds(342, 203, 128, 128);
		getContentPane().add(btnfornecedorRelacionadoAo);

	}// fim do construtor

	DAO dao = new DAO();

	private void reposicaoEstoque() {

		// criar objeto para construir a página pdf
		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("reposicao.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Reposição de estoque"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(5); // (5) numero de colunas
			// cabecalho de tabeça
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Estoque"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Estoque mínimo"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			// Acessar o banco de dados
			String relReposicao = "select codigo,produto,date_format(dataval,'%d/%m/%Y'), estoque, estoquemin from produtos where estoque < estoquemin";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relReposicao);
				ResultSet rs = pst.executeQuery();
				// enquanto houver dados na tabela do banco (obter o valor)
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("reposicao.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioClientes() {

		// criar objeto para construir a página pdf
		Document document = new Document();
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Clientes cadastrados"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			// Acessar o banco de dados
			String relClientes = "select nome,fone,cpf,email from clientes";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relClientes);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioFornecedores() {

		// criar objeto para construir a página pdf
		Document document = new Document();
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("fornecedores.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Fornecedores cadastrados"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Fornecedor"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome Contato"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Fone"));
		
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
		
			// Acessar o banco de dados
			String relFornecedores = "select fantasia,nomeContato,fone from fornecedores";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relFornecedores);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));

				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("fornecedores.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void produtosVencidos() {

		// criar objeto para construir a página pdf
		Document document = new Document();
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("produtosvencidos.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Produtos vencidos"));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Localização"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data de Validade"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Dias vencidos"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			// Acessar o banco de dados
			String relVencidos = "select codigo , produto, localizacao, \r\n"
					+ " date_format (dataval, '%d/%m/%Y'), datediff(dataval, curdate()) \r\n"
					+ " from produtos where datediff(dataval, curdate()) < 0; ";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relVencidos);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("produtosvencidos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void produtoFornecedor() {

		// criar objeto para construir a página pdf
		Document document = new Document();
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("relprodutosfor.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Fornecedor relacionado ao produto  "));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(3);
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Fornecedor"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);

			// Acessar o banco de dados
			String relForProdutos = " select produtos.codigo, produtos.produto, \r\n"
					+ " fornecedores.fantasia  from produtos inner join fornecedores on produtos.idFor = fornecedores.idFor";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relForProdutos);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					

				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("relprodutosfor.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void calcularVenda() {

		// criar objeto para construir a página pdf
		Document document = new Document();
		// gerar o documento pdf
		try {
			// cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("relvendas.pdf"));
			document.open();
			// gerar o conteúdo do documento
			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			// document.add (adicionar um parágrafo)
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("RELATÓRIO: Calcular o preço de venda "));
			document.add(new Paragraph(" "));
			// ... Demais conteúdos (imagem, tabela, gráfico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Código"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Custo"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Preço de venda"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// Acessar o banco de dados
			String relForProdutos = " 	select codigo , produto, custo, (custo + (custo * lucro) /100)\r\n"
					+ "	from produtos;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relForProdutos);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));


				}

			} catch (Exception e) {
				System.out.println(e);
			}
			// Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { // executa o código independente do resultado OK ou não
			document.close();
		}

		// abrir o documento que foi gerado no leitor padrão de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("relvendas.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	


}// fim do codigo
