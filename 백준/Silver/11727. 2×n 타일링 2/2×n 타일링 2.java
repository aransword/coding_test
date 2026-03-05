import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[1001];
        cnt[1] = 1;
        cnt[2] = 3;

        int n = Integer.parseInt(br.readLine());

        for(int i = 3; i <= n; i++) {
            cnt[i] = ((cnt[i - 2] * 2) + (cnt[i - 1])) % 10007;
        }

        sb.append(cnt[n]);
        System.out.println(sb);
    }
}