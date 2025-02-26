import java.util.Arrays;
import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = Integer.parseInt(sc.nextLine());

        String[] values = sc.nextLine().split(" ");

        int[] numbers = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        Arrays.sort(numbers);

        int cases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < cases; i++) {
            String[] postes = sc.nextLine().split(" ");

            int poste1 = Integer.parseInt(postes[0]);
            int poste2 = Integer.parseInt(postes[1]);

            int index1 = Arrays.binarySearch(numbers, poste1);
            int index2 = Arrays.binarySearch(numbers, poste2);

            System.out.println(Math.abs(index1 - index2) + " kms");
        }
    }
}
