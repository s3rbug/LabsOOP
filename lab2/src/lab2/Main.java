package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Номер заліковки - 0102
 * C5 = 2 => C = A + B
 * C7 = 4 => тип елементів long
 * C11 = 3 => сума найбільших елементів кожного рядка матриці
 */

public class Main {
    static boolean checkIsNextWrong(Scanner in) {
        if (!in.hasNextInt()) {
            System.out.println("Incorrect file data");
            return true;
        }
        return false;
    }

    static long[][] enterArray(Scanner in, int n, int m) {
        long[][] a = new long[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                a[i][j] = in.nextLong();
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return a;
    }

    static long[][] sumArrays(long[][] a, long[][] b, int n, int m){
        long[][] c = new long[n][m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                c[i][j] = a[i][j] + b[i][j];
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        return c;
    }

    static long findRowMax(long[][] a, int m, int index){
        long max = a[index][0];
        for(int j = 1; j < m; ++j)
            max = Math.max(max, a[index][j]);
        return max;
    }

    public static void main(String[] args) {
        long[][] a, b;
        try {
            File inputFile = new File("lab2/input.txt");
            Scanner in = new Scanner(inputFile);
            if (checkIsNextWrong(in))
                return;
            int n = in.nextInt();
            if (checkIsNextWrong(in))
                return;
            int m = in.nextInt();
            System.out.println("Матриця А: ");
            a = enterArray(in, n, m);
            System.out.println("Матриця B: ");
            b = enterArray(in, n, m);
            System.out.println("Матриця A + B");
            long[][] c = sumArrays(a, b, n, m);
            long sum = 0;
            for(int i = 0; i < n; ++i){
                sum += findRowMax(c, m, i);
            }
            System.out.println("Сума найбільших елементів у рядках - " + sum);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено");
            e.printStackTrace();
            return;
        }
    }
}
