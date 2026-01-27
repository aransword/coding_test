import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        if(N == 1) {
            System.out.println(0);
            sc.close();
            return;
        }
        
        if(N == 2 || N == 3) {
            System.out.println(1);
            sc.close();
            return;
        }

        int[] cnt = new int[N + 1];

        cnt[2] = 1;
        cnt[3] = 1;
        for(int i = 4; i < N + 1; i++) {
            int min = cnt[i - 1] + 1;
            if(i % 2 == 0 && cnt[i / 2] + 1 < min) {
                min = cnt[i / 2] + 1;
            }
            if(i % 3 == 0 && cnt[i / 3] + 1 < min) {
                min = cnt[i / 3] + 1;
            }
            cnt[i] = min;
        }

        System.out.println(cnt[N]);
        
        sc.close();
    }
}