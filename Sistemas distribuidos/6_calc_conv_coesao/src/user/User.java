package user;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import client.TCPClient;

public class User {
  TCPClient clienteTcp = null;

  public User (){
    try {
      clienteTcp = new TCPClient("localhost", 7896);
    } catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  }

  public int selecionaOp() throws IOException{
    int operacao = 0;
    String resultado = null;
    //usa o buffered para ler em blocos e melhorar a eficiência
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    String opt = null;

    do{
      //lê a operação que o cliente quer
      opt = stdin.readLine();
      //enquanto o usuário digitar enter ou vazio, vai continuar lendo
    }while(opt.equals("\n")||opt.equals("")||opt.isEmpty());
    //como operação é um número passa para int
    operacao = Integer.parseInt(opt);

    switch (operacao) {
      case 1:
        System.out.print("Digite a operação de soma dividindo os caracteres por ',': (ex: 1,+,2) ");
        String a = stdin.readLine();
        clienteTcp.sendRequest(a);
        resultado = clienteTcp.getResponse();
        System.out.println("Resultado: "+resultado);
        
        break;
      case 2:
      System.out.print("Digite a operação de subtração dividindo os caracteres por ',': (ex: 1,-,2) ");
      clienteTcp.sendRequest(stdin.readLine());
      resultado = clienteTcp.getResponse();
      System.out.println("Resultado: "+resultado);
      
        break;
      case 3:
      System.out.print("Digite a operação de multiplicação dividindo os caracteres por ',': (ex: 1,*,2) ");
      clienteTcp.sendRequest(stdin.readLine());
      resultado = clienteTcp.getResponse();
      System.out.println("Resultado: "+resultado);
      
        break;
      case 4:
      System.out.print("Digite a operação de soma dividindo os caracteres por ',': (ex: 1,/,2) ");
      clienteTcp.sendRequest(stdin.readLine());
      resultado = clienteTcp.getResponse();
      System.out.println("Resultado: "+resultado);
      
        break;
    
      default:
      System.out.println("Operação inválida, tente outra.");
        break;
    }
    return operacao;
  }
  public void printMenu() {
		System.out.println("\nDigite o n# da função que deseja executar: ");
		System.out.println("1 - Soma");
		System.out.println("2 - Subtracão");
		System.out.println("3 - Divisão");
		System.out.println("4 - Multiplicação");
		System.out.println("0 - Sair\n");
	}

  public static void main(String[] args) {
    User usuario = new User();
    int operacao = -1;

    do{
      usuario.printMenu();
      try {
        operacao = usuario.selecionaOp();
      } catch (Exception e) {
        System.out.println("Escolha uma das operações pelo número");
      }
    }while(operacao!=0);
  }
}