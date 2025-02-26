import java.util.ArrayList;
import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Lista para almacenar los turnos máximos permitidos por cada persona
        ArrayList<Integer> maxTurns = new ArrayList<>();
        // Lista para almacenar los nombres de las personas
        ArrayList<String> persons = new ArrayList<>();

        while (true) {
            // Leer la línea de entrada y dividir por espacios
            String[] values = sc.nextLine().split(" ");

            String person = values[0]; // Nombre de la persona
            int max = Integer.parseInt(values[1]); // Número máximo de turnos

            // Condición de terminación (cuando ambos valores son "0")
            if (person.equals("0") && max == 0) break;

            int currentSize = maxTurns.size(); // Guardamos el tamaño de la lista

            // Solo agregamos si el nuevo máximo es mayor al número actual de elementos
            if (max > currentSize) {
                persons.add(person);
                maxTurns.add(max);
            }

            // Verificar si alguien debe ser eliminado según la nueva cantidad de turnos
            for (int i = currentSize - 1; i >= 0; i--) {
                if (maxTurns.get(i) < maxTurns.size()) {
                    maxTurns.remove(i);
                    persons.remove(i);
                    break; // Solo eliminamos un elemento por iteración
                }
            }
        }

        // Imprimir la cantidad de personas restantes
        System.out.println(maxTurns.size());
    }
}
