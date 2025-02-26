/**
 * Este programa gestiona la distribución de entradas para un evento utilizando una fila de compradores.
 * Cada comprador tiene un ID y un número de entradas que desea adquirir.
 * Las reglas para la distribución son las siguientes:
 *
 * 1. Los compradores se procesan en el orden de llegada (FIFO).
 * 2. Si un comprador solicita más entradas de las que quedan disponibles, solo recibe el número restante.
 * 3. Si un comprador puede comprar exactamente las entradas que solicitó y no es el quinto comprador en la fila,
 *    se le permite volver al final de la fila.
 * 4. Cada quinto comprador queda "vetado" y no puede volver a la fila, independientemente de cuántas entradas recibió.
 *
 * Al final del proceso, el programa muestra:
 * - El ID del último comprador procesado y el número de entradas que compró, si se agotaron las entradas.
 * - Un mensaje indicando que sobraron entradas, si no se logró venderlas todas.
 */

import java.util.*;

public class E1TicketQueueManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer los datos iniciales: total de compradores y total de entradas disponibles
        String[] entradaInicial = scanner.nextLine().split(" ");
        int totalCompradores = Integer.parseInt(entradaInicial[0]);
        int totalEntradasDisponibles = Integer.parseInt(entradaInicial[1]);

        // Leer los datos de cada comprador (ID y cantidad de entradas que desea comprar)
        String[] datosCompradores = new String[totalCompradores];
        for (int i = 0; i < totalCompradores; i++) {
            datosCompradores[i] = scanner.nextLine();
        }

        // Procesar las entradas y mostrar el resultado final
        System.out.println(procesarEntradas(totalCompradores, totalEntradasDisponibles, datosCompradores));
    }

    /**
     * Procesa la distribución de entradas según las reglas especificadas.
     *
     * @param totalCompradores El número total de compradores en la fila.
     * @param totalEntradas El número total de entradas disponibles.
     * @param compradores Un arreglo de cadenas donde cada elemento tiene el formato "ID cantidadEntradas".
     * @return Un mensaje con el ID del último comprador procesado y las entradas que compró, o
     *         un mensaje indicando que sobraron entradas.
     */
    public static String procesarEntradas(int totalCompradores, int totalEntradas, String[] compradores) {
        // Cola para manejar a los compradores de forma ordenada (FIFO)
        Queue<int[]> filaCompradores = new LinkedList<>();

        // Inicializar la cola con los compradores
        for (String comprador : compradores) {
            String[] datos = comprador.split(" ");
            int idComprador = Integer.parseInt(datos[0]);
            int cantidadEntradas = Integer.parseInt(datos[1]);
            filaCompradores.add(new int[]{idComprador, cantidadEntradas});
        }

        int compradoresProcesados = 0; // Contador de compradores procesados
        int idUltimoComprador = -1; // ID del último comprador procesado
        int entradasUltimoComprador = -1; // Entradas compradas por el último comprador procesado

        // Procesar la fila mientras haya entradas disponibles y compradores en la cola
        while (!filaCompradores.isEmpty() && totalEntradas > 0) {

            // Tomar al comprador actual
            int[] compradorActual = filaCompradores.poll();
            int id = compradorActual[0];
            int entradasSolicitadas = compradorActual[1];

            // Determinar cuántas entradas puede comprar el comprador actual
            int entradasAComprar = Math.min(entradasSolicitadas, totalEntradas);
            totalEntradas -= entradasAComprar; // Reducir las entradas disponibles

            // Actualizar información del último comprador procesado
            idUltimoComprador = id;
            entradasUltimoComprador = entradasAComprar;

            compradoresProcesados++;

            // Reglas de veto: cada quinto comprador no puede volver a la fila
            if (compradoresProcesados % 5 != 0 && entradasAComprar == entradasSolicitadas) {
                // Solo vuelve si compró exactamente lo que planeaba y no es el quinto comprador
                filaCompradores.add(new int[]{id, entradasSolicitadas});
            }
        }

        // Generar el resultado final según las entradas restantes
        if (totalEntradas == 0) {
            return idUltimoComprador + " " + entradasUltimoComprador;
        } else {
            return "quedaron boletas disponibles";
        }
    }
}
