package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.print.attribute.standard.RequestingUserName;

import calculator.*;

public class TCPServerMT{

	public static void main(String args[]) {
		Socket clientSocket;
		try {
			int serverPort = 8000;
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while (true) {
				clientSocket = listenSocket.accept();
				Connection connection = new Connection(clientSocket);
				connection.start();
			}
		} catch (IOException e) {
			
		}
	}
}

class Connection extends Thread {
	Socket clientSocket;
	Calculator calculadora = null;
	DataInputStream in = null;
	DataOutputStream out = null;

	public Connection(Socket aClientSocket) throws IOException {
    calculadora = Calculator.getInstance();
    clientSocket = aClientSocket;
    in = new DataInputStream(clientSocket.getInputStream());
    out = new DataOutputStream((clientSocket.getOutputStream()));
	}

	public String getRequest( ) throws IOException {
    
    String data = in.readUTF();
    
    return data;
	}

	public void sendResponse(String response) throws IOException {
    
    out.writeUTF(response);
	}
	
	public void run() {
    
    String req = null;
    try {
      req = getRequest();
    } catch (IOException e) {
      e.printStackTrace();
    }
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
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //mandando resposta
      try {
        sendResponse(Double.toString(response));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    

		//getRequest()
		//tratamento da requisicao
		//Thread.sleep(100);
		//sendResponse()	
  }

