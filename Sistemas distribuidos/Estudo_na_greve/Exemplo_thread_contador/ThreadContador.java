package Exemplo_thread_contador;

import javax.swing.plaf.synth.SynthDesktopIconUI;

public class ThreadContador{
  public static void main(String[] args) {
    Contadora c = new Contadora();
    new Thread(c).start();
  }
}

class Contadora implements Runnable{
  int contador = 0;

  public void run(){
    // contar de 1 até 10
    while (contador++ < 10) {
      System.out.println("Valor da variável contador: "+contador);
      try {
        Thread.sleep(500*(int)(Math.random()*5+1));
      } catch (InterruptedException exec) {
        exec.printStackTrace();
      }
    }
    System.out.println("Final da contagem.");
  }
}