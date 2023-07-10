package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMedias extends JFrame {

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNombre;
	private JLabel lblPromedio;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMedias frame = new VentanaMedias();
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
	public VentanaMedias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow][][grow]", "[44.00][][][::20px][][][][grow][][]"));
		
		JLabel lblNewLabel_4 = new JLabel("CALCULAR PROMEDIO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBackground(Color.BLACK);
		contentPane.add(lblNewLabel_4, "cell 0 0 6 1,grow");
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		contentPane.add(lblNewLabel, "cell 0 2,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 1 2 5 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nota 1:");
		contentPane.add(lblNewLabel_1, "cell 0 4,alignx trailing");
		
		txtNota1 = new JTextField();
		contentPane.add(txtNota1, "cell 1 4,growx");
		txtNota1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nota 2:");
		contentPane.add(lblNewLabel_2, "flowx,cell 2 4");
		
		JLabel lblNewLabel_3 = new JLabel("Nota 3:");
		contentPane.add(lblNewLabel_3, "cell 4 4,alignx trailing");
		
		txtNota3 = new JTextField();
		contentPane.add(txtNota3, "cell 5 4,growx");
		txtNota3.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		contentPane.add(btnNewButton, "cell 4 6 2 1");
		
		JLabel lblNewLabel_5 = new JLabel("Promedio:");
		contentPane.add(lblNewLabel_5, "cell 0 8");
		
		lblPromedio = new JLabel("");
		contentPane.add(lblPromedio, "cell 1 8");
		
		JLabel lblNewLabel_7 = new JLabel("Resultado:");
		contentPane.add(lblNewLabel_7, "cell 0 9");
		
		lblResultado = new JLabel("");
		contentPane.add(lblResultado, "cell 1 9");
		
		txtNota2 = new JTextField();
		contentPane.add(txtNota2, "cell 3 4,growx");
		txtNota2.setColumns(10);
	}

	protected void calcular() {
		try {
			double nota1 = Double.parseDouble(txtNota1.getText());
			double nota2 = Double.parseDouble(txtNota2.getText());
			double nota3 = Double.parseDouble(txtNota3.getText());
			
			double media = (nota1+nota2+nota3)/3;
			
			this.lblPromedio.setText(String.format("%.2f",media));
			
			if (media>=5) {
				this.lblResultado.setText("Ha aprobado la asignatura");
			} else {
				this.lblResultado.setText("Toca recuperar");
			}
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPane, "Debe introducir una nota valida", 
					"Error en los datos", JOptionPane.ERROR_MESSAGE);
		}
	}

}
