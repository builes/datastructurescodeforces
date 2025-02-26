/**
 * Este programa cuenta las ocurrencias de cada número en un arreglo de números enteros ordenado.
 * Para cada número consecutivo, se imprime cuántas veces aparece en el arreglo.
 *
 * El programa recibe un número de casos y luego, para cada caso, un arreglo de números enteros ordenados.
 * El resultado para cada caso es una lista de números que representa la cantidad de veces que aparece
 * cada número consecutivo en el arreglo de entrada.
 *
 * Ejemplo de entrada:
 * 2
 * 1 1 2 2 2 3
 * 4 4 5 6 6 6 6
 *
 * Ejemplo de salida:
 * 2 3 1
 * 2 1 4
 *
 * Explicación:
 * En el primer caso:
 * - El número 1 aparece 2 veces.
 * - El número 2 aparece 3 veces.
 * - El número 3 aparece 1 vez.
 * En el segundo caso:
 * - El número 4 aparece 2 veces.
 * - El número 5 aparece 1 vez.
 * - El número 6 aparece 4 veces.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E2ConteoOcurrencias {

    // Variable para almacenar el resultado de las ocurrencias
    static StringBuilder resultado = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // Creamos un BufferedReader para leer la entrada de la consola de manera eficiente
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Leemos la cantidad de casos
        int casos = Integer.parseInt(br.readLine().trim());

        // Procesamos cada caso
        for (int i = 0; i < casos; i++) {
            // Limpiamos el resultado para cada caso
            resultado.setLength(0);

            // Leemos la línea de números, la dividimos y la convertimos en un arreglo de enteros
            String[] numerosString = br.readLine().split(" ");
            int[] numeros = new int[numerosString.length];
            for (int j = 0; j < numeros.length; j++) {
                numeros[j] = Integer.parseInt(numerosString[j]);
            }

            // Ordenamos el arreglo de números
            Arrays.sort(numeros);

            contarOcurrenciasLinealmente(numeros);
        }
    }

    /**
     * Método que cuenta las ocurrencias de cada número en un arreglo ordenado de manera lineal.
     * Este método recorre el arreglo y cuenta cuántas veces se repite cada número consecutivo.
     * Al finalizar, imprime las ocurrencias de cada número en el arreglo.
     *
     * @param numeros Arreglo de números enteros en el que se contarán las ocurrencias de cada número.
     */
    static void contarOcurrenciasLinealmente(int[] numeros){
        int contador = 1;  // Inicializa el contador para las ocurrencias
        int numeroActual = numeros[0];  // Inicializa el primer número a contar

        // Recorre el arreglo desde el primer número hasta el penúltimo
        for (int i = 0; i < numeros.length - 1; i++) {
            // Si el número actual es igual al siguiente número, incrementa el contador
            if (numeros[i] == numeros[i + 1]) {
                contador++;
            } else {
                // Si los números son diferentes, agrega el contador al resultado
                resultado.append(contador).append(" ");
                // Reinicia el contador para el siguiente número
                contador = 1;
            }
        }

        // Al finalizar, agrega el último número y su contador
        resultado.append(contador);

        // Imprime el resultado con las ocurrencias de cada número
        System.out.println(resultado);
    }

}
