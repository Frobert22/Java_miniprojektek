package csop2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamAverage {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new FileReader("./src/csop2/teszt.in"));
            sc.useDelimiter("\\s*\\|\\s*");
            while (sc.hasNext()) {
                String nev = sc.next();
                String etr = sc.next();
                int jegy = sc.nextInt();
                String szak = sc.next();
                Student student = new Student(nev, etr, jegy, szak);
                studentList.add(student);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        double atlag=3.25;
        try {
            PrintWriter pw=new PrintWriter(new FileWriter("./src/csop2/teszt.out"));
            pw.printf("%-15s %-7s\n","Nev","Jegy");
            for (Student s : studentList){
                pw.printf("%-15s %-7s\n","Nev","Jegy");

            }
            pw.println("Atlag:"+atlag);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


