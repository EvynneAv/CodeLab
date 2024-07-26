import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
      // 1 - abrir conexão
      Socket socket = new Socket("127.0.0.1", 54321);
      // 2 - Definir stream de saída de dados do cliente
      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      saida.writeUTF("1,+,1");//Enviar mensagem em minúsculo para o servidor
      // 3 - Definir stream de entrada de dados no cliente
      DataInputStream entrada = new DataInputStream(socket.getInputStream());
      String novaMensagem = entrada.readUTF();//Receber mensagem em maiúsculo do servidor
      System.out.println(novaMensagem); //Mostrar mensagem em maiúsculo no cliente
      // 4 - fechar entrada e saída de dados
      entrada.close();
      saida.close();
      // 5 - Fechar o Socket
      socket.close(); 

      
    }
}