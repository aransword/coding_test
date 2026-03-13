import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static void dfs(int min, int max, int cnt, String s, StringBuilder sb) {
        if(cnt == 1) {
            for(int i = min; i <= max; i++) {
                sb.append((s + " " + i).replaceFirst(" ", "")).append('\n');
            }
            return;
        }

        for(int i = min; i <= max; i++) {
            if(max - i < cnt - 1) {
                break;
            }
            dfs(i + 1, max, cnt - 1, s + " " + i, sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        String inpuString = "";
        dfs(1, N, M, inpuString, sb);

        System.out.println(sb);
    }
}