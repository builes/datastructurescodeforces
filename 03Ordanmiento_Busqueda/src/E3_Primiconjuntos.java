import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E3_Primiconjuntos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < casos; i++) {
            String[] values = sc.nextLine().split(" ");
            int elementos = Integer.parseInt(values[0]);
            int p = Integer.parseInt(values[1]);

            // Leer y convertir los números a un array
            String[] stringNumbers = sc.nextLine().split(" ");
            int[] numbers = new int[elementos];

            for (int j = 0; j < elementos; j++) {
                numbers[j] = Integer.parseInt(stringNumbers[j]);
            }

            // Ordenar numbers para hacer búsqueda binaria
            Arrays.sort(numbers);

            // Obtener los divisores de p
            ArrayList<Integer> divisores = new ArrayList<>();
            for (int j = 1; j <= p; j++) {
                if (p % j == 0) {
                    divisores.add(j);
                }
            }

            // Verificar si todos los divisores están en numbers usando búsqueda binaria
            boolean esPrimiConjunto = true;
            for (int divisor : divisores) {
                if (Arrays.binarySearch(numbers, divisor) < 0) {
                    esPrimiConjunto = false;
                    break;
                }
            }

            // Imprimir resultado
            System.out.println(esPrimiConjunto ? "Es PrimiConjunto" : "No es PrimiConjunto");
        }
        sc.close();
    }
}
