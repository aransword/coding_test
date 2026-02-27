import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int stair_cnt = Integer.parseInt(br.readLine());
        int[] stairs = new int[stair_cnt];
        int[] sum = new int[stair_cnt];

        for(int i = 0; i < stair_cnt; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        sum[0] = stairs[0];

        if(stair_cnt >= 2) {
            sum[1] = stairs[0] + stairs[1];
        }

        if(stair_cnt >= 3) {
            sum[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
        }

        for(int i = 3; i < stair_cnt; i++) {
            sum[i] = Math.max(sum[i - 2], sum[i - 3] + stairs[i - 1]) + stairs[i];
        }


        sb.append(sum[stair_cnt - 1]);
        System.out.println(sb);
    }
}