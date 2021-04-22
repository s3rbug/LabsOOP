package lab4;
/*
 *  Номер заліковки - 0102
 *  C11 = 3 => Визначити клас літак, який складається як мінімум з 5-и полів.
 * */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static boolean checkIsNextInt(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Value can not be calculated. Incorrect input found");
            return false;
        }
        return true;
    }

    static void printArray(Plane[] planes, int peopleCount) {
        for (int i = 0; i < planes.length; ++i) {
            if (planes[i].checkEnoughPlace(peopleCount)) {
                System.out.println("Достатньо місця усім пасажирам");
            } else {
                System.out.println("Увага! Усім пасажирам не вистачить місць");
            }
            System.out.println("Номер елемента - " + (i + 1));
            System.out.println(planes[i] + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість людей на рейсі: ");
        if (!checkIsNextInt(scanner)) {
            return;
        }
        int countPeople = scanner.nextInt();
        Plane[] planes = new Plane[]{
                new Plane("Гарний літак", 1000, 130, 100, true),
                new Plane("Чудовий літак", 750, 200, 20, true),
                new Plane("Хороший літак", 800, 70, 50, false)
        };
        System.out.println("До сортування: ");
        printArray(planes, countPeople);
        Arrays.sort(planes, Comparator.comparing(Plane::getSpeed));
        System.out.println("Посортовано за швидкістю");
        printArray(planes, countPeople);
        Arrays.sort(planes, Comparator.comparing(Plane::getMaxCountOfPeople).reversed());
        System.out.println("Посортовано за спаданням максимальної кількості пасажирів");
        printArray(planes, countPeople);
    }
}
