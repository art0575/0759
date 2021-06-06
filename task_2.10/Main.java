/*
Задание: Дан массив с числами. Проверьте, есть ли в нем два одинаковых числа подряд. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,3,7,6,6,9,5,8,2};
        String answr  = "Нет";
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1] && nums[i] < nums.length) answr  = "Да";
        }
        System.out.println(answr);

    }
}
