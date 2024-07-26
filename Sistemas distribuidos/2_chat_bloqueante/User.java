import java.util.Scanner;

public class User {
    private Scanner scanner;

    public User() {
        this.scanner = new Scanner(System.in);
        
    }

    public String lerMsg() {
        System.out.println("Digite a mensagem:");
        return scanner.nextLine();
    }
}
// public class User {
// 	public String lerMsg(){
// 		Scanner scanner = new Scanner(System.in);
// 		System.out.println("Digite sua mensagem:");
// 		String inputString = scanner.nextLine();
// 		scanner.close();
// 		return inputString;
// 	}
// }