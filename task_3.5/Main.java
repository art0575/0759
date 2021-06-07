/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/

public class Main {
    public static void main(String[] args) {

        int num[] = {4,2,6,2,65};
        int numbs = num.length;
        reCrsv(num,numbs);
    }
    public static void reCrsv(int[] nums, int num) {
        if (num == 0 || nums.length == 0) return;
        reCrsv(nums,num-1);
        System.out.print(" " + nums[num - 1]);
    }
}

