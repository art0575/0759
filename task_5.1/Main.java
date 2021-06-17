/*
* Дана коллекция имён.
* 1) удалить все повторяющиеся имена из коллекции
* 2) вывести коллекцию на экран
* */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");

        names = remove(names);
        System.out.println(names);
    }

    private static ArrayList remove(ArrayList arrayList) {
        ArrayList list = new ArrayList (new LinkedHashSet (arrayList));
        return list;
    }
}
