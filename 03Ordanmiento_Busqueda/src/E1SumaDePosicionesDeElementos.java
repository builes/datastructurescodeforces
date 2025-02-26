import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E1SumaDePosicionesDeElementos {
    public static void main(String[] args) throws IOException {

        // Inicializamos el contador para la suma de las posiciones encontradas
        int sumaTotalDePosiciones = 0;

        // Creamos un BufferedReader para leer la entrada de la consola de manera eficiente
        BufferedReader lectorDeEntrada = new BufferedReader(new InputStreamReader(System.in));

        // Leemos la cantidad de elementos en el arreglo y lo convertimos a entero
        int tamañoDelArreglo = Integer.parseInt(lectorDeEntrada.readLine().trim());

        // Creamos un arreglo para almacenar los números ordenados que vamos a leer
        int[] arregloOrdenado = new int[tamañoDelArreglo];

        // Leemos la línea de entrada, la dividimos por espacios y la almacenamos en el arreglo 'arregloOrdenado'
        String[] linea = lectorDeEntrada.readLine().split(" ");

        // Convertimos cada elemento de 'linea' a entero y lo almacenamos en 'arregloOrdenado'
        for (int i = 0; i < tamañoDelArreglo; i++) {
            arregloOrdenado[i] = Integer.parseInt(linea[i]);
        }

        // Leemos la cantidad de elementos que vamos a buscar en el arreglo
        int cantidadDeElementosABuscar = Integer.parseInt(lectorDeEntrada.readLine().trim());

        // Creamos un arreglo para almacenar los elementos que necesitamos buscar
        int[] elementosABuscar = new int[cantidadDeElementosABuscar];

        // Leemos los elementos a buscar, los dividimos y los convertimos a enteros
        linea = lectorDeEntrada.readLine().split(" ");
        for (int i = 0; i < cantidadDeElementosABuscar; i++) {
            elementosABuscar[i] = Integer.parseInt(linea[i]);
        }

        // Iteramos sobre cada elemento que necesitamos buscar
        for (int elemento : elementosABuscar) {
            // Usamos la búsqueda binaria para encontrar el índice del número en el arreglo 'arregloOrdenado'
            int indice = Arrays.binarySearch(arregloOrdenado, elemento);

            // Si el índice es mayor o igual a 0, significa que encontramos el número
            if (indice >= 0) {
                // Sumamos el índice + 1 al contador, ya que la búsqueda binaria devuelve un índice basado en 0
                sumaTotalDePosiciones = sumaTotalDePosiciones + indice + 1;
            }
        }

        // Imprimimos el contador que contiene la suma de las posiciones encontradas
        System.out.println(sumaTotalDePosiciones);
    }
}
