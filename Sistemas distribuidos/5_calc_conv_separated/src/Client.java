import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
      //input do client
      int input =1;


      if (input==1) {
        Socket socket = new Socket("127.0.0.1", 54321);
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("2,+,10");
       
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF();
        System.out.println(novaMensagem); 
      
        entrada.close();
        saida.close();
  
        socket.close(); 
      }else if (input ==2) {
        Socket socket = new Socket("127.0.0.1", 54322);
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("euro,10");
        
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF();
        System.out.println(novaMensagem); 
  
        entrada.close();
        saida.close();
  
        socket.close(); 
      }
      

     



      
    }
}