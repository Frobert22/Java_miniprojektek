public class Feladat8 {
    public static void main(String[] args) {
        int[] tomb = {2,5,6,33,3432,232,11};


        for (int i = 0; i < tomb.length - 1; i++) {
            for (int j = i + 1; j < tomb.length; j++) {
                if (tomb[i] > tomb[j]) {

                    int k = tomb[i];
                    tomb[i] = tomb[j];
                    tomb[j] = k;
                }
            }
        }


        System.out.println("novekvo:");
        for (int szam : tomb) {
            System.out.print(szam + " ");
        }
    }
}
