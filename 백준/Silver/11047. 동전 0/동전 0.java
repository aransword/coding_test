import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[] coins = new int[N];

        int start = -1;
        // 큰 동전부터 순서대로 넣는다.
        for(int i = N - 1; i >= 0; i--) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
            
            // 탐색 시작 위치를 찾는다.
            if(coin <= K) {
                start = i;
            }
        }

        int cnt;

        while(true) {
            int target = K;
            boolean correct = false;
            cnt = 0;
            
            for(int idx = start; idx < N; idx++) {
                while(target >= coins[idx]) {
                    target -= coins[idx];
                    cnt++;
                }

                if(target == 0) {
                    correct = true;
                    break;
                }
            }

            start++;

            if(correct) {
                break;
            }
        }

        sb.append(cnt);
        System.out.println(sb);
    }
}