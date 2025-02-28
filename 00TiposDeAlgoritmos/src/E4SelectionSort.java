import java.util.Arrays;

public class E4SelectionSort {
    static int[] numbers = {7, 3, 5, 8, 2};

    public static void main(String[] args) {
        selectionSort();  // Llamamos al método para ordenar
        System.out.println(Arrays.toString(numbers)); // Imprimimos la lista ordenada
    }

    private static void selectionSort() {
        int n = numbers.length;

        // Recorremos la lista hasta la penúltima posición
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Suponemos que el número más pequeño está en 'i'

            // Buscamos el número más pequeño en el resto de la lista
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j; // Guardamos la posición del número más pequeño encontrado
                }
            }

            // Si encontramos un número menor, hacemos el intercambio
            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }
    }
}
