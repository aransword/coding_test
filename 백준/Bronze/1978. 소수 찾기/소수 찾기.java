import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        int result = 0;

        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();

            if(a % 2 == 1 && a != 1) {
                boolean prime = true;

                for(int x = 3; x <= a / 2; x = x + 2) {
                    if(a % x == 0) {
                        prime = false;
                        break;
                    }
                }

                if(prime) {
                    result++;
                }
            } else if (a == 2) {
                result++;
            }
        }

        System.out.println(result);

        sc.close();
    }
}