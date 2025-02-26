import java.util.ArrayList;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        while (true){
            int sumatoriaMultiplos = 0;
            String[] values = sc.nextLine().split(" ");

            if(values.length == 1){
                break;
            }

            String choice = values[0];
            int number = Integer.parseInt(values[1]);


            if(choice.equals("A")){
                nums.add(number);
            }else{
                for (int i = 0; i < nums.size(); i++) {
                    if(nums.get(i) % number == 0){
                        sumatoriaMultiplos += nums.get(i);
                    }
                }
                System.out.println(sumatoriaMultiplos);
            }
        }
    }
}