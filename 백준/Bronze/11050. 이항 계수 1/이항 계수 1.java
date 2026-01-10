import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if(k == 0 || k == n) {
            System.out.println(1);
        } else if (k == 1 || k == n - 1) {
            System.out.println(n);
        } else {
            int a = 1;
            int b = 1;

            for(int i = 1; i <= k; i++) {
                a *= (n - i + 1);
                b *= i;
            }
            
            int result = a / b;

            System.out.println(result);

        }


        sc.close();
    }
}
