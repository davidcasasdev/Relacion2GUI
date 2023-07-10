package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio4 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup grupoColores = new ButtonGroup();
	private JPanel panel;
	private JRadioButton rdbRojo;
	private JRadioButton rdbVerde;
	private JRadioButton rdbMagenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio4 frame = new Ejercicio4();
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
	public Ejercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Selecciona un color");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		contentPane.add(lblNewLabel, "cell 1 1 3 1");
		
		JRadioButton rdbAZul = new JRadioButton("Azul");
		rdbAZul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.BLUE);
			}
		});
		rdbAZul.setSelected(true);
		grupoColores.add(rdbAZul);
		contentPane.add(rdbAZul, "cell 2 3");
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBackground(new Color(0, 0, 255));
		contentPane.add(panel, "cell 3 3 1 4,grow");
		
		rdbRojo = new JRadioButton("Rojo");
		rdbRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.red);
			}
		});
		grupoColores.add(rdbRojo);
		contentPane.add(rdbRojo, "cell 2 4");
		
		rdbVerde = new JRadioButton("Verde");
		grupoColores.add(rdbVerde);
		contentPane.add(rdbVerde, "cell 2 5");
		rdbVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.green);
			}
		});
		
		
		rdbMagenta = new JRadioButton("Magenta");
		rdbMagenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarColor(Color.magenta);
			}
		});
		grupoColores.add(rdbMagenta);
		contentPane.add(rdbMagenta, "cell 2 6");
	}

	protected void cambiarColor(Color c) {
		panel.setBackground(c);
	}

}
