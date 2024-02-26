import java.util.Scanner;

public class feladat2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int probalkozasokSzama = 3;

        System.out.println("add meg a jelszot:");

        while (probalkozasokSzama > 0) {
            String jelszo = scanner.nextLine();
            if (ellenorizJelszot(jelszo)) {
                System.out.println("Sikeres belepes!");
                break;
            } else {
                probalkozasokSzama--;
                if (probalkozasokSzama == 0) {
                    System.out.println("3 sikertelen. kilep");
                    break;
                }
                System.out.println("rossz jelszo " + probalkozasokSzama + " maradt");
                System.out.println("ujra");
            }
        }


    }

    public static boolean ellenorizJelszot(String jelszo) {

        return jelszo.equals("titkos");
    }
}
