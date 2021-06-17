/*
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи
Лондон
Пример вывода:
Абрамовичи */


import java.util.*;

/*
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        while (true) {
            System.out.println("Введите фамилию: ");
            String family = scanner.nextLine();
            if (family.isEmpty()) { break; }
            list.add(family);
            System.out.println("Введите город: ");
            String city = scanner.nextLine();
            if (city.isEmpty()) { break; }
            list.add(city);
        }
        System.out.println(list);
        // Read the house number
        while (true) {
            System.out.println("Поиск по городу. Введите город: ");
            String cityResidence = scanner.nextLine();
            if (list.contains(cityResidence)) {
                int a = list.indexOf(cityResidence);
                System.out.println("В городе: " + list.get(a) + " проживают: " + list.get(a - 1));
            }else System.out.println("Такого города нет");
            break;
        }
    }
}