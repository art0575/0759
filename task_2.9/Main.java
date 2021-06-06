/*
Задание: Дан массив с числами. Проверьте, что в этом массиве есть число 5. Если есть - выведите 'да', а если нет - выведите 'нет'.
*/

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,6,8,5,4,2};
        String answr  = "Нет";
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 5) answr  = "Да";
        }
        System.out.println(answr);
    }
}
