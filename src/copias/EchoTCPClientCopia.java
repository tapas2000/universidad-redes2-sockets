package copias;

import java.net.Socket;

public class EchoTCPClientCopia {
	public static final int PORT = 3400;
	public static final String SERVER = "localhost";
	
	private Socket clientSideSocket;
	
	public EchoTCPClientCopia() {
		System.out.println("File TCP Client ...");
	}
	
	public void init(String msg1,String msg2,int op) throws Exception {
		clientSideSocket = new Socket(SERVER, PORT);
		System.out.println("Conexión aceptada en el lado del servidor");
		
		while(true) {
			EchoTCPClientProtocol.protocol(clientSideSocket,msg1,msg2,op);
			
			clientSideSocket.close();
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
//		EchoTCPClient ec = new EchoTCPClient();
	}
}
