/*Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 4 ...
2 4 6 8 ...
3 6 9 12 ...
4 8 12 16 ...
... */
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <11 ; i++) {
            for (int j = 1; j < 11; j++) System.out.print(i * j + " ");
            System.out.println();
        }

    }
}
