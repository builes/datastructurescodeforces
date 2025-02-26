import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class E2TorreSaruman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringJoiner output = new StringJoiner("\n");
        int casos = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < casos ; i++) {
            String [] valoresAsString = sc.nextLine().split(" ");

            ArrayDeque<Integer> valores = new ArrayDeque<>();

            for (int j = 0; j < valoresAsString.length; j++) {
                valores.push(Integer.parseInt(valoresAsString[j]));
            }
            //System.out.println(valores);
            calculateHeightAndLastValue(valores, output);
        }
        System.out.println(output);
    }


    static void calculateHeightAndLastValue(ArrayDeque<Integer> stack, StringJoiner output){
        while (!stack.isEmpty()){
            if(stack.size() == 1) break;
            int value1 = stack.pop();
            int value2 = stack.pop();
            if ((value1 + value2) % 2 == 0){
                stack.add((value1 + value2) / 2);
            }else{
                stack.push(value1);
                stack.push(value2);
                break;
            }

        }
        output.add(stack.size() + " " + stack.peek());
    }

    /*static void calculateHeightAndLastValue1(int[] arr, StringJoiner output){
        int puntero1 = arr.length - 1;
        int puntero2 = arr.length - 2;

        for (int i = 0; i < arr.length; i++) {
            int suma = arr[puntero1] + arr[puntero2];
            if(suma % 2 == 0){
                arr[puntero2] = suma / 2;
                puntero1--;
                puntero2--;
            }else {
                break;
            }

        }
        output.add(arr.length + " " + arr[puntero1]);
    }
    */

}
