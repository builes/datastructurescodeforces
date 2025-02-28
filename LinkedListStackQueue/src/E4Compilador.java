import java.util.Scanner;
import java.util.Stack;

public class E4Compilador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el número de casos de prueba
        int casos = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < casos; i++) {
            // Leer la línea de entrada y eliminar los espacios en blanco
            String input = sc.nextLine().replaceAll("\\s+", "");

            // Eliminar el último carácter, que es un punto y coma (;)
            input = input.substring(0, input.length() - 1);

            // Pila para manejar los caracteres de apertura
            Stack<Character> stack = new Stack<>();

            // Bandera para indicar si la expresión es incorrecta
            boolean incorrecto = false;

            // Recorrer cada carácter de la cadena
            for (char c : input.toCharArray()) {
                if (c == '{' || c == '[' || c == '(') {
                    // Si es un carácter de apertura, lo agregamos a la pila
                    stack.push(c);
                } else {
                    // Si es un carácter de cierre, verificamos la pila
                    if (stack.isEmpty() || !esParValido(stack.pop(), c)) {
                        // Si la pila está vacía o el par no coincide, la expresión es incorrecta
                        incorrecto = true;
                        break; // No es necesario seguir revisando
                    }
                }
            }

            // La expresión es incorrecta si la bandera se activó o la pila no está vacía (faltaron cierres)
            System.out.println((incorrecto || !stack.isEmpty()) ? "incorrecta" : "correcta");
        }
    }

    /**
     * Método auxiliar que verifica si un par de caracteres forman un par válido
     * de apertura y cierre.
     *
     * @param apertura Caracter de apertura ('(', '[', '{')
     * @param cierre   Caracter de cierre (')', ']', '}')
     * @return true si el par es válido, false en caso contrario
     */
    private static boolean esParValido(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }
}
