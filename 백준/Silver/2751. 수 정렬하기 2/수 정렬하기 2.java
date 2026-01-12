import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[2000001];

        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            num[1000000 + input] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2000001; i++) {
            if(num[i]) {
                sb.append(i - 1000000).append('\n');
            }
        }

        System.out.print(sb);
    }

}
