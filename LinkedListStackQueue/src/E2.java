import java.util.Scanner;
import java.util.Stack;

public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < casos; i++) {
            Stack<Integer> stack = new Stack<>();
            String[] values = sc.nextLine().split(" ");

            for (int j = 0; j < values.length; j++) {
                stack.push(Integer.parseInt(values[j]));
            }



            while (true){
                int p = stack.pop();
                int q = stack.pop();

                int sum = p + q;


                if(sum % 2 == 0){
                    stack.push(sum / 2);
                    if(stack.size() == 1) break;
                }else{
                    stack.push(q);
                    stack.push(p);
                    break;
                }
            }

            System.out.println(stack.size() + " " + stack.peek());
        }
    }
}