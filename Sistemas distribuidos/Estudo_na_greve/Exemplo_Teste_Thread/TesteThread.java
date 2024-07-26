package Exemplo_Teste_Thread;

public class TesteThread {
  public static void main(String[] args) {
    new MinhaThread().start();
    MinhaThread teste = new MinhaThread("Thread de exemplo");
    teste.start();
    System.out.println("Final da Thread main");

  }
} 


/**
 * MinhaThread 
 */
class MinhaThread extends Thread {
  public MinhaThread(String texto){
    super(texto);
  }
  public MinhaThread(){

  }
  public void run(){
    System.out.println("Thread sendo chamada: "+this.getName());
  }

  
}