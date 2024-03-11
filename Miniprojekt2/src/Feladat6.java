public class Feladat6 {
    public static void main(String[] args) {
        int[] tomb = {1,1111,11,111,123,134,145,-1};


        for (int i = 0; i < tomb.length - 1; i++) {
            for (int j = i + 1; j < tomb.length; j++) {
                if (tomb[i] > tomb[j]) {

                    int k = tomb[i];
                    tomb[i] = tomb[j];
                    tomb[j] = k;
                }
            }
        }


        System.out.println("Legkisebb szam " + tomb[0]);
        System.out.println("Legnagyobb szam " + tomb[tomb.length - 1]);
    }
}
