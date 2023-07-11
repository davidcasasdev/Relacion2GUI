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

public class Ejercicio9 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup grupo1 = new ButtonGroup();
	private final ButtonGroup grupo2 = new ButtonGroup();
	private JLabel lblConversion;
	private JRadioButton rdbDolar2;
	private JRadioButton rdbEuros2;
	private JRadioButton rdbYenes2;
	private JRadioButton rdbEuros1;
	private JRadioButton rdbDolar1;
	private JRadioButton rdbYenes1;
	
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
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio9 frame = new Ejercicio9();
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
	public Ejercicio9() {
		setTitle("Conversión monedas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Conversión de monedas");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		contentPane.add(lblNewLabel, "cell 1 1 5 1");
		
		JLabel lblNewLabel_1 = new JLabel("De:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, "cell 1 2");
		
		rdbDolar1 = new JRadioButton("Dólares");
		rdbDolar1.setSelected(true);
		grupo1.add(rdbDolar1);
		rdbDolar1.setActionCommand("0");
		rdbDolar1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbDolar1, "cell 2 2");
		
		rdbEuros1 = new JRadioButton("Euros");
		rdbEuros1.setActionCommand("1");
		grupo1.add(rdbEuros1);
		rdbEuros1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbEuros1, "cell 3 2");
		
		rdbYenes1 = new JRadioButton("Yenes");
		rdbYenes1.setActionCommand("2");
		grupo1.add(rdbYenes1);
		rdbYenes1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbYenes1, "cell 4 2");
		
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
		contentPane.add(lblNewLabel_2, "cell 1 8");
		
		rdbDolar2 = new JRadioButton("Dólares");
		rdbDolar2.setActionCommand("0");
		grupo2.add(rdbDolar2);
		rdbDolar2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbDolar2, "cell 2 8");
		
		rdbEuros2 = new JRadioButton("Euros");
		rdbEuros2.setActionCommand("1");
		rdbEuros2.setSelected(true);
		grupo2.add(rdbEuros2);
		rdbEuros2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbEuros2, "cell 3 8");
		
		rdbYenes2 = new JRadioButton("Yenes");
		rdbYenes2.setActionCommand("2");
		grupo2.add(rdbYenes2);
		rdbYenes2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbYenes2, "cell 4 8");
		
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
		
		int moneda1 =Integer.parseInt(grupo1.getSelection().getActionCommand());
		int moneda2 =Integer.parseInt(grupo2.getSelection().getActionCommand());
		
		if (moneda1==moneda2) {
			JOptionPane.showMessageDialog(contentPane, 
					"Debe seleccionar 2 monedas distitnas");
			return;
		}
		double cantidad = Double.parseDouble(textField.getText());
		
		double cambio=cantidad*matrizConversion[moneda1][moneda2];
		
		
		lblConversion.setText(String.format("%.2f "+monedas[moneda2], cambio));
	}
}
