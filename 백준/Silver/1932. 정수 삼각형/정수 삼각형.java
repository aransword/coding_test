import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int h = Integer.parseInt(br.readLine());
        // triangle[level][idx]
        // 두 숫자 모두 1부터 h까지를 사용한다.
        int[][] triangle = new int[h + 1][h + 1];
        int[][] max = new int[h + 1][h + 1];

        for(int i = 1; i <= h; i++) {
            String[] level = br.readLine().split(" ");
            for(int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(level[j - 1]);
            }
        }

        max[1][1] = triangle[1][1];
        if(h == 1) {
            sb.append(max[1][1]);
        } else {
            int result = 0;
            // DP 방식으로 각 노드의 최댓값을 구해나간다.
            for(int i = 2; i <= h; i++) {
                max[i][1] = max[i - 1][1] + triangle[i][1];
                max[i][i] = max[i - 1][i - 1] + triangle[i][i];

                if(i == h) {
                    result = Math.max(max[i][1], max[i][i]);
                }

                for(int j = 2; j < i; j++) {
                    max[i][j] = Math.max(max[i - 1][j - 1], max[i - 1][j]) + triangle[i][j];

                    if(max[i][j] > result) {
                        result = max[i][j];
                    }
                }
            }
            sb.append(result);
        }
        
        System.out.println(sb);
    }
}