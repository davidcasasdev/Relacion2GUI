package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HabilitarBoton extends JFrame {

	private JPanel contentPane;
	private JButton btnDeshabilitar;
	private JButton btnCentral;
	private JButton btnHabilitar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilitarBoton frame = new HabilitarBoton();
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
	public HabilitarBoton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 98);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnDeshabilitar = new JButton("Deshabilita Central");
		btnDeshabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitar();
			}
		});
		btnDeshabilitar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnDeshabilitar);
		
		btnCentral = new JButton("Central");
		btnCentral.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnCentral);
		
		btnHabilitar = new JButton("Habilita Central");
		btnHabilitar.setEnabled(false);
		btnHabilitar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitar();
			}
		});
		contentPane.add(btnHabilitar);
	}

	protected void habilitar() {
		btnCentral.setEnabled(!btnCentral.isEnabled());
		btnHabilitar.setEnabled(!btnHabilitar.isEnabled());
		btnDeshabilitar.setEnabled(!btnDeshabilitar.isEnabled());
	}
	
//	protected void deshabilitar() {
//		btnCentral.setEnabled(false);
//		btnHabilitar.setEnabled(true);
//		btnDeshabilitar.setEnabled(false);
//	}

}
