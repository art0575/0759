/*
 * Задание: Дана коллекция с числами. Запишите в новую коллекцию только те числа, которые больше нуля и меньше 10-ти.
 * Коллекции вы создаёте сами
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> newCollection = new ArrayList<Integer>();

        numbers.add(-2);
        numbers.add(11);
        numbers.add(5);
        numbers.add(-18);
        numbers.add(4);
        numbers.add(7);
        numbers.add(13);
        numbers.add(3);

        for (Integer i : numbers) {
            if (i > 0 && i < 10)  newCollection.add (i);
        };


        System.out.println("Исходная коллекция с числами:\n" + numbers+"\n");
        System.out.println("Коллекция чисел больше нуля и меньше 10-ти:\n" + newCollection);

    }
}
