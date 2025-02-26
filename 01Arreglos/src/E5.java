import java.util.Arrays;
import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte cases = Byte.parseByte(sc.nextLine());

        for (int i = 0; i < cases ; i++) {
            String[] values = sc.nextLine().split(" ");

            //Cantidad de integrantes
            byte m = Byte.parseByte(values[0]);

            //Cantidad de monedas y bileltes
            short n = Short.parseShort(values[1]);

            String[] coinsString = sc.nextLine().split(" ");

            short[] coins = new short[coinsString.length];

            for (int j = 0; j < coins.length; j++) {
                coins[j] = Short.parseShort(coinsString[j]);
            }

            int[] sums = new int[m];

            for (int j = 0; j < coins.length ; j++) {
                int index = j % m;
                sums[index] += coins[j];
            }

            Arrays.sort(sums);
            int difference = sums[sums.length - 1] - sums[0];

            System.out.println(difference);
        }



    }
}
