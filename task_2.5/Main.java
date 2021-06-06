/*
Задание: Запросить у пользователя ввод числа и сохранить это число в переменную a.Если переменная a равна 10, то выведите 'Верно', иначе выведите 'Неверно'.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        var a = 0;
        while (true) {
            if (a == 10) break;
            System.out.println("Введите число:");
            a = scan.nextInt();
            if (a != 10) {
                System.out.println("Неверно");
            } else {
                System.out.println("Верно");
            }
        }

    }
}
