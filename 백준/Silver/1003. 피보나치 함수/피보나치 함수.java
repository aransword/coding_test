import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] fib = new int[41][2];
        int T = sc.nextInt();
        fib[0][0] = 1;
        fib[0][1] = 0;
        fib[1][0] = 0;
        fib[1][1] = 1;

        for(int i = 2; i < 41; i++) {
            fib[i][0] = fib[i-1][0] + fib[i-2][0];
            fib[i][1] = fib[i-1][1] + fib[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++) {
            int input = sc.nextInt();
            if(input == 0) {
                sb.append(1).append(' ').append(0);
            } else {
                sb.append(fib[input][0]).append(' ').append(fib[input][1]);
            }
            sb.append('\n');
        }
        System.out.println(sb);

        sc.close();
    }
}