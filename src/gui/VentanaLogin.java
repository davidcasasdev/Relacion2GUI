package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.OptionPaneUI;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnAceptar;
	
	private static final String USUARIO="David";
	private static final String PASSWORD="1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][::35px,grow][grow 20][::35px,grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		contentPane.add(lblNewLabel, "cell 1 1");
		
		txtUsuario = new JTextField();
		txtUsuario.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				habilitaBoton();
			}
		});
		contentPane.add(txtUsuario, "cell 2 1,grow");
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		contentPane.add(lblNewLabel_1, "cell 1 3");
		
		txtPassword = new JPasswordField();
		contentPane.add(txtPassword, "cell 2 3,grow");
		txtPassword.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		contentPane.add(btnAceptar, "cell 1 5 2 1,alignx right");
	}

	protected void habilitaBoton() {
		
		String pass= new String(txtPassword.getPassword());
		if(txtUsuario.getText()!=null && !txtUsuario.getText().isBlank() &&
				pass!=null && !pass.isBlank()) {
			btnAceptar.setEnabled(true);
		} else {
			btnAceptar.setEnabled(false);
		}
		
	}

	protected void login() {
		
//		if(txtUsuario.getText()==null || txtUsuario.getText().isBlank() ||
//			txtPassword.getText()==null || txtPassword.getText().isBlank()) {
//			JOptionPane.showMessageDialog(contentPane, 
//					"Debe introducir los dos campos." , 
//					"Inciar sesión", JOptionPane.WARNING_MESSAGE);
//			return;
//		}
		
		if (txtUsuario.getText().equals(USUARIO) && 
			txtPassword.getText().equals(PASSWORD)) {
			JOptionPane.showMessageDialog(contentPane, 
					"Incio de sesión correcto, Bienvenido" , 
					"Inciar sesión", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(contentPane, 
					"Error, usuario/contraseña incorrecto." , 
					"Inciar sesión", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
