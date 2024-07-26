import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) throws Exception {
      Socket socket = new Socket("127.0.0.1", 12345);

      DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
      // Recebendo string do usuário
      Scanner scanner = new Scanner(System.in);

      System.out.println("O formato da operação deve ser - 'Número,Símbolo,Número'  e os simbolos são:\n+ para adição \n- Para subtração\n* para multiplicação\n/ para divisão.\nDigite:");

      String inpuString = scanner.nextLine();
      scanner.close();

      saida.writeUTF(inpuString);
      DataInputStream entrada = new DataInputStream(socket.getInputStream());
      String novaMensagem = entrada.readUTF();
      System.out.println("O resultado é: "+ novaMensagem);

      saida.close();
      entrada.close();

      socket.close();
      

  }
}
