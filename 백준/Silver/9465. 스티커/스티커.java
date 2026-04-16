import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] row1 = br.readLine().split(" ");
            String[] row2 = br.readLine().split(" ");

            int[][] stickers = new int[2][n];
            for(int j = 0; j < n; j++) {
                stickers[0][j] = Integer.parseInt(row1[j]);
                stickers[1][j] = Integer.parseInt(row2[j]);
            }

            int[][] max = new int[2][n];

            int result = 0;

            if(n == 1) {
                result = Math.max(stickers[0][0], stickers[1][0]);
            } else if(n == 2) {
                max[0][0] = stickers[0][0];
                max[1][0] = stickers[1][0];
                max[0][1] = max[1][0] + stickers[0][1];
                max[1][1] = max[0][0] + stickers[1][1];

                result = Math.max(max[0][1], max[1][1]);
            } else {
                max[0][0] = stickers[0][0];
                max[1][0] = stickers[1][0];
                max[0][1] = max[1][0] + stickers[0][1];
                max[1][1] = max[0][0] + stickers[1][1];
    
                for(int j = 2; j < n; j++) {
                    max[0][j] = Math.max(max[1][j - 1], max[1][j - 2]) + stickers[0][j];
                    max[1][j] = Math.max(max[0][j - 1], max[0][j - 2]) + stickers[1][j];
                }
    
                result = Math.max(max[0][n - 1], max[1][n - 1]);
            }
            
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}