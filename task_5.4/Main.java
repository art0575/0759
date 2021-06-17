/*
1. Ввести путь к файлу с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
-2
11
3
-5
2
10
Пример вывода:
-2
2
8
10
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");
        String filePath = scanner.nextLine();
        ArrayList<Integer> file_nums = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            int i;
            String num = "";
            try {
                while (true) {
                    i = fis.read();
                    if (i == 13 || i == 10 || i == -1) {
                        if (num != "") {
                            file_nums.add(Integer.parseInt(num));
                            num = "";
                        }
                        if (i== -1) break;
                    } else num += (char)i;
                }
                System.out.println("Набор всех чисел: \n"+file_nums);
                Collections.sort(file_nums);
                int index = 0;
                while (file_nums.size() > index){
                    if (file_nums.get(index)%2 !=0) file_nums.remove(index);
                    else index++;
                }
                System.out.println("Набор четных чисел, сортрованные по возрастанию: \n"+file_nums);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}