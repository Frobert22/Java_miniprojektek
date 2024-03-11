public class Feladat3 {
    public static void main(String[] args) {
        String bement = "abcasasss";
        StringBuilder erdemeny = new StringBuilder();

        erdemeny.append(bement.charAt(0));

        for (int i = 1; i < bement.length(); i++) {
            char uj = bement.charAt(i);
            char elozo = bement.charAt(i - 1);

            if (uj != elozo) {
                erdemeny.append(uj);
            }
        }

        System.out.println("az alap szo " + bement);
        System.out.println("az eredmeny " + erdemeny);
    }
}
