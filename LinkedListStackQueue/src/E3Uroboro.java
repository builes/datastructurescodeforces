import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E3Uroboro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        String operacion;
        int number = 0;
        do {
            String[] values = sc.nextLine().split(" ");
            if(values.length == 2){
                operacion = values[0];
                number = Integer.parseInt(values[1]);
            }else{
                operacion = values[0];
            }

            if(operacion.equals("agrega")){
                deque.addLast(number);
            } else if (operacion.equals("engulle") && deque.size() >= 1) {
                int numberHead = deque.getFirst();
                int numberTail = deque.getLast();
                if(numberHead > numberTail){
                    deque.removeLast();
                }else{
                    deque.removeFirst();
                }
            }

        } while (!operacion.equals("termina"));
        System.out.println(deque.size() > 0
                ? String.format("cabeza %d cola %d", deque.getFirst(), deque.getLast())
                : "uroboro vacio");

    }
}
