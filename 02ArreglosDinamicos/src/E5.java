import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // Tamaño múltiplo para calcular la mediana
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break; // Fin de entrada

            numbers.add(n);

            if (numbers.size() % M == 0) { // Si el tamaño es múltiplo de M
                Collections.sort(numbers); // Ordenar la lista

                int size = numbers.size();
                if (size % 2 != 0) {
                    // Si es impar, imprimir el valor central
                    System.out.println(numbers.get(size / 2));
                } else {
                    // Si es par, calcular el promedio de los dos valores centrales
                    int value = numbers.get(size / 2 - 1) + numbers.get(size / 2);
                    if (value % 2 == 0) {
                        System.out.println(value / 2); // Es un número entero
                    } else {
                        System.out.println(value + "/2"); // Mostrar como fracción
                    }
                }
            }
        }
    }
}
