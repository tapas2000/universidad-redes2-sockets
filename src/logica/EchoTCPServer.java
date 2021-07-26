package logica;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase EchoTCPServer
 * @author Stefania Aguirre López, Angelica Arroyave Duque, Juan Felipe Tapasco Henao
 */
public class EchoTCPServer {
	public static final int PORT = 3400;
	
	private ServerSocket listener;
	private Socket serverSideSocket;
	
	/**
	 * Constructor
	 */
	public EchoTCPServer() {
		System.out.println("Echo TCP server ...");
	}
	
	private void init() throws Exception {
		listener = new ServerSocket(PORT);
		
		while(true) {
			System.out.println("The echo TCP server is waiting for a client ...");
			serverSideSocket = listener.accept();
			
			EchoTCPServerProtocol.protocol(serverSideSocket);
		}
	}
	
	/**
	 * Método main
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		EchoTCPServer es = new EchoTCPServer();
		es.init();
	}
}
