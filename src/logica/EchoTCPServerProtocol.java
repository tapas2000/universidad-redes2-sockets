package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase EchoTCPServerProtocol
 * @author Stefania Aguirre López, Angelica Arroyave Duque, Juan Felipe Tapasco Henao
 */
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
		Prueba pa = new Prueba();
		int cuentaAhorros;
		String answer = "", respuesta = "", nombre, numCuentaBolsillo;
		double cantidad;
		
		switch (key) {
			case "ABRIR_CUENTA":
				nombre = info[1].trim();
				respuesta = pa.agregarCuenta(nombre, lstCuentas);
				break;
			case "ABRIR_BOLSILLO":
				cuentaAhorros = Integer.parseInt(info[1]);
				respuesta = pa.abrirBolsillo(cuentaAhorros, lstCuentas);
				break;
			case "CANCELAR_BOLSILLO":
				numCuentaBolsillo = info[1].trim();
				respuesta = pa.cerrarBolsillo(numCuentaBolsillo, lstCuentas);
				break;
			case "CANCELAR_CUENTA":
				cuentaAhorros = Integer.parseInt(info[1]);
				respuesta = pa.eliminarCuenta(cuentaAhorros, lstCuentas);
				break;
			case "DEPOSITAR":
				cuentaAhorros = Integer.parseInt(info[1]);
				cantidad = Double.parseDouble(info[2]);
				respuesta = pa.depositar(cuentaAhorros, cantidad, lstCuentas);
				break;
			case "RETIRAR":
				cuentaAhorros = Integer.parseInt(info[1]);
				cantidad = Double.parseDouble(info[2]);
				respuesta = pa.retirar(cuentaAhorros, cantidad, lstCuentas);
				break;
			case "TRASLADAR":
				cuentaAhorros = Integer.parseInt(info[1]);
				cantidad = Double.parseDouble(info[2]);
				respuesta = pa.trasladar(cuentaAhorros, cantidad, lstCuentas);
				break;
			case "CONSULTAR":
				String cuentaA = info[1];
				respuesta = pa.consultarSaldoCuenta(cuentaA, lstCuentas);
				break;
			case "CARGAR":
				String nombreArchivo = info[1];
				respuesta = mensajeServidor(pa.cargarTransacciones(nombreArchivo));
				break;
			default:
				break;
		}
		
		answer = respuesta;
		
		toNetwork.println(answer);
		
		String[] ar = answer.split("-");
		String answer2 = "";
		
		for(int i = 0; i < ar.length; i++) {
			answer2 += ar[i] + "\n";
		}
		
		System.out.println("Sent to client: " + answer2);
	}
	
	/**
	 * Método encargado de convertir el mensaje del servidor que es un arraylist a 
	 * un String separado por guion "-"
	 * @param mensajes es el arraylist que llega desde el servidor
	 * @return un String con la información separado por guin
	 */
	public static String mensajeServidor(ArrayList<String> mensajes) {
		String respuesta = "";
		
		for(int i = 0; i < mensajes.size(); i++) {
			respuesta += mensajes.get(i) + "-";
		}
		
		return respuesta;
	}

	/**
	 * Crea los flujos de conexión
	 * @param socket
	 * @throws IOException
	 */
	private static void createStreams(Socket socket) throws IOException {
		toNetwork = new PrintWriter(socket.getOutputStream(), true);
		fromNetwork = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
}
