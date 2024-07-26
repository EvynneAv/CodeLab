package client;
import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class TCPClient {
    
      Socket s = null;
      DataOutputStream out;
      DataInputStream in;

      public TCPClient(String ipServer, int portServer) throws UnknownHostException, IOException{
        try {
          s = new Socket(ipServer, portServer);
        } catch (UnknownHostException e) {System.out.println("Sock:"+e.getMessage());
        } catch (IOException e){ System.out.println("IO:"+e.getMessage());
	      }
      }

      public void sendRequest(String request)throws IOException{
        out = new DataOutputStream(s.getOutputStream());
        try {
          System.out.println("Enviando request: "+ request);
          out.writeUTF(request);
          
        } catch (IOException e){ System.out.println("IO:"+e.getMessage());
      }
      }

      public String getResponse()throws IOException{
        DataInputStream in = new DataInputStream(s.getInputStream());
        try {
          return in.readUTF();
        } catch (EOFException e){ 
          System.out.println("EOF:"+e.getMessage());
          return null;
        } catch (IOException e){ System.out.println("IO:"+e.getMessage());
          return  null;
        }
      }

      public void close(){
          if(s!=null){
            try {
              s.close();
            } catch (IOException e){System.out.println("close:"+e.getMessage()); }
          }
      }
    
}