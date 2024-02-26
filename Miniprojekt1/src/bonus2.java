import java.util.Scanner;
import java.util.Random;

public class bonus2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int szam = random.nextInt(100) + 1;
        int tip;
        int probalkozas = 0;

        System.out.println("Melyik számra gondolsz?");

        do {
            System.out.print("Találd ki a számot: ");
            tip = scanner.nextInt();
            probalkozas++;
            if (tip > szam) {
                System.out.println("Kisebb számot írj.");
            } else if (tip < szam) {
                System.out.println("Írj nagyobb számot.");
            } else {
                System.out.println("Gratulálok, a szám: " + szam);
                System.out.println("Próbálkozások száma: " + probalkozas);
            }
        } while (tip != szam);


    }
}
