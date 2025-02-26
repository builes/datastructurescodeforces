import java.util.Arrays;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arraySize = sc.nextInt();
        sc.nextLine();
        String[] numbersString = sc.nextLine().split(" ");
        int[] numbers = new int[arraySize];


        for (int i = 0; i < arraySize; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        calculateReversSum(numbers);

    }

    static void calculateReversSum(int[] arr){
        int sum = arr[arr.length - 1];

        if(arr.length == 1){
            System.out.println(sum);
            return;
        }


        for (int i = arr.length -2; i >= 0 ; i--) {
            sum += arr[i];
            System.out.println(sum);
        }
    }
}
