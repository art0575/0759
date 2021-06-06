/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/

public class Main {
    public static void main(String[] args) {
        int[] mults = {2,3,4,5};
        int mult = 1;
        for (int i = 0; i < mults.length; i++) {
            mult*= mults[i];
        }
        System.out.println(mult);
    }
}
