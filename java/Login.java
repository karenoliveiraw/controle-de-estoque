package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.DAO;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/favicon.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 281);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setBounds(237, 193, 89, 23);
		contentPane.add(btnAcessar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(20, 168, 48, 48);
		contentPane.add(lblStatus);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/user.png")));
		lblNewLabel.setBounds(93, 54, 24, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/senha.png")));
		lblNewLabel_1.setBounds(93, 106, 24, 24);
		contentPane.add(lblNewLabel_1);

		txtLogin = new JTextField();
		txtLogin.setBounds(127, 58, 128, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(127, 110, 128, 20);
		contentPane.add(txtSenha);

		// uso da tecla <enter> junto com um botão (construtor)
		getRootPane().setDefaultButton(btnAcessar);

	}// fim do construtor

	/**
	 * criar um objeto para acessar o metodo conectar () da classe DAO
	 */

	DAO dao = new DAO();

	/**
	 * Método responsável por verificar o status da conexão com o banco
	 */
	private void status() {
		// System.out.println("teste - Janela Ativada");
		// uso da classe Connection (JDBC) para estabelecer a conexão
		try {
			Connection con = dao.conectar();
			if (con == null) {
				// System.out.println("Erro de conexão");
				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dboff.png")));
			} else {
				// System.out.println("Banco conectado!");
				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dbon.png")));
			}
			// Nunca esquecer de encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do status

	private void logar() {

		// validação da senha (captura segura)
		String capturaSenha = new String(txtSenha.getPassword());
		// validação de campos obrigatórios
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu Login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Digite a sua Senha");
			txtSenha.requestFocus();
		} else {

			// lógica principal (pesquisar login e senha correspondente)

			String read = "select * from usuarios where login = ? and senha = md5(?)";
			try {
				// abrir conexão
				Connection con = dao.conectar();
				// preparar a query
				PreparedStatement pst = con.prepareStatement(read);
				// setar os argumentos (?)
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				// executar a query e executar o login, se existir login e senha correspondente
				// no banco
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					// System.out.println("logar");
					Main main = new Main();
					// a linha abaixo
					String perfil = rs.getString(5);
					// comportamento de login em função do perfil
					if (perfil.equals("admin")) {
						main.setVisible(true);
						// alterar a label da tela principal (inserir nome do usuario no rodapé)
						// apoio ao entendimento da lógica
						// System.out.println(rs.getString(2));
						main.lblUsuario.setText(rs.getString(2));
						//habilitar os botoes 
						main.btnRelatorios.setEnabled(true);
						main.btnUsuarios.setEnabled(true);
						//alterar a cor do rodapé 
						main.panelUsuarios.setBackground(Color.RED);
						// fechar o jframe
						this.dispose();
					} else {
						main.setVisible(true);
						// alterar a label da tela principal (inserir nome do usuario no rodapé)
						// apoio ao entendimento da lógica
						// System.out.println(rs.getString(2));
						main.lblUsuario.setText(rs.getString(2));
						// fechar o jframe
						this.dispose();
						//desabilitar os botões 
						
						//main.btnRelatorios.setEnabled(false);
						//main.btnUsuarios.setEnabled(false);
					}

				} else {
					JOptionPane.showMessageDialog(null, " Login e/ou senha inválido(s)");
				}
				// encerrar a conexão
				con.close();

			} catch (Exception e) {
				System.out.println(e);

			}

		}

	}

}// fim do codigo
