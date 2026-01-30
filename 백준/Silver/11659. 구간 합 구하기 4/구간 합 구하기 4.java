import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] num = new int[N + 1];
        int[] sum = new int[N + 1];
        for(int i = 1; i < N + 1; i++) {
            num[i] = sc.nextInt();
            if(i == 1) {
                sum[i] = num[i];
            } else {
                sum[i] = sum[i - 1] + num[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int a = 0; a < M; a++) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            int result;
            if(i == j) {
                result = num[i];
            } else {
                result = sum[j] - sum[i - 1];
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);

        sc.close();
    }
}