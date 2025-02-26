import java.util.ArrayList;
import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cases; i++) {
            String[] values = sc.nextLine().split(" ");
            int n = Integer.parseInt(values[0]); // Número de estudiantes
            int k = Integer.parseInt(values[1]); // Paso inicial

            ArrayList<Integer> students = new ArrayList<>();

            // Llenamos la lista con los estudiantes numerados del 1 al N
            for (int j = 1; j <= n; j++) {
                students.add(j);
            }

            int index = 0;
            while (students.size() > 1) {
                index = (index + k - 1) % students.size(); // Encuentra el índice a eliminar
                int removed = students.remove(index); // Elimina al estudiante en esa posición

                // Actualiza K con el módulo entre el número eliminado y los estudiantes restantes
                k = removed % students.size();
                if (k == 0) k = 1; // Si el módulo da 0, K se convierte en 1
            }

            System.out.println(students.getFirst()); // Último estudiante restante es el ganador
        }

        sc.close();
    }
}
