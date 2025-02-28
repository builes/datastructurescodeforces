import java.util.Arrays;

public class E2BubleSort {
    public static void main(String[] args) {
        int[] numbers = {9, 8 , 10, 3, 1};
        System.out.println(Arrays.toString(bubleSort(numbers)));
    }

    static int[] bubleSort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            boolean swaped = false;
            for (int j = 0; j < numbers.length - i -1; j++) {
                if(numbers[j] > numbers[j + 1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                    swaped = true;
                }
            }
            if(!swaped) break;
        }

        return numbers;
    }
}
