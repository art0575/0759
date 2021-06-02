/*Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".
Подсказка: их 6 штук.
Каждую комбинацию вывести с новой строки. Слова не разделять.
Пример:
МылаРамуМама
РамуМамаМыла
...
Требования:
•	Программа должна выводить текст.
•	Выведенный текст должен содержать 6 строк.
•	Текст в каждой строке должен быть уникален.
•	Должны быть выведены все возможные комбинации. */

public class Main {
    public static void main(String[] args) {
        String combinations[] = {"Мама", "Мыла", "Раму"};
        for (int i = 0; i <combinations.length; i++) {
            for (int j = 0;  j < combinations.length;j++) {
                for (int k = 0; k < combinations.length ;k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    System.out.println(combinations[i] + combinations[j] + combinations[k]);
                }
            }

        }

    }
}
