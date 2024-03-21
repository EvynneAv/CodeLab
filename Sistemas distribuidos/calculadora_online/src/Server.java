import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {

      ServerSocket serverSocket = new ServerSocket(54321);
      System.out.println("A porta 54321 foi aberta");
      System.out.println("Servidor esperando receber mensagem de cliente...");

      Socket socket = serverSocket.accept();

      System.out.println("Cliente "+ socket.getInetAddress().getHostAddress()+" conectado");

      DataInputStream entrada = new DataInputStream(socket.getInputStream());
      String mensagem = entrada.readUTF();
      String[] array_op = mensagem.split(",");
      float a = Float.parseFloat(array_op[0]);
      float b = Float.parseFloat(array_op[2]);
      String novaMensagem = "";
      switch (array_op[1]) {
        case "+":
          novaMensagem = Float.toString(a+b);
          break;
          case "-":
          novaMensagem = Float.toString(a-b);
          break;
          case "*":
          novaMensagem = Float.toString(a*b);
          break;
          case "/":
          novaMensagem = Float.toString(a/b);
          break;
      
        default:
          break;
      }


      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      saida.writeUTF(novaMensagem);
      entrada.close();
      saida.close();

      socket.close();
      serverSocket.close();


    }
}