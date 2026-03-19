import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static void dfs(int[] num, int cnt, int size, String s, StringBuilder sb, boolean[] isVisited) {
        int prev = 0;
        if(cnt == 1) {
            for(int i = 0; i < size; i++) {
                // 미리 정렬되었으므로 같은 레벨에서 동일 숫자만 안나오게.
                if(isVisited[i] || num[i] == prev) {
                    continue;
                }
                prev = num[i];
                sb.append((s + " " + num[i]).replaceFirst(" ", "")).append('\n');
            }
        } else {
            for(int i = 0; i < size; i++) {
                // 미리 정렬되었으므로 같은 레벨에서 동일 숫자만 안나오게.
                if(isVisited[i] || num[i] == prev) {
                    continue;
                }
                isVisited[i] = true;
                prev = num[i];
                dfs(num, cnt - 1, size, s + " " + num[i], sb, isVisited);
                isVisited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] num = new int[N];
        String[] stringNums = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(stringNums[i]);
        }

        // lexicographical하게 출력하기 위한 것.
        Arrays.sort(num);

        boolean[] isVisited = new boolean[N];
        dfs(num, M, N, "", sb, isVisited);

        System.out.println(sb);
        
    }
}