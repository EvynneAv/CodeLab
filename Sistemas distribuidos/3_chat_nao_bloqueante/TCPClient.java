import java.net.*;
import java.io.*;
public class TCPClient {
	public static void main (String args[]) {
	User usuario = new User();

	Socket s = null;
	
		try{
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);
			//thrad que escuta e imprime as mensagens
			ListenConnection l = new ListenConnection(s);

			
			DataOutputStream out = new DataOutputStream( s.getOutputStream());

			while (true) {
				String msgUser = usuario.lerMsg();

				if (msgUser.equals("CAMBIO DESLIGO")) {
					break;
				}
				out.writeUTF(msgUser);        	
			}
		} catch (UnknownHostException e){System.out.println("Sock:"+e.getMessage()); 
		} catch (EOFException e){ System.out.println("EOF:"+e.getMessage());
		} catch (IOException e){ System.out.println("IO:"+e.getMessage());
		
	}
	}
}
	


	




