public class Feladat4 {
    public static void main(String[] args) {
        String bemenet = "beeeeppooa";
        StringBuilder rovid = new StringBuilder();

        int szamol = 1;
        for (int i = 0; i < bemenet.length(); i++) {
            if (i + 1 < bemenet.length() && bemenet.charAt(i) == bemenet.charAt(i + 1)) {
                szamol++;
            } else {
                rovid.append(bemenet.charAt(i));
                rovid.append(szamol);
                szamol = 1;
            }
        }

        System.out.println("eredmeny: " + rovid);
    }
}
