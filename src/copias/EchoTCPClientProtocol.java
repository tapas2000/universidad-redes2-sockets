package copias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoTCPClientProtocol {
	private static final Scanner SCANNER = new Scanner(System.in);
	
	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;
	
	public static void protocol(Socket socket, String mensaje1, String mensaje2, int op) throws Exception {
		createStreams(socket);
		
		int opcion = op +1;
		boolean salir = false;
		String mensaje = "", msg, msg2;
		
		//while(!salir) {
//		System.out.println("1. Abrir una cuenta");
//		System.out.println("2. Crear un bolsillo");
//		System.out.println("3. Cancelar bolsillo");
//		System.out.println("4. Cancelar cuenta de ahorros");
//		System.out.println("5. Depositar dinero en una cuenta");
//		System.out.println("6. Retirar dinero de una cuenta");
//		System.out.println("7. Trasladar dinero a un bolsillo");
//		System.out.println("8. Consultar saldo");
//		System.out.println("9. Salir");
//			
//		System.out.println("Por favor, escribe el n�mero de la operaci�n que desea realizar:");
//		opcion = SCANNER.nextInt();
			
		switch (opcion) {
			case 1:
				//System.out.println("Entro a la opci�n 1");
				//System.out.println("Por favor, ingrese su/s nombre/s:");
				msg ="ABRIR_CUENTA," + mensaje1 + " ";
				//msg = "ABRIR_CUENTA," + SCANNER.next() + " ";
				//System.out.println("Por favor, ingrese su/s apellido/s:");
				msg2 = mensaje2;
				//msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 2:
				//System.out.println("Entro a la opci�n 2");
				//System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				mensaje = "ABRIR_BOLSILLO," + mensaje1;
				//mensaje = "ABRIR_BOLSILLO," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
			case 3:
				//System.out.println("Entro a la opci�n 3");
				//System.out.println("Por favor, ingrese su n�mero de cuenta bolsillo:");
				mensaje = "CANCELAR_BOLSILLO," + mensaje1;
				//mensaje = "CANCELAR_BOLSILLO," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
			case 4:
				System.out.println("Entro a la opci�n 4");
				//System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				mensaje = "CANCELAR_CUENTA," + mensaje1;
				//mensaje = "CANCELAR_CUENTA," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
			case 5:
				//System.out.println("Entro a la opci�n 5");
				//System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				msg = "DEPOSITAR," + mensaje1;
				//msg = "DEPOSITAR," + SCANNER.next() + ",";
				System.out.println("Por favor, ingrese el valor o cantidad a depositar:");
				msg2 = mensaje2;
				//msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 6:
				//System.out.println("Entro a la opci�n 6");
				//System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				msg = "RETIRAR," +mensaje1;
				//msg = "RETIRAR," + SCANNER.next() + ",";
				System.out.println("Por favor, ingrese el valor o cantidad a retirar:");
				msg2 = mensaje2;
				//msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 7:
				//System.out.println("Entro a la opci�n 7");
				//System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				msg = "TRASLADAR," + mensaje1;
				//msg = "TRASLADAR," + SCANNER.next() + ",";
				System.out.println("Por favor, ingrese el valor o cantidad a trasladar:");
				msg2 = mensaje2;
				//msg2 = SCANNER.next();
				mensaje = msg + msg2;
				System.out.println("Mensaje: " + mensaje);
				break;
			case 8:
				//System.out.println("Entro a la opci�n 8");
				//System.out.println("Por favor, ingrese su n�mero de cuenta de ahorros:");
				mensaje = "CONSULTAR," + mensaje1;
				//mensaje = "CONSULTAR," + SCANNER.next();
				System.out.println("Mensaje: " + mensaje);
				break;
//			case 9:
//				salir = true;
//				break;
			default:
				break;
		}
		toNetwork.println(mensaje);
		
		String fromServer = fromNetwork.readLine();
		System.out.println("From server: " + fromServer);
		//return fromserver;
		//}
	}

	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
}
