import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

    static void listing(int size, int cnt, int[] num, String s, StringBuilder sb, boolean[] isVisited) {
        if(cnt == 1) {
            for(int i = 0; i < size; i++) {
                if(isVisited[i]) {
                    continue;
                }
                sb.append((s + " " + num[i]).replaceFirst(" ", "")).append('\n');
            }
        } else {

            for(int i = 0; i < size; i++) {
                if(isVisited[i]) {
                    continue;
                }
                isVisited[i] = true;
                listing(size, cnt - 1, num, s + " " + num[i], sb, isVisited);
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
        
        String[] numbers = br.readLine().split(" ");
        int[] num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(numbers[i]);
        }

        // 정렬을 우선 수행
        Arrays.sort(num);

        boolean[] isVisited = new boolean[N];
        // 
        listing(N, M, num, "", sb, isVisited);

        System.out.println(sb);
    }
}