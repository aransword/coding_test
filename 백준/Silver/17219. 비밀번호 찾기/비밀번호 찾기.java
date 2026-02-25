import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class KV {
    String site;
    String pw;

    public KV(String site, String pw) {
        this.site = site;
        this.pw = pw;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        KV[] kvs = new KV[N];

        for(int i = 0; i < N; i++) {
            String[] infoString = br.readLine().split(" ");
            kvs[i] = new KV(infoString[0], infoString[1]);
        }

        Arrays.sort(kvs, Comparator.comparing(kv -> kv.site));

        for(int i = 0; i < M; i++) {
            String target = br.readLine();
            int result = Arrays.binarySearch(kvs, new KV(target, " "), Comparator.comparing(kv -> kv.site));
            sb.append(kvs[result].pw).append('\n');
        }

        System.out.println(sb);
    }
}