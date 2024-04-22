import java.util.InputMismatchException;
import java.util.Scanner;

public class Bankos {
    public static void main(String[] args) {
        int szam;
        boolean rendben = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                szam = sc.nextInt();
                rendben = true;
            } catch (InputMismatchException e) {
                System.out.println("Egész számot kérek");
            } catch (NumberFormatException e) {
                System.out.println("Egész számot kérek újra");
            }
        } while (!rendben);
    }
}
