package logica;

import java.net.Socket;

public class EchoTCPClient {
	public static final int PORT = 3400;
	public static final String SERVER = "localhost";
	
	private Socket clientSideSocket;
	
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
	 * Metodo igual que el init pero que retorna la respuesta del servidor al cliente
	 * @param msg1 String con la información correspondiente de la clase ventanaPrincipal
	 * @param msg2 String con la información correspondiente de la clase ventanaPrincipal
	 * @param op  valor entero que tiene la opción seleccionada en la clase ventanaPrincipal
	 * @return la información de respuesta del servidor 
	 * @throws Exception
	 */
	public String init2(String msg1,String msg2,int op) throws Exception {
		String respuesta;
		clientSideSocket = new Socket(SERVER, PORT);
		System.out.println("Conexión aceptada en el lado del servidor");
		respuesta = EchoTCPClientProtocol.protocol2(clientSideSocket,msg1,msg2,op);
		clientSideSocket.close();
		return respuesta;
	}
	
	
	public static void main(String[] args) throws Exception {
		EchoTCPClient ec = new EchoTCPClient();
		ec.init();
	}
}
