package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.crypto.Data;

import calculator.Calculator;
//servidor singlethread
public class TCPServer {
  static Socket clientSocket;
  static Calculator calculadora = Calculator.getInstance();

  public static void main(String[] args)throws Exception  {
    int serverPort = 7896;
    ServerSocket linstenSocket = new ServerSocket(serverPort);

    System.out.println("A porta "+serverPort+" foi aberta");
		System.out.println("Aguardando conexão...");

    while (true) {
      clientSocket = linstenSocket.accept();
      System.out.println("Cliente "+ clientSocket.getInetAddress().getHostAddress()+" conectado");

      //Tratamento da requisição
      System.out.println("Antes de fazer a get request");
      String req = TCPServer.getRequest();
      System.out.println("Depois de fazer a get request");
      System.out.println(req);
      String[] array_op = req.split(",");
      double a = Double.parseDouble(array_op[0]);
      double b = Double.parseDouble(array_op[0]);
      double response=0;
      switch (array_op[1]) {
        case "+":
          response = calculadora.add(a, b);
          break;
        case "-":
          response = calculadora.sub(a, b);
          break;
        case "*":
          response = calculadora.mult(a, b);
          break;
        case "/":
          response = calculadora.div(a, b);
          break;
        default:
          break;
      }
      Thread.sleep(100);
      //mandando resposta
      TCPServer.sendResponse(Double.toString(response));
    }
    

    
  }

  public static String getRequest() throws IOException {
    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
    String data = in.readUTF();
    System.out.println("Recebido: "+data);
    return data;
	}
	
	public static void sendResponse(String response) throws IOException {
    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
    System.out.println("Resposta enviada: "+response);
    out.writeUTF(response);

	}
}
