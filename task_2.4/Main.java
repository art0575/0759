/*
Задание: Пользователь вводит сумму вклада и процент, который будет начисляться ежегодно. Отобразить размер вклада поочередно на ближайшие 5 лет.
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите размер вклада: ");
        double deposit = scan.nextDouble();

        System.out.println("Введите размер процента: ");
        double percentIn = scan.nextDouble();
        double percent = percentIn / 100;

        for (int i = 1; i < 6; i++) {
            deposit += deposit * percent;
            System.out.println("Ваш вклад к концу "+i+"-го года, с учетом "+percentIn+"% составит: "+deposit+" рублей");
            //System.out.println("Ваш вклад к концу "+i+"-го года, с учетом "+percentIn+"% составит: "+Math.round(deposit)+" рублей");  // С округлением до целого числа

        }

    }
}
