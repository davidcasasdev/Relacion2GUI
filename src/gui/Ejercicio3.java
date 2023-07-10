package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	private JPanel contentPane;
	private JCheckBox cbkDeportes;
	private JTextArea textArea;
	private JCheckBox cbkTecnologia;
	private JCheckBox cbkJuegos;
	private JCheckBox cbkCocina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3 frame = new Ejercicio3();
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
	public Ejercicio3() {
		setTitle("Habilitar/Deshabilitar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Hobbies:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, "cell 1 1");
		
		JLabel lblNewLabel_1 = new JLabel("Has seleccionado:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 5 1");
		
		cbkDeportes = new JCheckBox("Deportes");
		cbkDeportes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(cbkDeportes, "cell 2 2");
		
		textArea = new JTextArea();
		contentPane.add(textArea, "cell 4 2 2 4,grow");
		
		cbkTecnologia = new JCheckBox("Tecnología");
		cbkTecnologia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(cbkTecnologia, "cell 2 3");
		
		cbkJuegos = new JCheckBox("Juegos");
		cbkJuegos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(cbkJuegos, "cell 2 4");
		
		cbkCocina = new JCheckBox("Cocina");
		cbkCocina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(cbkCocina, "cell 2 5");
		
		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnNewButton, "cell 5 7");
	}

	protected void comprobar() {
		this.textArea.setText("");
		if (this.cbkDeportes.isSelected()) {
			this.textArea.setText(this.textArea.getText()+this.cbkDeportes.getText()+"\n");
		}
		if (this.cbkTecnologia.isSelected()) {
			this.textArea.setText(this.textArea.getText()+"Tecnologia\n");
		}
		if (this.cbkJuegos.isSelected()) {
			this.textArea.setText(this.textArea.getText()+"Juegos\n");
		}
		if (this.cbkCocina.isSelected()) {
			this.textArea.setText(this.textArea.getText()+"Cocina\n");
		}
		
	}

}
