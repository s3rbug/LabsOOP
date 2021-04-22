package lab6;

/*
 *   Номер заліковки - 0102
 *   C13 = 11
 *   Завантажити фургон певного обсягу вантажем на певну суму з різних сортів кави,
 *   що можуть перебувати у різних фізичних станах (зерно, мелена, розчинна в банках
 *   і пакетиках). Ураховувати обсяг кави разом з упаковкою. Провести сортування товарів
 *   на основі співвідношення ціни й ваги. Знайти товар у фургоні, що відповідає заданому
 *   діапазону якості кави.
 * */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static double randomQuality() {
        return Math.round(Math.random() * 10000) / 100.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Мінімальна якість кави: ");
        double minQuality = scanner.nextDouble();
        System.out.print("Максимальна якість кави: ");
        double maxQuality = scanner.nextDouble();
        Coffee[] van = new Coffee[]{new Seed(10, randomQuality()),
                new GroundCoffee(40, randomQuality(), 10, 5),
                new InstantCoffee(75, randomQuality(), 20, 75)};
        System.out.println("Усі види кави з якістю від " + minQuality + " до " + maxQuality + " у фургоні:");
        for (Coffee c : van) {
            if (c.getQuality() >= minQuality && c.getQuality() <= maxQuality) {
                System.out.println(c);
            }
        }
        Arrays.sort(van, Comparator.comparing(Coffee::pricePerVolume));
        System.out.println("Посортовано за відношенням ціни до ваги:");
        for (Coffee c : van) {
            System.out.println(c);
        }
    }
}
