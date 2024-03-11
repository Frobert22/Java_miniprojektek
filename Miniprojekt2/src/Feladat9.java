public class Feladat9 {
    public static void main(String[] args) {
        int[][] tomb = new int[10][10];


        for (int i = 0; i < 10; i++) {
            tomb[i][i] = i;
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j < i) {
                    tomb[i][j] = 0;
                } else if (j > i) {
                    tomb[i][j] = 0;
                }
            }
        }


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tomb[i][j] + " ");
            }
            System.out.println();
        }
    }
}
