import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cases; i++) {
            int size = Integer.parseInt(sc.nextLine());
            String[] numbersString = sc.nextLine().split(" ");
            int[] numbers = new int[size];
            boolean[] visited = new boolean[size]; // Marca los índices visitados

            for (int j = 0; j < size; j++) {
                numbers[j] = Integer.parseInt(numbersString[j]);
            }

            int index = 0;
            int counter = 0;

            while (index >= 0 && index < size) {
                if (visited[index]) { // Si ya visitamos el índice, hay un ciclo
                    break;
                }
                visited[index] = true; // Marcamos este índice como visitado

                index += numbers[index]; // Saltamos según el valor del índice actual
                counter++;
            }

            System.out.println(counter);
        }

        sc.close();


    }
}
