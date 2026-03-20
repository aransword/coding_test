import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N][3];
        
        for(int i = 0 ; i < N; i++) {
            String[] colors = br.readLine().split(" ");
            for(int j = 0; j < 3; j++) {
                house[i][j] = Integer.parseInt(colors[j]);
            }
        }
        int[][] sum = new int[N][3];
        sum[0][0] = house[0][0];
        sum[0][1] = house[0][1];
        sum[0][2] = house[0][2];

        for(int i = 1; i < N; i++) {
            sum[i][0] += house[i][0] + Math.min(sum[i - 1][1], sum[i - 1][2]);
            sum[i][1] += house[i][1] + Math.min(sum[i - 1][0], sum[i - 1][2]);
            sum[i][2] += house[i][2] + Math.min(sum[i - 1][0], sum[i - 1][1]);
        }

        int result = sum[N - 1][0];
        if(result > sum[N - 1][1]) {
            result = sum[N - 1][1];
        }
        if(result > sum[N - 1][2]) {
            result = sum[N - 1][2];
        }

        sb.append(result);
        System.out.println(sb);
    }
}