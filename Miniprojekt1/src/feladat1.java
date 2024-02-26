import java.util.Scanner;

public class feladat1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ird ide az inputot");
        int szam = sc.nextInt();
        for (int i = 1; i < 11; i++) {
            if (szam > 10 || szam < 1) {
                System.out.println(" nincs benne");

            } else {
                for (i = 1; i <= 10; i++) {
                    System.out.println(szam + " * " + i + " = " + (szam * i));
                }
            }

        }

    }
}
