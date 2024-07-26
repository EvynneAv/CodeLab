import java.io.DataInputStream;
import java.net.Socket;

import com.azul.crs.client.Client;

import java.io.*;


public class ListenConnection extends Thread {
  DataInputStream in;
	Socket clientSocket;
  public ListenConnection(Socket aClientSocket){
    try {
      clientSocket = aClientSocket;
      in = new DataInputStream(clientSocket.getInputStream());
      this.start();
    } catch (Exception e) {
      System.out.println("Connection:"+e.getMessage());
    }
  }
  public void run(){
    try {
      while (true) {
        if (in.available()>0) {
          String data = in.readUTF();
        System.out.println("Recebeu: "+ data);
        System.out.println("Digite a mensagem:");
        }else{
          Thread.sleep(100);
        }
        
      }
      

    } catch (EOFException e) {
      System.out.println("EOF:"+e.getMessage());
    } catch (IOException e){System.out.println("IO:"+e.getLocalizedMessage());
    } catch (InterruptedException e) {
      // Thread interrompida, pode ser tratado de acordo com os requisitos do aplicativo
      System.out.println("Thread interrompida: " + e.getMessage());

    }finally {
      try {
          clientSocket.close();
      } catch (IOException e) {
          System.out.println("Erro ao fechar o socket: " + e.getMessage());
      // }finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
    // finally{try{clientSocket.close();}catch(IOException e){}}
  }
  }}}

