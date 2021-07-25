package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import java.awt.Panel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnAceptar;
	private JButton btnEnviar;
    private JComboBox comboBox;
    private JLabel lblApellido;
    private JLabel lblNombre;
    private JLabel lblServidor;
    private JTextArea textArea;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 473);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Abrir cuenta", "Crear un bolsillo", "Cancelar bolsillo", "Cancelar cuenta de ahorros", "Depositar dinero en una cuenta", "Retirar dinero de una cuenta", "Trasladar dinero a un bolsillo", "Consultar saldo"}));
		comboBox.setBounds(144, 56, 265, 36);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Aplicaci\u00F3n para operaci\u00F3n Bancaria");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
		lblNewLabel.setBounds(84, 10, 403, 36);
		contentPane.add(lblNewLabel);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnAceptar.setBounds(207, 102, 132, 36);
		contentPane.add(btnAceptar);
		
		JPanel panelAbrirCuenta = new JPanel();
		panelAbrirCuenta.setBackground(new Color(211, 211, 211));
		panelAbrirCuenta.setForeground(Color.BLACK);
		panelAbrirCuenta.setBounds(10, 167, 530, 253);
		contentPane.add(panelAbrirCuenta);
		panelAbrirCuenta.setLayout(null);
		
		lblApellido = new JLabel("Ingrese su apellido:");
		lblApellido.setBounds(10, 88, 144, 52);
		lblApellido.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		panelAbrirCuenta.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setBounds(10, 62, 144, 28);
		panelAbrirCuenta.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("Ingrese su nombre:");
		lblNombre.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblNombre.setBounds(10, 10, 167, 52);
		panelAbrirCuenta.add(lblNombre);
			
		txtApellido = new JTextField();
		txtApellido.setBackground(Color.WHITE);
		txtApellido.setColumns(10);
		txtApellido.setBounds(10, 139, 144, 28);
		panelAbrirCuenta.add(txtApellido);
		
		textArea = new JTextArea();
		textArea.setBounds(187, 39, 322, 186);
		panelAbrirCuenta.add(textArea);
		
		lblServidor = new JLabel("Mensaje del servidor");
		lblServidor.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		lblServidor.setBounds(272, 10, 144, 32);
		panelAbrirCuenta.add(lblServidor);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(10, 189, 144, 36);
		panelAbrirCuenta.add(btnEnviar);
		btnEnviar.setForeground(Color.BLACK);
		btnEnviar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnEnviar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
	
	int m = comboBox.getSelectedIndex();
	String mensaje1,mensaje2,mensaje3;

	    if(e.getSource()== btnAceptar) {	
	    	if(m == 0) {
	    		lblApellido.setVisible(true);
	    		txtNombre.setVisible(true);
	        	txtApellido.setVisible(true);
	        	txtApellido.setVisible(true);
	    		lblNombre.setText("Ingrese su nombre:");
	    		lblApellido.setText("Ingrese su apellido:");
	    		txtNombre.setText("");
	    		txtApellido.setText("");
	    	}
	    	if(m == 1) {
	        	lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
				lblNombre.setText("# cuenta de ahorros:");
				txtNombre.setText("");
	    	}
	    	// Opción 1 combobox Abrir Cancelar cuenta de ahorros  
	    	if(m == 2) {
	    		lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
	    		lblNombre.setText("# cuenta de bolsillo:");
	    		txtNombre.setText("");
	    	}
	    	// Opción 1 combobox Abrir Depositar dinero en una cuenta 
	    	if(m == 3) {
	    		lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
				lblNombre.setText("# cuenta de ahorros:");
				txtNombre.setText("");
	        }
	        // Opción 1 combobox Abrir Retirar dinero de una cuenta
	        if(m == 4) {
	        	lblApellido.setVisible(true);
	        	txtApellido.setVisible(true);
				lblNombre.setText("# cuenta de ahorros:");
				lblApellido.setText("cantidad a depositar:");	
				txtNombre.setText("");
	    		txtApellido.setText("");
	        }
	        // Opción 1 combobox Abrir Trasladar dinero a un bolsillo
	        if(m == 5) {
	        	lblApellido.setVisible(true);
	        	txtApellido.setVisible(true);
				lblNombre.setText("# cuenta de ahorros:");
				lblApellido.setText("cantidad a retirar:");		
				txtNombre.setText("");
	    		txtApellido.setText("");
	        }
	        // Opción 1 combobox Abrir Trasladar consultar Saldo
	        if(m == 6) {
	        	lblApellido.setVisible(true);
	        	txtApellido.setVisible(true);
				lblNombre.setText("# cuenta de ahorros:");
				lblApellido.setText("cantidad a trasladar:");
				txtNombre.setText("");
	    		txtApellido.setText("");
	        }
	        // Opción 1 combobox Abrir Trasladar consultar Saldo
	        if(m == 7) {
	        	lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
				lblNombre.setText("# cuenta de ahorros:");
				txtNombre.setText("");	
	        }
		
	   }
	       
		if(e.getSource()==btnEnviar ) {
			if(m == 0) {
				mensaje1 = txtApellido.getText();
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje1 + " " + mensaje2);	
			    System.out.println(" Holaaaaaaaaaaaaa" );
		        textArea.setText("File TCP Client ... " + "\nConexión aceptada en el lado del servidor");
			}
			if(m == 1) {
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje2);	
		        textArea.setText("File TCP Client ... " + "\nConexión aceptada en el lado del servidor");	
			}
			if(m == 2) {
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje2);			
			}
			if(m == 3) {
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje2);	
			}
			if(m == 4) {
				mensaje1 = txtApellido.getText();
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje1 + " " + mensaje2);	
			}
			if(m == 5) {
				mensaje1 = txtApellido.getText();
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje1 + " " + mensaje2);	
			}
			if(m == 6) {
				mensaje1 = txtApellido.getText();
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje1 + " " + mensaje2);	
			}
			if(m == 7) {
				mensaje2 = txtNombre.getText();	
				System.out.println(mensaje2);	
			}

		}
						
		
	}
	
}


