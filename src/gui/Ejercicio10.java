package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class Ejercicio10 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup grupoCondiciones = new ButtonGroup();
	private JRadioButton rdbAceptar;
	private JRadioButton rdbCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio10 frame = new Ejercicio10();
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
	public Ejercicio10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][grow][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Aceptar las condiciones del servicio");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Acuerdo de licencia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 0 1");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, "cell 0 2,grow");
		
		JTextArea txtrPorElPresente = new JTextArea();
		txtrPorElPresente.setLineWrap(true);
		txtrPorElPresente.setText(Messages.getString("Ejercicio10.txtrPorElPresente.text")); //$NON-NLS-1$
		scrollPane.setViewportView(txtrPorElPresente);
		
		rdbAceptar = new JRadioButton("Aceptar condiciones del servicio");
		grupoCondiciones.add(rdbAceptar);
		contentPane.add(rdbAceptar, "cell 0 3");
		
		rdbCancelar = new JRadioButton("No aceptar");
		rdbCancelar.setSelected(true);
		grupoCondiciones.add(rdbCancelar);
		contentPane.add(rdbCancelar, "cell 0 4");
		
		JButton btnNewButton = new JButton(Messages.getString("Ejercicio10.btnNewButton.text")); //$NON-NLS-1$
		contentPane.add(btnNewButton, "cell 0 6,alignx center");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acuerdo();
			}
		});
		
		LocalDate hoy = LocalDate.now();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoy.format(formateador));
		
		
		
		
		
		
		
		}

	protected void acuerdo() {
		if (rdbAceptar.isSelected()) {
			JOptionPane.showMessageDialog(contentPane, "Pasa por caja...", 
					"Información", JOptionPane.INFORMATION_MESSAGE);
		} else if  (rdbCancelar.isSelected()) {

			int opcion = JOptionPane.showConfirmDialog(contentPane,
					"¿Estás seguro?", "Pregunta", JOptionPane.OK_CANCEL_OPTION);
			if (opcion==JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(contentPane, "Pasa por caja...", 
						"Información", JOptionPane.INFORMATION_MESSAGE);
			} else if (opcion==JOptionPane.CANCEL_OPTION || opcion==JOptionPane.CLOSED_OPTION) {
				JOptionPane.showMessageDialog(contentPane, "Otra vez será...", 
						"Información", JOptionPane.INFORMATION_MESSAGE);
			} 
		}
		System.exit(0);
		
	}

}
