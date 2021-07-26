package logica;

import java.net.Socket;

/**
 * Clase EchoTCPClient
 * @author Stefania Aguirre López, Angelica Arroyave Duque, Juan Felipe Tapasco Henao
 */
public class EchoTCPClient {
	public static final int PORT = 3400;
	public static final String SERVER = "localhost";
	
	private Socket clientSideSocket;
	
	/**
	 * Constructor
	 */
	public EchoTCPClient() {
		System.out.println("File TCP Client ...");
	}
	
	public void init() throws Exception {
		clientSideSocket = new Socket(SERVER, PORT);
		System.out.println("Conexión aceptada en el lado del servidor");
		
		EchoTCPClientProtocol.protocol(clientSideSocket);
			
		clientSideSocket.close();
	}
	
	/**
	 * Método main
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		EchoTCPClient ec =  new EchoTCPClient();
		ec.init();
	}
}
