import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int target = sc.nextInt();
            if(Arrays.binarySearch(A, target) < 0) {
                sb.append(0).append('\n');
            } else {
                sb.append(1).append('\n');
            }
        }

        System.out.println(sb);

        sc.close();
    }
}