import java.util.Scanner;

public class feladat4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("hany soros legyen: ");
        int size = scanner.nextInt();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
