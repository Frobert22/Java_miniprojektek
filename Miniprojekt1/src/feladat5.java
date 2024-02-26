import java.util.Scanner;

public class feladat5 {
    public static boolean csakAlfabetikus(String str) {

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!Character.isLetter(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("irja a szoveget ");
        String szoveg = sc.nextLine();

        if (csakAlfabetikus(szoveg)) {
            System.out.println("A string csak betuket tartalmaz.");
        } else {
            System.out.println("A string betun kivuli karaktert is tartalmaz.");
        }
    }
}
