import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int turnos = sc.nextInt();
        sc.nextLine();

        String[] row1 = sc.nextLine().split(", ");
        String[] row2 = sc.nextLine().split(", ");
        String[] row3 = sc.nextLine().split(", ");

        int pointsP1 = 0, pointsP2= 0, pointsP3 = 0;

        for (int i = 0; i < turnos; i++) {
            int n1 = Integer.parseInt(row1[i]);
            int n2 = Integer.parseInt(row2[i]);
            int n3 = Integer.parseInt(row3[i]);

            int total = n1 + n2 + n3;

            if((n1 % 2 == 0 && total % 2 == 0) || (n1 % 2 != 0 && total % 2 != 0)){
                pointsP1++;
            }
            if((n2 % 2 == 0 && total % 2 == 0) || (n2 % 2 != 0 && total % 2 != 0)){
                pointsP2++;
            }
            if((n3 % 2 == 0 && total % 2 == 0) || (n3 % 2 != 0 && total % 2 != 0)){
                pointsP3++;
            }
        }

        System.out.printf("SO:%d, LAR:%d, IS:%d", pointsP1, pointsP2, pointsP3);

    }


}
