/*
Задание: Даны переменные a и b. Проверьте, что a делится без остатка на b. Если это так - выведите 'Делится' и результат деления, иначе выведите 'Делится с остатком' и остаток от деления.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a, b;
        Scanner scanner = new Scanner(System.in);
            System.out.println("Введите переменную a");
            a = scanner.nextInt();
            System.out.println("Введите переменную b");
            b = scanner.nextInt();


        if (a%b != 0) {
            System.out.println("Делится с остатком: " + a%b);
        } else {
            System.out.println(" Делится: " + a/b);

        }
    }
}