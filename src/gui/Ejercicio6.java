package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio6 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNuevo;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 frame = new Ejercicio6();
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
	public Ejercicio6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][grow][grow][grow]", "[][][][32.00][][]"));
		
		JLabel lblNewLabel = new JLabel("Escribe el título de la película:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, "cell 1 1 3 1");
		
		JLabel lblNewLabel_1 = new JLabel("Películas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 5 1");
		
		txtNuevo = new JTextField();
		txtNuevo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(txtNuevo, "cell 1 3 3 1,grow");
		txtNuevo.setColumns(10);
		
		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(comboBox, "cell 5 3,grow");
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPelicula();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnNewButton, "cell 2 5,alignx left");
		getRootPane().setDefaultButton(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPelicula();
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnEliminar, "cell 3 5");
	}

	protected void eliminarPelicula() {
		String nueva = txtNuevo.getText();
		if (nueva!=null && !nueva.isBlank()) {
			comboBox.removeItem(nueva);
		}
		txtNuevo.setText("");
	}

	protected void insertarPelicula() {
		String nueva = txtNuevo.getText();
		if (nueva==null || nueva.isBlank()) {
			JOptionPane.showMessageDialog(contentPane, 
					"Debe introducir una película", "error en los datos",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		//boolean encontrado = false;
		for (int i=0; i<comboBox.getItemCount();i++) {
			if (nueva.equalsIgnoreCase(comboBox.getItemAt(i))) {
				return;
			}
		}
		
		comboBox.addItem(nueva.trim());
		txtNuevo.setText("");
	}

}
