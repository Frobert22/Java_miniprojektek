public class Feladat7 {
    public static void main(String[] args) {
        int[] tomb = {122, 2, 2, 2, 4, 1, 7, 100, 6, 1,4,122};

        boolean[] volt = new boolean[tomb.length];

        for (int i = 0; i < tomb.length; i++) {
            if (!volt[i]) {
                int szamol = 1;
                for (int j = i + 1; j < tomb.length; j++) {
                    if (tomb[i] == tomb[j]) {
                        szamol++;
                        volt[j] = true;
                    }
                }
                if (szamol > 1) {
                    System.out.println("szam: " + tomb[i] + ", megjelenese : " + szamol);
                }

            }
        }
    }
}
