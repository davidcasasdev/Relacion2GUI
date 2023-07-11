package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio5 extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5 frame = new Ejercicio5();
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
	public Ejercicio5() {
		setTitle("Provincias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Ciudad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, "cell 1 1,alignx trailing");
		comboBox = new JComboBox<>();
		comboBox.setToolTipText("Selecciona una ciudad");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeItemAt(0);
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una ciudad", "TorredonJimeno", "Cabra del Santo Cristo", "Ubeda", "Baeza", "Andújar"}));
		contentPane.add(comboBox, "cell 2 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Has seleccionado:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 1 4");
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblResultado, "cell 2 4");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionar();
			}
		});
		contentPane.add(btnAceptar, "cell 2 6");
	}

	protected void seleccionar() {
		String ciudad = (String) this.comboBox.getSelectedItem();
		if (ciudad.equals("Seleccione una ciudad")) {
			lblResultado.setText( "Debe seleccionar una ciudad");
			return;
		}
		lblResultado.setText(ciudad);
	}

}
