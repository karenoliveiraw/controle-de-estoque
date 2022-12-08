package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextPane;


public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
	public Sobre() {
		setFont(new Font("Dialog", Font.BOLD, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/about.png")));
		setTitle("Sobre");
		setModal(true);
		setBounds(100, 100, 466, 339);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Karen Oliveira da Silva");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Nexa Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(116, 32, 232, 37);
		getContentPane().add(lblNewLabel);
		
		JTextPane txtpnDddfd = new JTextPane();
		txtpnDddfd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnDddfd.setSize(new Dimension(4, 0));
		txtpnDddfd.setOpaque(false);
		txtpnDddfd.setForeground(Color.BLACK);
		txtpnDddfd.setText("A licen\u00E7a MIT, tamb\u00E9m chamada de licen\u00E7a X ou de licen\u00E7a X11, \u00E9 uma licen\u00E7a de programas de computadores (software), criada pelo Instituto de Tecnologia de Massachusetts (MIT). Ela \u00E9 uma licen\u00E7a permissiva utilizada tanto em software livre quanto em software propriet\u00E1rio.");
		txtpnDddfd.setBounds(83, 96, 319, 193);
		getContentPane().add(txtpnDddfd);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Sobre.class.getResource("/img/Sem T\u00EDtulo-1.png")));
		lblNewLabel_1.setBounds(326, 192, 124, 124);
		getContentPane().add(lblNewLabel_1);

	}
}
