import java.net.*;

import java.io.*;
public class TCPClient {
	public static void main (String args[]) {
	User usuario = new User();

	Socket s = null;
	
		try{
			int serverPort = 7896;
			s = new Socket("localhost", serverPort);

			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out = new DataOutputStream( s.getOutputStream());

			while (true) {
				String msgUser = usuario.lerMsg();

				if (msgUser.equals("CAMBIO DESLIGO")) {
					break;
				}
				out.writeUTF(msgUser);        	// UTF is a string encoding see Sn 4.3
				System.out.println("Aguarde resposta...");
				String data = in.readUTF();	      
				System.out.println("Received: "+ data);      
			}
		} catch (UnknownHostException e){System.out.println("Sock:"+e.getMessage()); 
		} catch (EOFException e){ System.out.println("EOF:"+e.getMessage());
		} catch (IOException e){ System.out.println("IO:"+e.getMessage());
	} finally { if(s!=null) { try { s.close(); } catch (IOException e){System.out.println("close:"+e.getMessage()); } }
	}
	}
	}
	




