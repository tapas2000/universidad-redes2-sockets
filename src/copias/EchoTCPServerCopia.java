package copias;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoTCPServerCopia {
	public static final int PORT = 3400;
	
	private ServerSocket listener;
	private Socket serverSideSocket;
	private String mensaje;
	private VentanaCopia vc = new VentanaCopia();
	
	public EchoTCPServerCopia() {
		System.out.println("Echo TCP server ...");
	}
	
	private void init() throws Exception {
		listener = new ServerSocket(PORT);
		
		while(true) {
			System.out.println("The echo TCP server is waiting for a client ...");
			serverSideSocket = listener.accept();
			
			mensaje = EchoTCPServerProtocolCopia.protocol(serverSideSocket);
		    System.out.println(mensaje + "mensaje en el server");
		}
	}
	
	private String retornarRespuesta() {
		return mensaje;
	}
	
	public static void main(String[] args) throws Exception {
		EchoTCPServerCopia es = new EchoTCPServerCopia();
		es.init();
	}
}
