package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class EchoTCPServerProtocol {
	private static PrintWriter toNetwork;
	private static BufferedReader fromNetwork;
	
	public static void protocol(Socket socket) throws IOException {
		System.out.println("Connection incoming ...");
		createStreams(socket);
		
		String message = fromNetwork.readLine();
		System.out.println("From client: " + message);
		
		String answer = "";
		String[] info = message.split(","); 
		String key = info[0];
		System.out.println("Key " + key);
		HashMap<Integer, Cuenta> lstCuentas =  new HashMap<>();
		int numCuenta = 0;
		Prueba pa = new Prueba();
		
		switch (key) {
		case "ABRIR_CUENTA":
			answer = "ABRIR_CUENTA";
//			String nombre = info[1];
//			String respuesta = pa.agregarCuenta(nombre, lstCuentas);
//			answer = respuesta;
//			numCuenta++;
			break;
		case "ABRIR_BOLSILLO":
			answer = "ABRIR_BOLSILLO";
			break;
		case "CANCELAR_BOLSILLO":
			answer = "CANCELAR_BOLSILLO";
			break;
		case "CANCELAR_CUENTA":
			answer = "CANCELAR_CUENTA";
			break;
		case "DEPOSITAR":
			answer = "DEPOSITAR";
			break;
		case "RETIRAR":
			answer = "RETIRAR";
			break;
		case "TRASLADAR":
			answer = "TRASLADAR";
			break;
		case "CONSULTAR":
			answer = "CONSULTAR";
			break;
		default:
			break;
		}
		
		toNetwork.println(answer);
		System.out.println("Sent to client: " + answer);
	}

	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
}
