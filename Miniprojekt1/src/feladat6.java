public class feladat6 {
    public static boolean egyenloEgeszTombok(int[] tomb1, int[] tomb2) {
        if (tomb1.length != tomb2.length) {
            return false;
        }

        for (int i = 0; i < tomb1.length; i++) {
            System.out.printf(tomb1[i] + " ");

        }
        System.out.println(" ");

        for (int i = 0; i < tomb2.length; i++) {
            System.out.printf(tomb2[i] + " ");
        }
        System.out.println(" ");

        for (int i = 0; i < tomb1.length; i++) {
            if (tomb1[i] != tomb2[i]) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {

        int[] tomb1 = {1, 2, 3, 4, 5};
        int[] tomb2 = {1, 2, 3, 4, 4};


        System.out.println("tomb1 és tomb2 egyenlő: " + egyenloEgeszTombok(tomb1, tomb2));

    }
}
