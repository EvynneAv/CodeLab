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
      String novaMensagem = "";
      String[] array_op = mensagem.split(",");
      System.out.println(mensagem);
      System.out.println(array_op[0]);
      switch (array_op[0]) {
        case "1":
          System.out.println("Calculadora");
          float a = Float.parseFloat(array_op[1]);
          float b = Float.parseFloat(array_op[3]);
  
          switch (array_op[2]) {
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
  
          break;
        case "2":
        System.out.println("Conversor");
              String moeda = array_op[1];
      float valor = Float.parseFloat(array_op[2]);
      switch (moeda) {
        case "dolar": 
        novaMensagem = Float.toString(valor*5);
        break;
        case "euro":
        novaMensagem = Float.toString(valor*6);
        break;

        default:
        novaMensagem = "erro";
          break;
      }
        break;
        default:
        System.out.println("Não deu certo");
          break;
      }      
      
    System.out.println("Resultado" + novaMensagem);

      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      saida.writeUTF(novaMensagem );
      entrada.close();
      saida.close();

      socket.close();
      serverSocket.close();


    }
}