package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class PruebaComponentes extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup grupoIdiomas = new ButtonGroup();
	private final ButtonGroup grupoAficiones = new ButtonGroup();
	private JComboBox comboBox;
	private JSpinner spinner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaComponentes frame = new PruebaComponentes();
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
	public PruebaComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		mnNewMenu.setMnemonic('A');
		mnNewMenu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Has pulsado nuevo");
			}
		});
		mntmNewMenuItem.setMnemonic('N');
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Abrir");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Guardar");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Exportar");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("JPG");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("GIF");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Salir");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][][][]", "[][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Selecciona tu idioma:");
		contentPane.add(lblNewLabel, "cell 0 0 6 1");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Español");
		rdbtnNewRadioButton.setSelected(true);
		grupoIdiomas.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton, "cell 1 1");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Inglés");
		grupoIdiomas.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1, "cell 3 1 2 1");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Alemán");
		grupoIdiomas.add(rdbtnNewRadioButton_2);
		contentPane.add(rdbtnNewRadioButton_2, "cell 5 1");
		
		JLabel lblNewLabel_1 = new JLabel("Selecciona tus aficiones:");
		contentPane.add(lblNewLabel_1, "cell 0 2 6 1");
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Deportes");
		grupoAficiones.add(chckbxNewCheckBox);
		contentPane.add(chckbxNewCheckBox, "cell 1 3");
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Videojuegos");
		grupoAficiones.add(chckbxNewCheckBox_1);
		contentPane.add(chckbxNewCheckBox_1, "cell 3 3 2 1");
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Karaoke");
		contentPane.add(chckbxNewCheckBox_2, "cell 5 3");
		
		JLabel lblNewLabel_2 = new JLabel("Provincia:");
		contentPane.add(lblNewLabel_2, "cell 0 4 6 1");
		
	    comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String provincia = (String) comboBox.getSelectedItem();
				JOptionPane.showMessageDialog(contentPane, provincia);
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Córdoba", "Jaén", "Málaga", "Madrid", "Sevilla", "Cádiz", "Huelva", "Almería"}));
		contentPane.add(comboBox, "cell 1 5 5 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Fecha:");
		contentPane.add(lblNewLabel_3, "cell 0 6");
		
		JLabel lblNewLabel_4 = new JLabel("Día:");
		contentPane.add(lblNewLabel_4, "cell 1 6,alignx right");
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(spinner, "cell 3 6");
		spinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		((DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Mes:");
		contentPane.add(lblNewLabel_5, "cell 4 6");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dia = (int) spinner.getValue();
				JOptionPane.showMessageDialog(contentPane, "Tu número es "+dia);
			}
		});
		contentPane.add(btnNewButton, "cell 2 7");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 8,growx,aligny top");
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Java", "C++", "Rust", "JavaScript", "Dart"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, "cell 2 8,grow");

		
		
	}

}
