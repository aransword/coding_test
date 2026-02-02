import java.util.Scanner;

public class Main {
    static int factorial(int i) {
        if(i <= 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++) {
            int n = sc.nextInt();
            int cnt = 0;
            for(int num2 = 0; num2 <= n / 2; num2++) {
                for(int num3 = 0; num3 <= ((n - (num2 * 2)) / 3); num3++) {
                    int num1 = n - (num2 * 2) - (num3 * 3);

                    int totalNum = num1 + num2 + num3;
                    cnt = cnt + factorial(totalNum) / (factorial(num1) * factorial(num2) * factorial(num3));
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);

        sc.close();
    }
}