package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ejercicio8 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup grupo1 = new ButtonGroup();
	private final ButtonGroup grupo2 = new ButtonGroup();
	private JLabel lblConversion;
	
	public static final double DOLARAEURO =0.91;
	public static final double DOLARAYEN = 142.48;
	public static final double EUROADOLAR = 1.09;
	public static final double EUROAYEN = 142.42;
	public static final double YENAEURO = 0.0064;
	public static final double YENADOLAR = 0.007;
	
	public static final double matrizConversion [][]={ 
		{1, DOLARAEURO, DOLARAYEN},
		{EUROADOLAR, 1, EUROAYEN},
		{YENADOLAR,YENAEURO,1}
	};
	
	public static final String monedas[] = {"$","€","¥"};
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio8 frame = new Ejercicio8();
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
	public Ejercicio8() {
		setTitle("Conversión monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][][][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Conversión de monedas");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		contentPane.add(lblNewLabel, "cell 1 1 5 1");
		
		JLabel lblNewLabel_1 = new JLabel("De:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx trailing");
		
		comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"Dólares", "Euros", "Yenes"}));
		contentPane.add(comboBox1, "cell 2 2 4 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad:");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3, "cell 1 4,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 4 4 1,growx");
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(btnNewButton, "cell 3 6");
		
		JLabel lblNewLabel_2 = new JLabel("A:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2, "cell 1 8,alignx trailing");
		
		comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"Dólares", "Euros", "Yenes"}));
		contentPane.add(comboBox2, "cell 2 8 4 1,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Resultado:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_4, "cell 2 10");
		
		lblConversion = new JLabel("");
		lblConversion.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(lblConversion, "cell 3 10 3 1");
	}

	protected void calcular() {
//		JOptionPane.showMessageDialog(null,
//				grupo1.getSelection().getActionCommand()+"-"+
//						grupo2.getSelection().getActionCommand()
//		);
		
		int moneda1 =comboBox1.getSelectedIndex();
		int moneda2 =comboBox2.getSelectedIndex();
		
		if (moneda1==moneda2) {
			JOptionPane.showMessageDialog(contentPane, 
					"Debe seleccionar 2 monedas distitnas");
			return;
		}
		try {
			double cantidad = Double.parseDouble(textField.getText());
			double cambio=cantidad*matrizConversion[moneda1][moneda2];
			lblConversion.setText(String.format("%.2f "+monedas[moneda2], cambio));
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPane, "Debe itroducir la cantidad",
					"Error en los datos", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
}
