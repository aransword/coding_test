import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] padovan = new long[101];
        padovan[1] = 1;
        padovan[2] = 1;
        padovan[3] = 1;
        padovan[4] = 2;
        padovan[5] = 2;

        for(int i = 6; i < 101; i++) {
            padovan[i] = padovan[i - 1] + padovan[i - 5];
        }

        int test_case = Integer.parseInt(br.readLine());

        for(int t = 0; t < test_case; t++) {
            int N = Integer.parseInt(br.readLine());

            if(t <test_case - 1) 
                sb.append(padovan[N]).append('\n');
            else
                sb.append(padovan[N]);
        }

        System.out.println(sb);
    }
}