/*
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример вывода на экран:
8
88
888
8888
88888
888888
8888888
88888888
888888888
8888888888
*/

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String num ="";
            for (int j = 1; j <= i; j++) num += 8;
            System.out.println(num);
        }

    }
}
