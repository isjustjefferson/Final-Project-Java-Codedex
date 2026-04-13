import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner (System.in);
        CaesarCipher caesarCipher = new CaesarCipher();

        System.out.println("This is an app to apply Caesar Cipher!");
        System.out.print("Please, set a displacement: ");
        int displacement = scanner.nextInt(); scanner.nextLine();

        System.out.print("Insert the message to codify: ");
        String message = scanner.nextLine();

        caesarCipher.startCodify(message, displacement);
    }
}
