package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class VentanaMedias extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, "cell 0 2,alignx trailing");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 2 5 1,growx");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		contentPane.add(lblNewLabel_1, "cell 0 4,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 4,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		contentPane.add(lblNewLabel_2, "flowx,cell 2 4");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		contentPane.add(lblNewLabel_3, "cell 4 4,alignx trailing");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 5 4,growx");
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, "cell 4 6 2 1");
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		contentPane.add(lblNewLabel_5, "cell 0 8");
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		contentPane.add(lblNewLabel_6, "cell 1 8");
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		contentPane.add(lblNewLabel_7, "cell 0 9");
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		contentPane.add(lblNewLabel_8, "cell 1 9");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 3 4,growx");
		textField_1.setColumns(10);
	}

}
