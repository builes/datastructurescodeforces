import java.util.ArrayList;
import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            String[] values = sc.nextLine().split(" ");

            if (values[0].equals("end")) {
                break;
            }
            // Si es un número entre 0 y 9, se agrega a la lista
            else if (values[0].matches("[0-9]")) {
                numbers.add(Integer.parseInt(values[0]));
            }
            // Comando 'C' (borrar el último dígito)
            else if (values[0].equals("C")) {
                if (!numbers.isEmpty()) {
                    numbers.remove(numbers.size() - 1);
                }
            }
            // Comando 'D' (borrar los últimos k dígitos)
            else if (values[0].equals("D")) {
                int k = Integer.parseInt(values[1]);

                //Validamos que la cantidad de elemntos a borrar no sea mayor a la cantidad de elementos en el array
                if(numbers.size() < k){
                    continue;
                }

                for (int i = 0; i < k; i++) {
                        if (!numbers.isEmpty()) {
                        numbers.remove(numbers.size() - 1);
                    }
                }
            }
            // Comando 'M' (mostrar los dígitos entre i y j)
            else if (values[0].equals("M")) {
                int index1 = Integer.parseInt(values[1]);
                int index2 = Integer.parseInt(values[2]);

                // Validación de índices
                if (index1 < 1 || index2 < index1 || index2 > numbers.size()) {
                    continue;
                }

                // Imprimir los valores desde index1 hasta index2 (ajustando 1-based a 0-based)
                for (int i = index1 - 1; i < index2; i++) {
                    System.out.print(numbers.get(i));
                }
                System.out.println(); // Nueva línea después de la impresión
            }
        }
    }
}
