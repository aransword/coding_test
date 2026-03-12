import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        boolean find = false;

        int[] lagRange = new int[n + 1];
        lagRange[1] = 1;

        int maxPow = 1;

        if(!find && n != 1) {
            for(int i = 2; i <= n; i++) {

                if((maxPow + 1) * (maxPow + 1) == i) {
                    maxPow++;
                    lagRange[i] = 1;
                    continue;
                }

                int result = 4;
                for(int j = maxPow; j * j >= 1; j--) {
                    if(lagRange[i - (j * j)] + 1 < result) {
                        result = lagRange[i - (j * j)] + 1;
                    }

                    if(result == 2) {
                        break;
                    }
                }
                lagRange[i] = result;
            }
        }

        sb.append(lagRange[n]);
        System.out.println(sb);
    }
}