import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E5Audiencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < casos; i++) {
            String[] valores = sc.nextLine().split(" ");
            int N = Integer.parseInt(valores[0]); // Número de ciudadanos en la fila
            int k = Integer.parseInt(valores[1]) - 1; // Posición de Elfo (convertida a índice)

            String[] peticionesString = sc.nextLine().split(" ");
            Queue<int[]> fila = new LinkedList<>();

            for (int j = 0; j < N; j++) {
                int peticiones = Integer.parseInt(peticionesString[j]);
                fila.add(new int[]{peticiones, j == k ? 1 : 0}); // {peticiones, esElfo}
            }

            int tiempoTotal = 0;

            while (!fila.isEmpty()) {
                int[] actual = fila.poll(); // Se atiende a la persona en turno
                tiempoTotal += 5; // Cada petición toma 5 minutos
                actual[0]--; // Se resuelve una petición

                if (actual[0] > 0) {
                    fila.add(actual); // Si le quedan peticiones, regresa al final de la fila
                }

                // Si es Elfo y ya no tiene peticiones, terminamos
                if (actual[1] == 1 && actual[0] == 0) {
                    break;
                }
            }

            System.out.println(tiempoTotal);
        }
        sc.close();
    }
}
