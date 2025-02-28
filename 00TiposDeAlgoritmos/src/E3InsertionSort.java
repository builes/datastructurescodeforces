import java.util.Arrays;

public class E3InsertionSort {
    static int[] numbers = {7, 3, 5, 2, 8};

    public static void main(String[] args) {

        // Llamamos al méthodo insertionSort y mostramos el array ordenado
        System.out.println(Arrays.toString(insertionSort(numbers)));

        reversedInsertionSort();
    }



    static int[] insertionSort(int[] numbers) {
        // Recorremos el array desde el segundo elemento hasta el final
        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i]; // Guardamos el valor actual que queremos insertar
            int j = i - 1; // Empezamos comparando con el elemento anterior

            // Desplazamos los elementos mayores que "number" hacia la derecha
            while (j >= 0 && numbers[j] > number) {
                numbers[j + 1] = numbers[j]; // Movemos el elemento hacia la derecha
                j--; // Pasamos al siguiente elemento a la izquierda
            }

            // Insertamos "number" en la posición correcta
            numbers[j + 1] = number;
        }
        return numbers; // Retornamos el array ordenado
    }

    public static void reversedInsertionSort(){
        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] < number){
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = number;
        }

        System.out.println(Arrays.toString(numbers));
    }
}
