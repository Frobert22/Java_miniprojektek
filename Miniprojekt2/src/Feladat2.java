import java.util.Scanner;
public class Feladat2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("irjon 1 szot  amiben van 'a' betu:");
        String szo = scanner.nextLine();

        String ujszo = szo.replace('a', '*');

        System.out.println("az uj szo " +ujszo);


    }
}
