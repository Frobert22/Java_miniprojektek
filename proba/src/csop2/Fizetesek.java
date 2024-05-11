package csop2;

import java.io.*;
import java.util.Scanner;

public class Fizetesek {
    public static void main(String[] args) {
        File src = new File("fizetesek.dat");
        try {
            DataOutputStream fizetesekOut = new DataOutputStream(new FileOutputStream(src));
            Scanner sc = new Scanner(System.in);
            double fizetes;

            while ((fizetes = sc.nextDouble()) != -1) {
                fizetesekOut.writeDouble(fizetes);
            }
            fizetesekOut.close();

            // Olvasás

            DataInputStream fizetesekIn = new DataInputStream(new FileInputStream(src));
            while (fizetesekIn.available() > 0) {
                System.out.println(fizetesekIn.readDouble());
            }
            fizetesekIn.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {

        }
    }
}
