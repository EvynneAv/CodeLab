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

    
    while (true) {
      clientSocket = linstenSocket.accept();
      
      String req = TCPServer.getRequest();
      
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
    
    return data;
	}
	
	public static void sendResponse(String response) throws IOException {
    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
    
    out.writeUTF(response);

	}
}
