/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.

*/


public class Main {
    public static void main(String[] args) {
        System.out.println(sum(5,5));
        System.out.println(sum(5,3));
        System.out.println(sum(6,2));
        System.out.println(sum(7,7));

    }

    public static boolean sum(int num1, int num2){
        return num1 + num2 > 10;

    }
}
