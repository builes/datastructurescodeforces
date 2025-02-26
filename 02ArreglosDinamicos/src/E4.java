import java.util.ArrayList;
import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break; // Termina la entrada

            boolean removed = false;

            // Buscar y eliminar n si existe
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == n) {
                    numbers.remove(i);
                    removed = true;
                    break; // Solo eliminamos un número y salimos
                }
            }

            // Si no se eliminó n, intentar eliminar n+1
            if (!removed) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == n + 1) {
                        numbers.remove(i);
                        removed = true;
                        break;
                    }
                }
            }

            // Si no se eliminó n+1, intentar eliminar n-1
            if (!removed) {
                for (int i = 0; i < numbers.size(); i++) {
                    if (numbers.get(i) == n - 1) {
                        numbers.remove(i);
                        removed = true;
                        break;
                    }
                }
            }

            // Si no se eliminó ningún número, agregar n
            if (!removed) {
                numbers.add(n);
            }
        }

        // Imprimir resultado final
        if (numbers.isEmpty())  System.out.println(0);

        for (Integer n : numbers){
            System.out.print(n + " ");
        }
    }
}
