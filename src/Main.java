import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
          QuadraticProbingHashTable hashTable = generator(129);
        System.out.print("Введите ключ которое хотите найти в хеш-таблице: ");
        String key = scan.nextLine();
        hashTable.get(key);
    }
    private static QuadraticProbingHashTable generator(int numberofelements) {
        QuadraticProbingHashTable structure = new QuadraticProbingHashTable(numberofelements);
        Random random = new Random();
        for (int i = 0; i < numberofelements; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < random.nextInt(100); j++) {
                int choice = random.nextInt(('9' - '0' + 1) + ('Z' - 'A' + 1));
                key.append(((char) (choice < 10 ? '0' + choice : choice - 10 + 'A')));
            }
            structure.insert(key.toString(), random.nextInt() + "");
        }
        return structure;
    }

}