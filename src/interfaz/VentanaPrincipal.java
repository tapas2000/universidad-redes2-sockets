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


import logica.EchoTCPClient;
import logica.EchoTCPClientProtocol;

import java.awt.Panel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.net.Socket;
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
	public static EchoTCPClient ec = new EchoTCPClient();	
	
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
	String mensaje1,mensaje2, respuesta;

		/*
		 * Botón que activa la opción aceptar para los valores del combobox
		 * Y limpia los campos de texto si tienen valores con el setText("")
		 */
	    if(e.getSource()== btnAceptar) {
	    	
	    	//Opción 0 del combobox Abrir cuenta
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
	    	//Opción 1 del combobox Crear un bolsillo
	    	if(m == 1) {
	        	lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
				lblNombre.setText("# cuenta de ahorros:");
				txtNombre.setText("");
	    	}
	    	//Opción 2 del combobox Cancelar bolsillo
	    	if(m == 2) {
	    		lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
	    		lblNombre.setText("# cuenta de bolsillo:");
	    		txtNombre.setText("");
	    	}
	    	//Opción 3 del combobox Cancelar cuenta de ahorros
	    	if(m == 3) {
	    		lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
				lblNombre.setText("# cuenta de ahorros:");
				txtNombre.setText("");
	        }
	    	//Opción 4 del combobox Depositar dinero en una cuenta
	        if(m == 4) {
	        	lblApellido.setVisible(true);
	        	txtApellido.setVisible(true);
				lblNombre.setText("# cuenta de ahorros:");
				lblApellido.setText("cantidad a depositar:");	
				txtNombre.setText("");
	    		txtApellido.setText("");
	        }
	    	//Opción 5 del combobox Retirar dinero de una cuenta
	        if(m == 5) {
	        	lblApellido.setVisible(true);
	        	txtApellido.setVisible(true);
				lblNombre.setText("# cuenta de ahorros:");
				lblApellido.setText("cantidad a retirar:");		
				txtNombre.setText("");
	    		txtApellido.setText("");
	        }
	    	//Opción 6 del combobox Trasladar dinero a un bolsillo
	        if(m == 6) {
	        	lblApellido.setVisible(true);
	        	txtApellido.setVisible(true);
				lblNombre.setText("# cuenta de ahorros:");
				lblApellido.setText("cantidad a trasladar:");
				txtNombre.setText("");
	    		txtApellido.setText("");
	        }
	    	//Opción 7 del combobox Consultar saldo
	        if(m == 7) {
	        	lblApellido.setVisible(false);
	        	txtApellido.setVisible(false);
				lblNombre.setText("# cuenta de ahorros:");
				txtNombre.setText("");	
	        }
		
	   }
	       /*
	        * Botón enviar, despues de almacenar los valores de los txt en variables con el botón se envían estos 
	        * valores al metodo init2 de la clase EchoTCPCliente con los datos  y se setea el text area con la 
	        * información resultante de la acción 
	        */
		if(e.getSource()==btnEnviar ) {
			//Opción 0 del combobox Abrir cuenta
			if(m == 0) {
				mensaje2 = txtApellido.getText();
				mensaje1 = txtNombre.getText();	
		        try {
					respuesta = ec.init2(mensaje1,mensaje2,m);
					textArea.setText(respuesta);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			//Opción 1 del combobox Crear un bolsillo
			if(m == 1) {
				mensaje1 = txtNombre.getText();	
		        try {
					respuesta = ec.init2(mensaje1,"",m);
					textArea.setText(respuesta);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			//Opción 2 del combobox Cancelar bolsillo
			if(m == 2) {
				mensaje1 = txtNombre.getText();			
				 try {
					 respuesta=ec.init2(mensaje1,"",m);
					 textArea.setText(respuesta);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
			//Opción 3 del combobox Cancelar cuenta de ahorros
			if(m == 3) {
				mensaje1 = txtNombre.getText();	
				 try {
						respuesta=ec.init2(mensaje1,"",m);
						textArea.setText(respuesta);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
			//Opción 4 del combobox Depositar dinero en una cuenta
			if(m == 4) {
				mensaje2 = txtApellido.getText();
				mensaje1 = txtNombre.getText();	
				 try {
					    System.out.println(mensaje1 + "   " + mensaje2 + "   ");
						respuesta = ec.init2(mensaje1,mensaje2,m);
						textArea.setText(respuesta);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
			}
			//Opción 5 del combobox Retirar dinero de una cuenta
			if(m == 5) {
				mensaje2 = txtApellido.getText();
				mensaje1 = txtNombre.getText();	
				 try {
						respuesta = ec.init2(mensaje1,mensaje2,m);
						textArea.setText(respuesta);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
			}
			//Opción 6 del combobox Trasladar dinero a un bolsillo
			if(m == 6) {
				mensaje2 = txtApellido.getText();
				mensaje1 = txtNombre.getText();		
				 try {
						respuesta = ec.init2(mensaje1,mensaje2,m);
						textArea.setText(respuesta);
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
			}
			//Opción 7 del combobox Consultar saldo
			if(m == 7) {
				mensaje1 = txtNombre.getText();	
				 try {
						respuesta = ec.init2(mensaje1,"",m);
						textArea.setText(respuesta);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
			}
		}
	}
}
