import java.net.*;
import java.io.*;
public class TCPServer {
    public static void main (String args[]) {
			User userServer = new User();
	try{
		int serverPort = 7896; 
		ServerSocket listenSocket = new ServerSocket(serverPort);
		System.out.println("A porta 54321 foi aberta");
		System.out.println("Aguardando conexão...");
		Socket clientSocket = listenSocket.accept();
		System.out.println("Cliente "+ clientSocket.getInetAddress().getHostAddress()+" conectado");

		ListenConnection l  = new ListenConnection(clientSocket);

		DataOutputStream out =new DataOutputStream( clientSocket.getOutputStream());
		while(true) {

			String msgUserServer = userServer.lerMsg();
			if (msgUserServer.equals("CAMBIO DESLIGO")) {
				listenSocket.close();
				break;
			}
			out.writeUTF(msgUserServer); 
		}
	} catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }
}

