import java.util.Arrays;
import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = Integer.parseInt(sc.nextLine());

        String[] letters = sc.nextLine().split(", ");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < total / 2; i++) {
            result.append(letters[i]);
            result.append(letters[total - 1 - i]);
        }

        if (total % 2 != 0) {
            result.append(letters[total / 2]);
        }

        System.out.println(result.toString());


    }
}
