import java.util.Arrays;

public class E4SelectionSort {
    static int[] numbers = {7, 3, 5, 8, 2};

    public static void main(String[] args) {
        selectionSort();
        System.out.println(Arrays.toString(numbers)); // Imprimir la lista ordenada
    }

    private static void selectionSort() {
        for (int i = 0; i < numbers.length - 1; i++) { // Solo hasta la penúltima posición
            int smaller = numbers[i];
            int index = i; // Ahora `index` inicia correctamente en `i`

            // Buscar el número más pequeño en la parte no ordenada
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < smaller) { // Solo cambia si encontramos un número menor
                    smaller = numbers[j];
                    index = j;
                }
            }

            // Si encontramos un número más pequeño, hacer el intercambio
            if (index != i) {
                int temp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = temp;
            }
        }
    }
}
