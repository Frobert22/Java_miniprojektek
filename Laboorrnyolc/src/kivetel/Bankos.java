package kivetel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bankos {
    public static void main(String[] args) {
        int szam;
        boolean rendben = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                szam = sc.nextInt();

                if (szam < 1 || szam > 10) {
                    throw new OutOfBoundsException("1 es 10 kozotti egesz szamot kerek");
                }
                rendben = true;
            } catch (InputMismatchException e) {
                System.out.println("Egész számot kérek");
            } catch (NumberFormatException e) {
                System.out.println("Egész számot kérek újra");
            } catch (OutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        } while (!rendben);
    }
}
