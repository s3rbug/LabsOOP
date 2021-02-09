package lab1;

import java.util.Scanner;

/**
 * Номер заліковки - 0102
 * C2 = 0 O1 = "+"
 * C3 = 0 C = 0
 * C5 = 2 O2 = "%"
 * C7 = 4 тип індексів i та j = char
 */

public class Main {
    static boolean checkIsNextWrong(Scanner in) {
        if (!in.hasNextInt()) {
            System.out.println("Value can not be calculated. Incorrect input found");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final int C = 0;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter A (int): ");
        final int a = in.nextInt();
        System.out.print("Enter B (int): ");
        if (checkIsNextWrong(in))
            return;
        final int b = in.nextInt();
        System.out.print("Enter N (int): ");
        if (checkIsNextWrong(in))
            return;
        final int n = in.nextInt();
        System.out.print("Enter M (int): ");
        if (checkIsNextWrong(in))
            return;
        final int m = in.nextInt();
        double S = 0;
        if (a < 0 || b < 0 || n < 0 || m < 0) {
            System.out.println("Value can not be calculated. Char can not be negative");
            return;
        }
        if (a > n || b > m) {
            System.out.println("S = 0.0");
            return;
        }
        if ((a + C <= 0 && n + C >= 0) || b == 0) {
            System.out.println("Value can not be calculated. Dividing by zero found");
            return;
        }
        for (char i = (char) a; i < n; ++i) {
            for (char j = (char) b; j < m; ++j) {
                S += (double) i % (double) j / ((double) i + C);
            }
        }
        System.out.println("S = " + S);
    }
}