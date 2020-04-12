import java.util.Random;

public class Main {
    public static void main(String[] args) {
          QuadraticProbingHashTable hashTable = generator(20000);
    }
    private static QuadraticProbingHashTable generator(int numberofelements) {
        QuadraticProbingHashTable structure = new QuadraticProbingHashTable(numberofelements);
        Random random = new Random();
        for (int i = 0; i < numberofelements; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < random.nextInt(20); j++) {
                int choice = random.nextInt(('9' - '0' + 1) + ('Z' - 'A' + 1));
                key.append(((char) (choice < 10 ? '0' + choice : choice - 10 + 'A')));
            }
            structure.insert(key.toString(), random.nextInt() + "");
        }
        return structure;
    }

}