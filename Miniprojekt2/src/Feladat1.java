import java.util.Scanner;

public class Feladat1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("adj meg 1 szot:");
        String szo = scanner.nextLine();

        if (szo.length() > 0) {
            char elsoKarakter = szo.charAt(0);
            char utolsoKarakter = szo.charAt(szo.length() - 1);

            System.out.println("az elso karakter: " + elsoKarakter);
            System.out.println("az utolso:   " + utolsoKarakter);
        } else {
            System.out.println("nincs megadva szo");
        }


    }
}