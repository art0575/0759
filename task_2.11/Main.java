/*
Задание: Дан массив с числами. Узнайте сколько элементов с начала массива надо сложить, чтобы в сумме получилось больше 10-ти.
*/

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 3, 6, 1};
        int sum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 11) {
                result++;
                sum = sum + nums[i];
            }
        }
        if (sum > 10) {
            System.out.println("Надо сложить "+result+" элементов с начала массива, чтобы сумма получилась больше 10-ти");
        } else {
            System.out.println("Сумма чисел массива меньше или равна 10");
        }

    }
}
