import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer después de leer el número de casos

        for (int i = 0; i < cases; i++) {
            String message = sc.nextLine().replace(" ", "");
            System.out.println(decryptMessage(message));
        }
        sc.close();
    }

    private static String decryptMessage(String message) {
        // Paso 1: Invertir el mensaje
        StringBuilder reversed = new StringBuilder(message).reverse();

        // Paso 2: Reordenar los caracteres
        StringBuilder decrypted = new StringBuilder();
        int length = reversed.length();

        for (int i = 1; i < length; i += 2) {
            decrypted.append(reversed.charAt(i)).append(reversed.charAt(i - 1));
        }
        if (length % 2 != 0) {
            decrypted.append(reversed.charAt(length - 1));
        }

        return decrypted.toString();
    }
}
