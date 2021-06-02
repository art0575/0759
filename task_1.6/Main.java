/*
Пользователь вводит число, необходимо увеличить это число на 15% и вывести результат на экран
*/
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        float count = scan.nextInt();
        System.out.print(15.0*count/100+count);

    }
}
