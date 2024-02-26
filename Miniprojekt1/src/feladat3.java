import java.util.Scanner;

public class feladat3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("egyes szam: ");
        double num1 = scanner.nextDouble();

        System.out.print("masodik szam ");
        double num2 = scanner.nextDouble();

        System.out.print("valasz 1et (+,-,*,/): ");
        char operator = scanner.next().charAt(0);

        double eredmeny;

        switch (operator) {
            case '+':
                eredmeny = num1 + num2;
                break;
            case '-':
                eredmeny = num1 - num2;
                break;
            case '*':
                eredmeny = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    eredmeny = num1 / num2;
                } else {
                    System.out.println("0val nem lehet osztani");
                    return;
                }
                break;
            default:
                System.out.println("rosszat irtal be");
                return;
        }

        System.out.println("Eredmény: " + eredmeny);
    }
}
