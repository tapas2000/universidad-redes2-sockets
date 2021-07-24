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

	private static HashMap<String, Cuenta> lstCuentas =  new HashMap<>();
	
	public static void protocol(Socket socket) throws IOException {
		System.out.println("Connection incoming ...");
		createStreams(socket);
		
		String message = fromNetwork.readLine();
		System.out.println("From client: " + message);
		
		String[] info = message.split(","); 
		String key = info[0];
//		System.out.println("Key " + key);
		System.out.println(lstCuentas);
		Prueba pa = new Prueba();
		int numCuenta = 0, cuentaAhorros;
		String answer = "", respuesta = "", nombre, numCuentaBolsillo;
		double cantidad;
		
		switch (key) {
			case "ABRIR_CUENTA":
//				answer = "ABRIR_CUENTA";
				nombre = info[1].trim();
				respuesta = pa.agregarCuenta(nombre, lstCuentas);
				answer = respuesta;
				numCuenta++;
				break;
			case "ABRIR_BOLSILLO":
//				answer = "ABRIR_BOLSILLO";
				cuentaAhorros = Integer.parseInt(info[1]);
				respuesta = pa.abrirBolsillo(cuentaAhorros, lstCuentas);
				break;
			case "CANCELAR_BOLSILLO":
//				answer = "CANCELAR_BOLSILLO";
				numCuentaBolsillo = info[1].trim();
				respuesta = pa.cerrarBolsillo(numCuentaBolsillo, lstCuentas);
				break;
			case "CANCELAR_CUENTA":
//				answer = "CANCELAR_CUENTA";
				cuentaAhorros = Integer.parseInt(info[1]);
				respuesta = pa.eliminarCuenta(numCuenta, lstCuentas);
				break;
			case "DEPOSITAR":
//				answer = "DEPOSITAR";
				cuentaAhorros = Integer.parseInt(info[1]);
				cantidad = Double.parseDouble(info[2]);
				respuesta = pa.depositar(cuentaAhorros, cantidad, lstCuentas);
				break;
			case "RETIRAR":
//				answer = "RETIRAR";
				cuentaAhorros = Integer.parseInt(info[1]);
				cantidad = Double.parseDouble(info[2]);
				respuesta = pa.retirar(cuentaAhorros, cantidad, lstCuentas);
				break;
			case "TRASLADAR":
//				answer = "TRASLADAR";
				cuentaAhorros = Integer.parseInt(info[1]);
				cantidad = Double.parseDouble(info[2]);
				respuesta = pa.trasladar(cuentaAhorros, cantidad, lstCuentas);
				break;
			case "CONSULTAR":
//				answer = "CONSULTAR";
				String cuentaA = info[1];
				respuesta = pa.consultarSaldoCuenta(cuentaA, lstCuentas);
				break;
			default:
				break;
		}
		answer = respuesta;
		
		toNetwork.println(answer);
		System.out.println("Sent to client: " + answer);
	}

	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
}
