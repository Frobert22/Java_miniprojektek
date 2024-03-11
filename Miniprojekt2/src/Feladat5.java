public class Feladat5 {
    public static void main(String[] args) {
        int[] tomb = {11, 2, 3, 4, 5, 6, 7, 8, 9, 3,612};


        int x = tomb[0];
        int y = tomb[tomb.length - 1];

        for (int i = 0; i < tomb.length; i++) {
            if (tomb[i] == x) {
                tomb[i] = y;
            } else if (tomb[i] == y) {
                tomb[i] = x;
            }
        }


        for (int szam : tomb) {
            System.out.print(szam + " ");
        }
        System.out.println();
    }
}
