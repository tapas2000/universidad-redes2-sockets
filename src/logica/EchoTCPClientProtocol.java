package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Clase EchoTCPClientProtocol
 * @author Stefania Aguirre L�pez, Angelica Arroyave Duque, Juan Felipe Tapasco Henao
 */
public class EchoTCPClientProtocol {
	private static final Scanner SCANNER = new Scanner(System.in);
	
	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;
	
	/**
	 * Metodo que une el mensaje con la informaci�n enviada desde EchoTCPCliente dependiendo 
	 * la opci�n elegida por medio de un switch para enviar esa informaci�n al servidor y recibir su respuesta 
	 * para imprimir por medio de la consola 
	 * @param socket Se env�a el cliente como socket ClienteSideSocket 
	 * @throws Exception
	 */
	public static void protocol(Socket socket) throws Exception {
		createStreams(socket);
		
		int opcion;
		boolean salir = false;
		String mensaje = "", msg, msg2;
		
		System.out.println("1. Abrir una cuenta");
		System.out.println("2. Crear un bolsillo");
		System.out.println("3. Cancelar bolsillo");
		System.out.println("4. Cancelar cuenta de ahorros");
		System.out.println("5. Depositar dinero en una cuenta");
		System.out.println("6. Retirar dinero de una cuenta");
		System.out.println("7. Trasladar dinero a un bolsillo");
		System.out.println("8. Consultar saldo");
		System.out.println("9. Carga autom�tica");
		System.out.println("10. Salir");
			
		System.out.println("Por favor, escribe el n�mero de la operaci�n que desea realizar:");
		opcion = SCANNER.nextInt();
			
		switch (opcion) {
			case 1:
				System.out.println("Por favor, ingrese su/s nombre/s:");
				msg = "ABRIR_CUENTA," + SCANNER.next() + " ";
				System.out.println("Por favor, ingrese su/s apellido/s:");
				msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 2:
				System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				mensaje = "ABRIR_BOLSILLO," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
			case 3:
				System.out.println("Por favor, ingrese su n�mero de cuenta bolsillo:");
				mensaje = "CANCELAR_BOLSILLO," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
			case 4:
				System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				mensaje = "CANCELAR_CUENTA," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
			case 5:
				System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				msg = "DEPOSITAR," + SCANNER.next() + ",";
				System.out.println("Por favor, ingrese el valor o cantidad a depositar:");
				msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 6:
				System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				msg = "RETIRAR," + SCANNER.next() + ",";
				System.out.println("Por favor, ingrese el valor o cantidad a retirar:");
				msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 7:
				System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				msg = "TRASLADAR," + SCANNER.next() + ",";
				System.out.println("Por favor, ingrese el valor o cantidad a trasladar:");
				msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 8:
				System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				mensaje = "CONSULTAR," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
			case 9:
				mensaje = "CARGAR,transacciones";
				System.out.println("Mensaje: " + mensaje);
				break;
			case 10:
				salir = true;
				break;
			default:
				break;
		}
		
		toNetwork.println(mensaje);
		
		String fromServer = fromNetwork.readLine();
		
		String[] fs = fromServer.split("-");
		String fromServer2 = "";
		
		for(int i = 0; i < fs.length; i++) {
			fromServer2 += fs[i] + "\n";
		}		
		
		System.out.println("From server: " + fromServer2);
	}
	
	/**
	 * Metodo que une el mensaje con la informaci�n enviada desde EchoTCPCliente dependiendo 
	 * la opci�n enviada por medio de un switch para enviar esa informaci�n al servidor y recibir su respuesta 
	 * por medio del fromNetwork y toNetwork
	 * @param socket Se env�a el cliente como socket ClienteSideSocket 
	 * @param mensaje1 String con la informaci�n correspondiente de la clase EchoTCPCliente
	 * @param mensaje2 String con la informaci�n correspondiente de la clase EchoTCPCliente
	 * @param op valor entero que tiene la opci�n seleccionada en la clase EchoTCPCliente
	 * @return un String con la informaci�n que envia el servidor como respuesta
	 * @throws Exception
	 */
	public static String protocol2(Socket socket, String mensaje1, String mensaje2, int op) throws Exception {
		createStreams(socket);
        
        int opcion = op +1;
		boolean salir = false;
		String mensaje = "", msg, msg2;
				
		switch (opcion) {
			case 1:
				msg ="ABRIR_CUENTA," + mensaje1 + " ";
				msg2 = mensaje2;
				mensaje = msg + msg2;
				break;
			case 2:
				mensaje = "ABRIR_BOLSILLO," + mensaje1;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 3:
				mensaje = "CANCELAR_BOLSILLO," + mensaje1;
				break;
			case 4:
				System.out.println("Entro a la opci�n 4");
				mensaje = "CANCELAR_CUENTA," + mensaje1;
				break;
			case 5:
				msg = "DEPOSITAR," + mensaje1;
				msg2 = mensaje2;
				mensaje = msg +","+ msg2;
				break;
			case 6:
				msg = "RETIRAR," +mensaje1;
				msg2 = mensaje2;
				mensaje = msg +","+ msg2;
				break;
			case 7:
				msg = "TRASLADAR," + mensaje1;
				msg2 = mensaje2;
				mensaje = msg +","+ msg2;
				break;
			case 8:
				mensaje = "CONSULTAR," + mensaje1;
				break;
			default:
				break;
		}
		
		toNetwork.println(mensaje);
        
		String fromServer = fromNetwork.readLine();
		System.out.println("From server: " + fromServer);
		return fromServer;
		
	}
	
	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
}