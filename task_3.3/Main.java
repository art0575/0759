/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/


public class Main {
    public static void main(String[] args) {
        System.out.println(comparison(5,5));
        System.out.println(comparison(5,3));
        System.out.println(comparison(6,2));
        System.out.println(comparison(7,7));
    }

     static boolean comparison(int num1, int num2) {
         return num1 == num2 ;

    }
}
